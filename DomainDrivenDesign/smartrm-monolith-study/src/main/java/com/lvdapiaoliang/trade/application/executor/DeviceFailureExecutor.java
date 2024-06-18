package com.lvdapiaoliang.trade.application.executor;

import com.lvdapiaoliang.device.domain.event.DeviceFailureEvent;
import com.lvdapiaoliang.infracore.scheduler.RetryExecutorBase;
import com.lvdapiaoliang.trade.domain.Order;
import com.lvdapiaoliang.trade.domain.SlotVendingMachine;
import com.lvdapiaoliang.trade.domain.repository.OrderRepository;
import com.lvdapiaoliang.trade.domain.repository.VendingMachineRepository;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: lvguopeng
 * @description:
 */
@Component
public class DeviceFailureExecutor extends RetryExecutorBase {

  private static Logger LOGGER = LoggerFactory.getLogger(DeviceFailureExecutor.class);

  @Autowired
  VendingMachineRepository machineRepository;

  @Autowired
  OrderRepository orderRepository;

  @Override
  @Transactional
  public void run(Map<String, Object> params) {
    DeviceFailureEvent event = (DeviceFailureEvent) params.get("event");
    SlotVendingMachine machine = machineRepository.getSlotVendingMachineById(
        event.getMachineId());
    LOGGER.info("running: {}", event.toString());
    if (machine.getCurOrder() != null
        && machine.getCurOrder().getOrderId() == event.getOrderId()) {
      machine.cancelOrder();
    } else {
      Order order = orderRepository.getOrderById(event.getOrderId());
      order.cancel();
      orderRepository.updateOrder(order);
    }
  }
}
