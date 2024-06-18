package com.lvdapiaoliang.operation.infrastructure;

import com.lvdapiaoliang.infracore.api.ErrorCode;

/**
 * @author: lvguopeng
 * @description:
 */
public enum OperationError implements ErrorCode {
  ERPError(60001, "erp service access error");

  private final int code;
  private final String msg;

  private OperationError(int code, String msg) {
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
