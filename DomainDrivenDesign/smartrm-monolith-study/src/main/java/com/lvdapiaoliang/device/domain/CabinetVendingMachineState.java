package com.lvdapiaoliang.device.domain;

/**
 * @author: lvguopeng
 * @description:
 */
public enum CabinetVendingMachineState {
  Locked(0),
  Open(1);

  private final int code;

  private CabinetVendingMachineState(int code) {
    this.code = code;
  }

  public int code() {
    return code;
  }

  public static CabinetVendingMachineState of(int code) {
    for (CabinetVendingMachineState state : values()) {
      if (state.code == code) {
        return state;
      }
    }
    return null;
  }
}
