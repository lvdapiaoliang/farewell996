package com.lvdapiaoliang.trade.adapter.eventhandler;

import com.lvdapiaoliang.device.domain.event.PopSuccessEvent;
import com.lvdapiaoliang.infracore.event.DomainEventHandler;
import com.lvdapiaoliang.trade.domain.SlotVendingMachine;
import com.lvdapiaoliang.trade.domain.repository.VendingMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: lvguopeng
 * @description: 商品弹出成功事件处理
 */
@Component
public class PopSuccessEventHandler implements DomainEventHandler<PopSuccessEvent> {

  @Autowired
  private VendingMachineRepository machineRepository;

  @Override
  public void onApplicationEvent(PopSuccessEvent event) {
    long machineId = event.getMachineId();
    SlotVendingMachine machine = machineRepository.getSlotVendingMachineById(machineId);
    if (machine != null) {
      machine.onPopSuccess(event);
    }
  }
}
