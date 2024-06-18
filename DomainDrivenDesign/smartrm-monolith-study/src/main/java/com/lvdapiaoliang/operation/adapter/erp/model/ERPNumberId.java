package com.lvdapiaoliang.operation.adapter.erp.model;

/**
 * @author: lvguopeng
 * @description:
 */
public class ERPNumberId {

  private String FNumber = "";

  public ERPNumberId(String number) {
    FNumber = number;
  }

  public ERPNumberId() {
    
  }

  public String getFNumber() {
    return FNumber;
  }

  public void setFNumber(String FNumber) {
    this.FNumber = FNumber;
  }
}
