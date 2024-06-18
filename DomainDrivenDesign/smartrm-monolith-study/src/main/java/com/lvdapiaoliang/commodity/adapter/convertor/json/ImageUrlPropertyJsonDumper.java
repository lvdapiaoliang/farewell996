package com.lvdapiaoliang.commodity.adapter.convertor.json;

import com.lvdapiaoliang.commodity.domain.model.ImageUrl;
import com.lvdapiaoliang.commodity.domain.model.Property;

/**
 * @author: lvguopeng
 * @description:
 */
public class ImageUrlPropertyJsonDumper extends PropertyJsonDumper<ImageUrl> {

  @Override
  public void dump(Property<ImageUrl> from) {
    if (from.getMaxRepeat() > 1) {
      root.withArray(from.getName()).addPOJO(from.getValue());
    } else {
      root.putPOJO(from.getName(), from.getValue());
    }
  }

}
