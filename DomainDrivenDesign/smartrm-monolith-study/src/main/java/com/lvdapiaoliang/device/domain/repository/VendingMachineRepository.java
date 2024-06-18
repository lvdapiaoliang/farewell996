package com.lvdapiaoliang.device.domain.repository;

import com.lvdapiaoliang.device.domain.VendingMachine;
import com.lvdapiaoliang.device.domain.cabinet.CabinetVendingMachine;
import com.lvdapiaoliang.device.domain.iot.IoTDeviceId;
import com.lvdapiaoliang.device.domain.slot.SlotVendingMachine;

/**
 * @author: lvguopeng
 * @description:
 */
public interface VendingMachineRepository {

  VendingMachine getVendingMachine(long machineId);

  SlotVendingMachine getSlotVendingMachineById(long machineId);

  SlotVendingMachine getSlotVendingMachineByDeviceId(IoTDeviceId deviceId);

  CabinetVendingMachine getCabinetVendingMachineById(long machineId);

  void add(VendingMachine vendingMachine);

  void updateInventory(VendingMachine machine);

  void updateCabinetVendingMachineState(CabinetVendingMachine machine);

  void clearInventorySnapshot(long machineId);

  void saveInventorySnapshot(CabinetVendingMachine machine);

}
