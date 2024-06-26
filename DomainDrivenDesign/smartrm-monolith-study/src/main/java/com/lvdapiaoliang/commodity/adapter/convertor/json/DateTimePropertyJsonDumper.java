package com.lvdapiaoliang.commodity.adapter.convertor.json;

import com.lvdapiaoliang.commodity.domain.model.Property;
import java.time.LocalDateTime;

/**
 * @author: lvguopeng
 * @description:
 */
public class DateTimePropertyJsonDumper extends PropertyJsonDumper<LocalDateTime> {

  @Override
  public void dump(Property<LocalDateTime> from) {
    if (from.getMaxRepeat() > 1) {
      root.withArray(from.getName()).add(from.getValue().toString());
    } else {
      root.put(from.getName(), from.getValue().toString());
    }
  }
}
