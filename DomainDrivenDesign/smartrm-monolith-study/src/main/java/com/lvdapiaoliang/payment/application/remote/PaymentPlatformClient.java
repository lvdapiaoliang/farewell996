package com.lvdapiaoliang.payment.application.remote;

import com.lvdapiaoliang.payment.application.dto.PaymentQrCodeDto;
import com.lvdapiaoliang.payment.domain.Payment;

/**
 * @author: lvguopeng
 * @description:
 */
public interface PaymentPlatformClient {

  PaymentQrCodeDto queryQrCode(Payment payment);

  void requestForDeduction(Payment payment);

  void requestForRefund(Payment payment);

}
