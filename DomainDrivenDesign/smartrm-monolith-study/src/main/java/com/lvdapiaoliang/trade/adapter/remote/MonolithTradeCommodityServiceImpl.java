package com.lvdapiaoliang.trade.adapter.remote;

import com.lvdapiaoliang.commodity.application.dto.CommodityInfoDto;
import com.lvdapiaoliang.trade.domain.remote.CommodityInfo;
import com.lvdapiaoliang.trade.domain.remote.TradeCommodityService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lvguopeng
 * @description:
 */
@Service
public class MonolithTradeCommodityServiceImpl implements TradeCommodityService {

  @Autowired
  com.lvdapiaoliang.commodity.application.service.CommodityService remoteService;

  @Override
  public CommodityInfo getCommodityDetail(String commodityId) {
    CommodityInfoDto dto = remoteService.getCommodityDetail(commodityId);
    return new CommodityInfo(dto.getCommodityId(), dto.getCommodityName(), dto.getImageUrl(),
        dto.getPrice());
  }

  @Override
  public List<CommodityInfo> getCommodityList(List<String> commodityIds) {
    List<CommodityInfoDto> dtos = remoteService.getCommodityList(commodityIds);
    return dtos.stream().map(
        dto -> new CommodityInfo(dto.getCommodityId(), dto.getCommodityName(), dto.getImageUrl(),
            dto.getPrice())).collect(Collectors.toList());
  }
}
