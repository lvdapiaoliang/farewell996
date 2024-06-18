package com.lvdapiaoliang.commodity.adapter.convertor;

import com.lvdapiaoliang.commodity.domain.model.Property;

/**
 * @author: lvguopeng
 * @description:
 */
public interface CommodityPropertyDumper<T> {

  void dump(Property<T> from);

}
