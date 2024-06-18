package com.lvdapiaoliang.trade.adapter.eventhandler;

import com.lvdapiaoliang.device.domain.event.CabinetVendingMachineLockedEvent;
import com.lvdapiaoliang.infracore.event.DomainEventHandler;
import com.lvdapiaoliang.trade.application.AppTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: lvguopeng
 * @description:
 */
@Component
public class CabinetLockedEventHandler implements
    DomainEventHandler<CabinetVendingMachineLockedEvent> {

  @Autowired
  AppTradeService tradeService;

  @Override
  public void onApplicationEvent(CabinetVendingMachineLockedEvent event) {
    tradeService.onCabinetLocked(event);
  }
}
