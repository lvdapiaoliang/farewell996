package com.lvdapiaoliang.payment.application.dto;

import com.lvdapiaoliang.payment.domain.PlatformType;
import java.math.BigDecimal;

/**
 * @author: lvguopeng
 * @description:
 */
public class StartQrCodePayCommandDto {

  private PlatformType platformType;
  private Long machineId;
  private Long orderId;
  private BigDecimal totalAmount;

  public PlatformType getPlatformType() {
    return platformType;
  }

  public void setPlatformType(PlatformType platformType) {
    this.platformType = platformType;
  }

  public Long getMachineId() {
    return machineId;
  }

  public void setMachineId(Long machineId) {
    this.machineId = machineId;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }
}
