package com.lvdapiaoliang.payment.domain;

import com.lvdapiaoliang.infracore.event.DomainEvent;

/**
 * @author: lvguopeng
 * @description:
 */
public class PaymentStartEvent extends DomainEvent {

  private Long paymentId;
  private Long orderId;
  private Long time;

  public PaymentStartEvent(Payment payment) {
    super("payment.PaymentStartEvent");
    this.paymentId = payment.getPaymentId();
    this.orderId = payment.getOrder().getOrderId();
    this.time = System.currentTimeMillis();
  }

  @Override
  public String key() {
    return paymentId.toString();
  }
}
