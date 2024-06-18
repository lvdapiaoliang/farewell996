package com.lvdapiaoliang.commodity.adapter.convertor.json;

import com.lvdapiaoliang.commodity.domain.model.Property;

/**
 * @author: lvguopeng
 * @description:
 */
public class StringPropertyJsonDumper extends PropertyJsonDumper<String> {

  @Override
  public void dump(Property<String> from) {
    if (from.getMaxRepeat() > 1) {
      root.withArray(from.getName()).add(from.getValue());
    } else {
      root.put(from.getName(), from.getValue());
    }
  }
}
