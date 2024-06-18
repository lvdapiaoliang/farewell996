package com.lvdapiaoliang.trade.adapter.remote;

import com.lvdapiaoliang.payment.application.dto.PaymentQrCodeDto;
import com.lvdapiaoliang.payment.domain.AccountInfo;
import com.lvdapiaoliang.payment.domain.OrderInfo;
import com.lvdapiaoliang.payment.domain.PlatformType;
import com.lvdapiaoliang.trade.domain.Order;
import com.lvdapiaoliang.trade.domain.PaymentQrCode;
import com.lvdapiaoliang.trade.domain.remote.TradePayService;
import com.lvdapiaoliang.trade.domain.remote.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lvguopeng
 * @description:
 */
@Service
public class MonolithTradePayServiceImpl implements TradePayService {

  @Autowired
  com.lvdapiaoliang.payment.application.service.PayService payService;


  @Override
  public PaymentQrCode startQrCodePayForOrder(PlatformType platformType, Order order) {
    PaymentQrCodeDto dto = payService
        .startQrCodePayForOrder(
            platformType,
            OrderInfo.Builder()
                .machineId(order.getMachineId())
                .orderId(order.getOrderId())
                .type(order.getType())
                .totalAmount(order.totalAmount())
                .build()
        );
//    order.setPaymentId(dto.getPaymentId());
    return new PaymentQrCode(dto.getPaymentId(), dto.getCodeUrl());
  }

  @Override
  public void chargeForOrder(OrderInfo order, UserInfo userInfo) {
    payService
        .chargeForOrder(order, new AccountInfo(userInfo.getAccountId(), userInfo.getContractId()));
  }
}
