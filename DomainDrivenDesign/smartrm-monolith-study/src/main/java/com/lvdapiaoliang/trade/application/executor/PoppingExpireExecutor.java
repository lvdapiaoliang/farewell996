package com.lvdapiaoliang.trade.application.executor;

import com.lvdapiaoliang.infracore.scheduler.RetryExecutorBase;
import com.lvdapiaoliang.trade.domain.SlotVendingMachine;
import com.lvdapiaoliang.trade.domain.SlotVendingMachineState;
import com.lvdapiaoliang.trade.domain.repository.VendingMachineRepository;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: lvguopeng
 * @description:
 */
public class PoppingExpireExecutor extends RetryExecutorBase {

  @Autowired
  private VendingMachineRepository machineRepository;

  @Override
  public void run(Map<String, Object> params) {
    Long orderId = (Long) params.get("orderId");
    Long machineId = (Long) params.get("machineId");
    SlotVendingMachine machine = machineRepository.getSlotVendingMachineById(machineId);
    if (machine != null && machine.getState() == SlotVendingMachineState.Popping
        && machine.getCurOrder() != null && machine.getCurOrder().getOrderId() == orderId) {
      //TODO: 此时更完备的做法是请求一次IOT设备状态
      machine.ready();
    }
  }
}
