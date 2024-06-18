package com.lvdapiaoliang.payment.adapter.eventhandler;

import com.lvdapiaoliang.infracore.event.DomainEventHandler;
import com.lvdapiaoliang.payment.application.service.PayService;
import com.lvdapiaoliang.payment.domain.OrderInfo;
import com.lvdapiaoliang.trade.domain.event.OrderCanceledEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: lvguopeng
 * @description:
 */
@Component
public class OrderCanceledEventHandler implements DomainEventHandler<OrderCanceledEvent> {

  @Autowired
  private PayService payService;

  @Override
  public void onApplicationEvent(OrderCanceledEvent event) {
    payService.onOrderCanceled(
        OrderInfo.Builder().orderId(event.getOrderId())
            .type(event.getType())
            .machineId(event.getMachineId())
            .totalAmount(event.getTotalAmount())
            .build()
    );
  }
}
