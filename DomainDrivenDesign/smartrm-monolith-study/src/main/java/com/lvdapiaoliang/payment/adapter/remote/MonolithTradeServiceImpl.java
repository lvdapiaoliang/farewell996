package com.lvdapiaoliang.payment.adapter.remote;

import com.lvdapiaoliang.payment.application.remote.TradeService;
import com.lvdapiaoliang.payment.domain.PaymentStateChangeEvent;
import com.lvdapiaoliang.trade.application.AppTradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lvguopeng
 * @description:
 */
@Service
public class MonolithTradeServiceImpl implements TradeService {

  @Autowired
  private AppTradeService appTradeService;

  @Override
  public void onPaymentStateChange(PaymentStateChangeEvent event) {
    appTradeService.onPaymentStateChange(event);
  }
}
