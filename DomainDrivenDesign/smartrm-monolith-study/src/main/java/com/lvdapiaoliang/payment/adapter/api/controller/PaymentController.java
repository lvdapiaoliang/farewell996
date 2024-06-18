package com.lvdapiaoliang.payment.adapter.api.controller;

import com.lvdapiaoliang.infracore.api.CommonResponse;
import com.lvdapiaoliang.payment.application.dto.ChargeCommandDto;
import com.lvdapiaoliang.payment.application.dto.PaymentQrCodeDto;
import com.lvdapiaoliang.payment.application.dto.StartQrCodePayCommandDto;
import com.lvdapiaoliang.payment.application.service.PayService;
import com.lvdapiaoliang.payment.domain.AccountInfo;
import com.lvdapiaoliang.payment.domain.OrderInfo;
import com.lvdapiaoliang.trade.domain.OrderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lvguopeng
 * @description:
 */
@RestController
@RequestMapping("/pay")
public class PaymentController {

  @Autowired
  PayService payService;

  @RequestMapping(value = "/startQrcodePay", method = RequestMethod.POST)
  @ResponseBody
  public CommonResponse<PaymentQrCodeDto> startQrCodePayForOrder(
      @RequestBody StartQrCodePayCommandDto request) {
    OrderInfo orderInfo = OrderInfo.Builder().orderId(request.getOrderId())
        .machineId(request.getMachineId())
        .type(OrderType.SlotQrScanePaid)
        .totalAmount(request.getTotalAmount()).build();
    return CommonResponse.success(
        payService.startQrCodePayForOrder(request.getPlatformType(), orderInfo));
  }

  @RequestMapping(value = "/chargeForOrder", method = RequestMethod.POST)
  @ResponseBody
  public CommonResponse chargeForOrder(@RequestBody ChargeCommandDto request) {
    OrderInfo orderInfo = OrderInfo.Builder().orderId(request.getOrderId())
        .machineId(request.getMachineId())
        .type(OrderType.CabinetAutoDeduction)
        .totalAmount(request.getTotalAmount()).build();
    AccountInfo accountInfo = new AccountInfo(request.getAccountId(), request.getContractId());
    payService.chargeForOrder(orderInfo, accountInfo);
    return CommonResponse.success();
  }

}