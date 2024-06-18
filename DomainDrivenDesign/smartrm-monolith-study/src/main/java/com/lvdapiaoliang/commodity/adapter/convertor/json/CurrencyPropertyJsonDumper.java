package com.lvdapiaoliang.commodity.adapter.convertor.json;

import com.lvdapiaoliang.commodity.domain.model.Property;
import java.math.BigDecimal;

/**
 * @author: lvguopeng
 * @description:
 */
public class CurrencyPropertyJsonDumper extends PropertyJsonDumper<BigDecimal> {

  @Override
  public void dump(Property<BigDecimal> from) {
    if (from.getMaxRepeat() > 1) {
      root.withArray(from.getName()).add(from.getValue());
    } else {
      root.put(from.getName(), from.getValue());
    }
  }

}
