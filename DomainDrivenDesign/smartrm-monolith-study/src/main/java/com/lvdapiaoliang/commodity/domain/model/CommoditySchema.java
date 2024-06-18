package com.lvdapiaoliang.commodity.domain.model;

import java.util.List;

/**
 * @author: lvguopeng
 * @description:
 */
public interface CommoditySchema {

  PropertySchema getPropertySchema(String fieldName);

  List<PropertySchema> getAllPropertySchemas();

}
