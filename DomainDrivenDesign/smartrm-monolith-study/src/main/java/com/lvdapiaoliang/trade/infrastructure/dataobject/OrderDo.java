package com.lvdapiaoliang.trade.infrastructure.dataobject;

/**
 * @author: lvguopeng
 * @description: 订单的数据对象，订单的数据对象相对于订单实体来说就简单很多了。
 * 数据对象的属性和数据库的表里面的属性是一一对应的。
 */
public class OrderDo {

  private long orderId;
  private long machineId;
  private int state;
  private int type;
  private long paymentId;
  private String commodities;

  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public long getPaymentId() {
    return paymentId;
  }

  public void setPaymentId(long paymentId) {
    this.paymentId = paymentId;
  }

  public String getCommodities() {
    return commodities;
  }

  public void setCommodities(String commodities) {
    this.commodities = commodities;
  }

  public long getMachineId() {
    return machineId;
  }

  public void setMachineId(long machineId) {
    this.machineId = machineId;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }
}
