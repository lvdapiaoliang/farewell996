package com.lvdapiaoliang.operation.domain.remote.erp;

import com.lvdapiaoliang.operation.domain.VendingMachineInstallOrder;

/**
 * @author: lvguopeng
 * @description:
 */
public interface DevicePurchaseService {

  void placeInstallOrder(VendingMachineInstallOrder order);

}
