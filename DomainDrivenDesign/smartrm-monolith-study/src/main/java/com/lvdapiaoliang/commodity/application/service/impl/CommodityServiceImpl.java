package com.lvdapiaoliang.commodity.application.service.impl;

import com.google.common.collect.Lists;
import com.lvdapiaoliang.commodity.application.dto.CommodityInfoDto;
import com.lvdapiaoliang.commodity.application.service.CommodityService;
import com.lvdapiaoliang.commodity.domain.model.Commodity;
import com.lvdapiaoliang.commodity.domain.repository.CommodityRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lvguopeng
 * @description: 商品服务实现
 */
@Service
public class CommodityServiceImpl implements CommodityService {

  @Autowired
  private CommodityRepository commodityRepository;

  @Override
  public CommodityInfoDto getCommodityDetail(String commodityId) {
    Commodity commodity = commodityRepository.findById(commodityId);
    if (commodity == null) {
      return null;
    }
    CommodityInfoDto commodityInfoDto = new CommodityInfoDto(commodity);
    return commodityInfoDto;
  }

  public List<CommodityInfoDto> getCommodityList(List<String> commodityId) {
    List<CommodityInfoDto> ret = Lists.newArrayList();
    List<Commodity> commodities = commodityRepository.findBatchByIds(commodityId);
    for (Commodity commodity : commodities) {
      ret.add(new CommodityInfoDto(commodity));
    }
    return ret;
  }
}
