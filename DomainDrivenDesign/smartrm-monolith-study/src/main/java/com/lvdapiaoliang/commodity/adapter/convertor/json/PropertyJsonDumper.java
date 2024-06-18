package com.lvdapiaoliang.commodity.adapter.convertor.json;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lvdapiaoliang.commodity.adapter.convertor.CommodityPropertyDumper;

/**
 * @author: lvguopeng
 * @description:
 */
public abstract class PropertyJsonDumper<T> implements CommodityPropertyDumper<T> {

  ObjectNode root;

  public PropertyJsonDumper<T> withRoot(ObjectNode root) {
    this.root = root;
    return this;
  }

}
