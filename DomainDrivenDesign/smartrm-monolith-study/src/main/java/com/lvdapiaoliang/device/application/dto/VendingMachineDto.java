package com.lvdapiaoliang.device.application.dto;

import com.lvdapiaoliang.device.domain.InventoryInfo;
import com.lvdapiaoliang.device.domain.cabinet.CabinetDoorState;
import java.util.List;

/**
 * @author: lvguopeng
 * @description:
 */
public class VendingMachineDto {

  private Long machineId;

  private CabinetDoorState state;

  private List<InventoryInfo> inventory;

  public Long getMachineId() {
    return machineId;
  }

  public void setMachineId(long machineId) {
    this.machineId = machineId;
  }

  public List<InventoryInfo> getInventory() {
    return inventory;
  }

  public void setInventory(List<InventoryInfo> inventoryInfos) {
    this.inventory = inventoryInfos;
  }

  public CabinetDoorState getState() {
    return state;
  }

  public void setState(CabinetDoorState state) {
    this.state = state;
  }
}
