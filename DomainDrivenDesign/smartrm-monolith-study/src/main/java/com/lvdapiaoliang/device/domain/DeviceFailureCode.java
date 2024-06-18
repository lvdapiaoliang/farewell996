package com.lvdapiaoliang.device.domain;

/**
 * @author: lvguopeng
 * @description:
 */
public enum DeviceFailureCode {
  DeviceUnavailable(1),
  NetworkFailure(2),
  CommodityStucked(3);

  private final int code;

  private DeviceFailureCode(int code) {
    this.code = code;
  }
}
