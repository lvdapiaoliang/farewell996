package com.lvdapiaoliang.commodity.domain.repository;

import com.lvdapiaoliang.commodity.adapter.CommodityProcessor;
import com.lvdapiaoliang.commodity.domain.model.Commodity;
import java.io.IOException;
import java.util.List;

/**
 * @author: lvguopeng
 * @description: 商品资源库接口
 */
public interface CommodityRepository {

  Commodity findById(String commodityId);

  List<Commodity> findBatchByIds(List<String> ids);

  void put(Commodity commodity);

  void traverse(CommodityProcessor processor) throws IOException;

}
