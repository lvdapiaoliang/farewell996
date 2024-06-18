package com.lvdapiaoliang.operation.domain.remote;

import com.lvdapiaoliang.operation.domain.VendingMachineInstallOrder;

/**
 * @author: lvguopeng
 * @description: 售卖机投放（采购）服务
 */
public interface DevicePurchaseService {

  void placeInstallOrder(VendingMachineInstallOrder order);

}
