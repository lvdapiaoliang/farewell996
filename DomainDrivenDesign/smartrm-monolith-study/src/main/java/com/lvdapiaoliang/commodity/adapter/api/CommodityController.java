package com.lvdapiaoliang.commodity.adapter.api;

import com.lvdapiaoliang.commodity.application.dto.CommodityInfoDto;
import com.lvdapiaoliang.commodity.application.dto.ListCommodityByIdQueryDto;
import com.lvdapiaoliang.commodity.application.service.CommodityService;
import com.lvdapiaoliang.infracore.api.CommonResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lvguopeng
 * @description: 商品服务入口
 */
@RestController
@RequestMapping("/commodity")
public class CommodityController {

  @Autowired
  private CommodityService commodityService;

  @RequestMapping(value = "/detail/{commodityId}", method = RequestMethod.GET)
  @ResponseBody
  public CommonResponse<CommodityInfoDto> getDetail(@PathVariable String commodityId) {
    CommodityInfoDto commodityInfoDto = commodityService.getCommodityDetail(commodityId);
    return CommonResponse.success(commodityInfoDto);
  }

  @RequestMapping(value = "/list", method = RequestMethod.POST)
  @ResponseBody
  public CommonResponse<List<CommodityInfoDto>> getCommodityList(@RequestBody
      ListCommodityByIdQueryDto request) {
    return CommonResponse.success(commodityService.getCommodityList(request.getIds()));
  }

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  @ResponseBody
  public String getCommodityList() {
    return "hello";
  }
}
