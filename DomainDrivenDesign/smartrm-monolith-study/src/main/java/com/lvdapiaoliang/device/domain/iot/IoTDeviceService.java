package com.lvdapiaoliang.device.domain.iot;

/**
 * @author: lvguopeng
 * @description:
 */
public interface IoTDeviceService {

  public void popCommodity(IoTDeviceId deviceId, int slotId, long orderId) throws Exception;

}
