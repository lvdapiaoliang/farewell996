package com.lvdapiaoliang.commodity.adapter.convertor;

import com.lvdapiaoliang.commodity.domain.model.ValueType;

/**
 * @author: lvguopeng
 * @description:
 */
public interface PropertyConvertor {

  CommodityPropertyParser parser(ValueType type);

  CommodityPropertyDumper dumper(ValueType type);

}
