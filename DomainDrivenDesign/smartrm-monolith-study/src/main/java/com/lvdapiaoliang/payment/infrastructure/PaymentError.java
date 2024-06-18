package com.lvdapiaoliang.payment.infrastructure;

import com.lvdapiaoliang.infracore.api.ErrorCode;

/**
 * @author: lvguopeng
 * @description:
 */
public enum PaymentError implements ErrorCode {
  PaymentNotExist(50001, "payment not exist"),
  PaymentStateNotCorrect(50002, "payment state not correct"),
  WechatPayRequestFail(50003, "fail to request wechat payment platform");

  private final int code;
  private final String msg;

  private PaymentError(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  @Override
  public int getCode() {
    return code;
  }

  @Override
  public String getMsg() {
    return msg;
  }
}
