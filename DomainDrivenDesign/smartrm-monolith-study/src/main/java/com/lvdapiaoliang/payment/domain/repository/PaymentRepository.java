package com.lvdapiaoliang.payment.domain.repository;

import com.lvdapiaoliang.payment.domain.Payment;

/**
 * @author: lvguopeng
 * @description:
 */
public interface PaymentRepository {

  Payment getByOrderId(Long orderId);

  void add(Payment payment);

  void update(Payment payment);

}
