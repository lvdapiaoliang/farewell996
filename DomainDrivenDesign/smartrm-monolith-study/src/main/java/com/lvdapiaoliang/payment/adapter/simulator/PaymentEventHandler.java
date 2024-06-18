package com.lvdapiaoliang.payment.adapter.simulator;

import com.lvdapiaoliang.infracore.event.DomainEventHandler;
import com.lvdapiaoliang.payment.application.dto.PlatformPaymentResultDto;
import com.lvdapiaoliang.payment.application.dto.PlatformResultCode;
import com.lvdapiaoliang.payment.application.service.PayService;
import com.lvdapiaoliang.payment.domain.PaymentState;
import com.lvdapiaoliang.payment.domain.PaymentStateChangeEvent;
import com.lvdapiaoliang.payment.domain.PlatformType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: lvguopeng
 * @description:
 */
@Component
public class PaymentEventHandler implements DomainEventHandler<PaymentStateChangeEvent> {

  @Autowired
  PayService payService;

  @Override
  public void onApplicationEvent(PaymentStateChangeEvent paymentStateChangeEvent) {
    if (paymentStateChangeEvent.getCurState() == PaymentState.WaitingForDeduction) {
      PlatformPaymentResultDto result = new PlatformPaymentResultDto();
      result.setPlatformType(PlatformType.Wechat);
      result.setOrderId(paymentStateChangeEvent.getOrderInfo().getOrderId());
      result.setResultCode(PlatformResultCode.Success);
      payService.onPaymentResult(result);
    }
  }
}
