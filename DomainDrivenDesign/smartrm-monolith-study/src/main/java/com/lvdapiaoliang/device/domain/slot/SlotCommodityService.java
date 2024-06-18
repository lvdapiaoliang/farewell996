package com.lvdapiaoliang.device.domain.slot;

import com.lvdapiaoliang.device.infrastructure.DeviceError;
import com.lvdapiaoliang.device.infrastructure.mapper.SlotCommodityMapper;
import com.lvdapiaoliang.infracore.exception.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lvguopeng
 * @description: 商品货道转换服务
 */
@Service
public class SlotCommodityService {

  @Autowired
  private SlotCommodityMapper slotCommodityMapper;

  public int findSlotForCommodity(long machineId, String commodityId) {
    Integer slot = slotCommodityMapper.findSlot(machineId, commodityId);
    if (slot == null) {
      throw new DomainException(DeviceError.InventoryNotCorrect);
    }
    return slot;
  }

  public String findCommodityBySlot(long machineId, int slot) {
    return slotCommodityMapper.getCommodityBySlot(machineId, slot);
  }

}
