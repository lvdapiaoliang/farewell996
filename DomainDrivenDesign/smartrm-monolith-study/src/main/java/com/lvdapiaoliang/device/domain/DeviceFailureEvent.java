package com.lvdapiaoliang.device.domain;

import com.lvdapiaoliang.infracore.event.DomainEvent;

/**
 * @author: lvguopeng
 * @description:
 */
public class DeviceFailureEvent extends DomainEvent {

  private Long machineId;
  private VendingMachineType machineType;
  private DeviceFailure failure;
  private Long orderId;
  private String commodityId;

  public DeviceFailureEvent() {
    super("device.DeviceFailureEvent");
  }

  public Long getMachineId() {
    return machineId;
  }

  public void setMachineId(Long machineId) {
    this.machineId = machineId;
  }

  public DeviceFailure getFailure() {
    return failure;
  }

  public void setFailure(DeviceFailure failure) {
    this.failure = failure;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public String getCommodityId() {
    return commodityId;
  }

  public void setCommodityId(String commodityId) {
    this.commodityId = commodityId;
  }

  public VendingMachineType getMachineType() {
    return machineType;
  }

  public void setMachineType(VendingMachineType machineType) {
    this.machineType = machineType;
  }
  @Override
  public String key() {
    return null;
  }
}
