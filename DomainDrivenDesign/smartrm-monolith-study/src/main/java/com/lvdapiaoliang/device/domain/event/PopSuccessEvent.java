package com.lvdapiaoliang.device.domain.event;

import com.lvdapiaoliang.infracore.event.DomainEvent;

/**
 * @author: lvguopeng
 * @description:
 */
public class PopSuccessEvent extends DomainEvent {

  private long machineId;
  private long orderId;

  public PopSuccessEvent() {
    super("device.PopSuccessEvent");
  }

  public long getMachineId() {
    return machineId;
  }

  public void setMachineId(long machineId) {
    this.machineId = machineId;
  }

  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }

  @Override
  public String key() {
    return Long.toString(machineId);
  }
}
