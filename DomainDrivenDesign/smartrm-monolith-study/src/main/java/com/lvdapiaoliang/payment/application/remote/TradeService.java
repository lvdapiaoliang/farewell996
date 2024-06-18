package com.lvdapiaoliang.payment.application.remote;

import com.lvdapiaoliang.payment.domain.PaymentStateChangeEvent;

/**
 * @author: lvguopeng
 * @description:
 */
public interface TradeService {

  void onPaymentStateChange(PaymentStateChangeEvent event);

}
