package com.lvdapiaoliang.trade.domain.remote;

/**
 * @author: lvguopeng
 * @description: 单商品库存信息
 */
public class InventoryInfo {

  //商品id
  private String commodityId;
  //商品数量
  private Integer count;

  public InventoryInfo(String commodityId, Integer count) {
    this.commodityId = commodityId;
    this.count = count;
  }

  public String getCommodityId() {
    return commodityId;
  }

  public void setCommodityId(String commodityId) {
    this.commodityId = commodityId;
  }

  public Integer getCount() {
    return count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }
}
