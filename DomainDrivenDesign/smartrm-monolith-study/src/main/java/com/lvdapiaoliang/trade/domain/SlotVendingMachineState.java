package com.lvdapiaoliang.trade.domain;

/**
 * @author: lvguopeng
 * @description: 货到售卖机状态
 */
public enum SlotVendingMachineState {
  Ready(0),
  //正在交易状态
  Trading(1),
  Popping(2);

  private final int code;

  private SlotVendingMachineState(int code) {
    this.code = code;
  }

  public int code() {
    return code;
  }

  public static SlotVendingMachineState of(int code) {
    for (SlotVendingMachineState state : values()) {
      if (state.code == code) {
        return state;
      }
    }
    return null;
  }

}
