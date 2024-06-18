package com.lvdapiaoliang.device.adapter.simulator.vo;

import com.lvdapiaoliang.device.domain.CabinetVendingMachineState;
import com.lvdapiaoliang.device.domain.InventoryInfo;
import java.util.List;

/**
 * @author: lvguopeng
 * @description:
 */
public class VendingMachineVo {

  private Long machineId;

  private CabinetVendingMachineState state;

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

  public CabinetVendingMachineState getState() {
    return state;
  }

  public void setState(CabinetVendingMachineState state) {
    this.state = state;
  }
}
