package com.lvdapiaoliang.payment.adapter.simulator;

import com.lvdapiaoliang.infracore.api.CommonResponse;
import com.lvdapiaoliang.payment.application.dto.PlatformPaymentResultDto;
import com.lvdapiaoliang.payment.application.dto.PlatformResultCode;
import com.lvdapiaoliang.payment.application.service.PayService;
import com.lvdapiaoliang.payment.domain.PlatformType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lvguopeng
 * @description:
 */
@RestController
@RequestMapping("/mock/payment")
public class PaymentSimulatorController {

  @Autowired
  private PayService payService;

  @RequestMapping(value = "/pay/{orderId}", method = RequestMethod.POST)
  @ResponseBody
  public CommonResponse finishPay(@PathVariable Long orderId) {
    PlatformPaymentResultDto result = new PlatformPaymentResultDto();
    result.setPlatformType(PlatformType.Wechat);
    result.setOrderId(orderId);
    result.setResultCode(PlatformResultCode.Success);
    payService.onPaymentResult(result);
    return CommonResponse.success();
  }

  @RequestMapping(value = "/refund/{orderId}", method = RequestMethod.POST)
  @ResponseBody
  public CommonResponse finishRefund(@PathVariable Long orderId) {
    PlatformPaymentResultDto result = new PlatformPaymentResultDto();
    result.setOrderId(orderId);
    result.setPlatformType(PlatformType.Wechat);
    result.setResultCode(PlatformResultCode.Success);
    payService.onRefundResult(result);
    return CommonResponse.success();
  }

}
