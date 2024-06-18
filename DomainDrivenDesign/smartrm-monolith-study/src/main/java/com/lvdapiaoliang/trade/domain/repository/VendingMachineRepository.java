package com.lvdapiaoliang.trade.domain.repository;

import com.lvdapiaoliang.trade.domain.CabinetVendingMachine;
import com.lvdapiaoliang.trade.domain.SlotVendingMachine;

/**
 * @author: lvguopeng
 * @description:
 */
public interface VendingMachineRepository {

  SlotVendingMachine getSlotVendingMachineById(long id);

  CabinetVendingMachine getCabinetVendingMachineById(long id);

  void updateSlotVendingMachine(SlotVendingMachine machine);

  void updateCabinetVendingMachine(CabinetVendingMachine machine);

}
