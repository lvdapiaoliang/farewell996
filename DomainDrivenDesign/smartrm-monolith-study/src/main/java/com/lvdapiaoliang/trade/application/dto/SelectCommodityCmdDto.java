package com.lvdapiaoliang.trade.application.dto;

import com.lvdapiaoliang.payment.domain.PlatformType;

/**
 * @author: lvguopeng
 * @description:
 */
public class SelectCommodityCmdDto {

  Long machineId;
  String commodityId;
  PlatformType platformType;

  public Long getMachineId() {
    return machineId;
  }

  public void setMachineId(Long machineId) {
    this.machineId = machineId;
  }

  public String getCommodityId() {
    return commodityId;
  }

  public void setCommodityId(String commodityId) {
    this.commodityId = commodityId;
  }

  public PlatformType getPlatformType() {
    return platformType;
  }

  public void setPlatformType(PlatformType platformType) {
    this.platformType = platformType;
  }
}
