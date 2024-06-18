package com.lvdapiaoliang.commodity.application.dto;

import java.util.List;

/**
 * @author: lvguopeng
 * @description:
 */
public class ListCommodityByIdQueryDto {

  private List<String> ids;

  public List<String> getIds() {
    return ids;
  }

  public void setIds(List<String> ids) {
    this.ids = ids;
  }
}
