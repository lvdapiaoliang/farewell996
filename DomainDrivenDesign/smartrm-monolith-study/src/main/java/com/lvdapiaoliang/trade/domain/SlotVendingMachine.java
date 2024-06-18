package com.lvdapiaoliang.trade.domain;

import com.google.common.collect.Maps;
import com.lvdapiaoliang.device.domain.event.PopSuccessEvent;
import com.lvdapiaoliang.infracore.aggregate.AggregateBase;
import com.lvdapiaoliang.infracore.api.CommonError;
import com.lvdapiaoliang.infracore.event.DomainEventBus;
import com.lvdapiaoliang.infracore.exception.DomainException;
import com.lvdapiaoliang.infracore.idgenerator.UniqueIdGeneratorUtil;
import com.lvdapiaoliang.payment.domain.PlatformType;
import com.lvdapiaoliang.trade.domain.remote.CommodityInfo;
import com.lvdapiaoliang.trade.domain.remote.InventoryInfo;
import com.lvdapiaoliang.trade.domain.remote.TradeCommodityService;
import com.lvdapiaoliang.trade.domain.remote.TradeDeviceService;
import com.lvdapiaoliang.trade.domain.remote.TradePayService;
import com.lvdapiaoliang.trade.infrastructure.TradeError;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: lvguopeng
 * @description: 交易上下文货道售卖机
 */
public class SlotVendingMachine extends AggregateBase {

  private static Logger LOGGER = LoggerFactory.getLogger(SlotVendingMachine.class);

  //货道售卖机id
  private long machineId;

  //货道售卖机状态
  private SlotVendingMachineState state;

  //货道售卖机正在交易的订单对象
  private Order curOrder;

  private SlotVendingMachine() {

  }

  public long getMachineId() {
    return machineId;
  }

  public SlotVendingMachineState getState() {
    return state;
  }

  public Order getCurOrder() {
    return curOrder;
  }

  /**
   * 货道售卖机 获取 交易上下文-售卖机商品列表 方法
   * @author lvguopeng
   * @date 2023/4/7 20:09
   * @param deviceService:
   * @param commodityService:
   * @return VendingMachineCommodityList
   */
  public VendingMachineCommodityList getCommodityList(TradeDeviceService deviceService,
      TradeCommodityService commodityService) {
    List<InventoryInfo> inventoryInfos = deviceService.getInventory(machineId);
    List<CommodityInfo> commodityInfos = commodityService.getCommodityList(
        inventoryInfos.stream().map(inventoryInfo -> inventoryInfo.getCommodityId()).collect(
            Collectors.toList()));
    Map<String, Integer> inventoryMap = Maps.newHashMap();
    inventoryInfos.forEach(info -> inventoryMap.put(info.getCommodityId(), info.getCount()));
    List<StockedCommodity> commodities = commodityInfos.stream()
        .map(info -> new StockedCommodity(
            info.getCommodityId(),
            info.getCommodityName(),
            info.getImageUrl(),
            info.getPrice(),
            inventoryMap.get(info.getCommodityId()))).collect(Collectors.toList());
    return new VendingMachineCommodityList(machineId, commodities);
  }

  private boolean checkInventory(Collection<StockedCommodity> commodities,
      TradeDeviceService deviceService) {
    List<InventoryInfo> inventoryInfos = deviceService.getInventory(machineId);
    Map<String, Integer> inventoryMap = Maps.newHashMap();
    inventoryInfos.forEach(info -> inventoryMap.put(info.getCommodityId(), info.getCount()));
    for (StockedCommodity stocked : commodities) {
      Integer count = inventoryMap.get(stocked.getCommodityId());
      if (count == null || count < stocked.getCount()) {
        return false;
      }
    }
    return true;
  }

  /**
   * 货道售卖机正在交易的订单是在选择商品的过程中生成的
   * 所以，货道售卖机的selectCommodity方法就是订单的工厂方法。
   * @author lvguopeng
   * @date 2023/4/7 20:12
   * @param commodities:
   * @param deviceService:
   * @param payService:
   * @param platformType:
   * @return PaymentQrCode
   */
  public PaymentQrCode selectCommodity(Collection<StockedCommodity> commodities,
      TradeDeviceService deviceService, TradePayService payService, PlatformType platformType) {
    //校验设备状态
    if (state != SlotVendingMachineState.Ready) {
      throw new DomainException(TradeError.VendingMachineStateNotRight);
    }
    //校验库存
    if (!checkInventory(commodities, deviceService)) {
      throw new DomainException(TradeError.InventoryCheckFail);
    }
    //生成订单
    curOrder = this.generateOrder(commodities);
    emitEvent(new OrderCreatedEvent(this.machineId, curOrder));
    //设置货到售卖机的状态为 正在交易的状态
    state = SlotVendingMachineState.Trading;
    //开始扫码支付，获取支付二维码
    PaymentQrCode ret = payService.startQrCodePayForOrder(platformType, curOrder);
    curOrder.setPaymentId(ret.getPaymentId());
    incVersion();
    return ret;
  }

  private Order generateOrder(Collection<StockedCommodity> commodities) {
    return Order.Builder()
        .commodities(commodities)
        .orderId(UniqueIdGeneratorUtil.instance().nextId())
        .state(OrderState.Start)
        .type(OrderType.SlotQrScanePaid)
        .machineId(this.machineId)
        .eventBus(eventBus)
        .build();
  }

  public void finishOrder(long orderId, TradeDeviceService deviceService) throws Exception {
    if (this.curOrder == null || this.curOrder.getOrderId() != orderId) {
      LOGGER.warn("order finished when slot vending machine has release it:{},{}", machineId,
          orderId);
      return;
    }
    //弹出商品
    if (curOrder.getCommodities().size() > 1) {
      throw new DomainException(CommonError.UnExpected)
          .withMsg("slot vending machine only support one commodity order");
    }
    for (StockedCommodity commodity : curOrder.getCommodities()) {
      deviceService
          .popCommodity(curOrder.getMachineId(), commodity.getCommodityId(), curOrder.getOrderId());
    }
    this.curOrder.succeed();
    this.state = SlotVendingMachineState.Popping;
    incVersion();
  }

  public void cancelOrder() {
    if (curOrder == null || curOrder.getState() == OrderState.Canceled) {
      LOGGER.warn("cancel order state not right.");
      return;
    }
    curOrder.cancel();
    state = SlotVendingMachineState.Ready;
//    curOrder = null;
    incVersion();
  }

  public void onPopSuccess(PopSuccessEvent event) {
    if (state == SlotVendingMachineState.Popping && curOrder != null
        && curOrder.getOrderId() == event.getOrderId()) {
      ready();
    }
  }

  public void ready() {
    if (state == SlotVendingMachineState.Ready) {
      return;
    }
    state = SlotVendingMachineState.Ready;
    incVersion();
  }

  public static Builder Builder() {
    return new Builder();
  }

  public static class Builder {

    private long machineId;

    private SlotVendingMachineState state;

    private Order curOrder;

    private long version;

    private DomainEventBus eventBus;

    public Builder machineId(long machineId) {
      this.machineId = machineId;
      return this;
    }

    public Builder state(SlotVendingMachineState state) {
      this.state = state;
      return this;
    }

    public Builder curOrder(Order curOrder) {
      this.curOrder = curOrder;
      return this;
    }

    public Builder eventBus(DomainEventBus eventBus) {
      this.eventBus = eventBus;
      return this;
    }

    public Builder version(long version) {
      this.version = version;
      return this;
    }

    public SlotVendingMachine build() {
      if (this.eventBus == null) {
        throw new DomainException(CommonError.UnExpected);
      }
      SlotVendingMachine machine = new SlotVendingMachine();
      machine.curOrder = this.curOrder;
      machine.machineId = this.machineId;
      machine.state = this.state;
      machine.setEventBus(this.eventBus);
      machine.version = this.version;
      return machine;
    }

  }

}
