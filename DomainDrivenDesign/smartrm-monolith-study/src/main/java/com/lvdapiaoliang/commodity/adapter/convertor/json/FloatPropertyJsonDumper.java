package com.lvdapiaoliang.commodity.adapter.convertor.json;

import com.lvdapiaoliang.commodity.domain.model.Property;

/**
 * @author: lvguopeng
 * @description:
 */
public class FloatPropertyJsonDumper extends PropertyJsonDumper<Double> {

  @Override
  public void dump(Property<Double> from) {
    if (from.getMaxRepeat() > 1) {
      root.withArray(from.getName()).add(from.getValue().toString());
    } else {
      root.put(from.getName(), from.getValue());
    }
  }
}
