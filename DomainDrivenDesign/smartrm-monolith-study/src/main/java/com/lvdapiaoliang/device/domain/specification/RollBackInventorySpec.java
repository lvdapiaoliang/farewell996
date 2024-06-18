package com.lvdapiaoliang.device.domain.specification;

import com.lvdapiaoliang.device.domain.VendingMachine;
import com.lvdapiaoliang.device.domain.event.DeviceFailureEvent;

/**
 * @author: lvguopeng
 * @description:
 */
public class RollBackInventorySpec {

  public boolean isSatisfiedBy(DeviceFailureEvent event, VendingMachine machine) {
    //TODO: 判断是否需要回滚库存
    return true;
  }

}
