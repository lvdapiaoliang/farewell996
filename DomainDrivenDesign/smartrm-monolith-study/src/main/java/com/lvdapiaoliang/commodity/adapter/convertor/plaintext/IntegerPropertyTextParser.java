package com.lvdapiaoliang.commodity.adapter.convertor.plaintext;

import com.lvdapiaoliang.commodity.adapter.convertor.CommodityPropertyParser;
import com.lvdapiaoliang.commodity.infrastructure.CommodityError;
import com.lvdapiaoliang.infracore.exception.DomainException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * @author: lvguopeng
 * @description:
 */
public class IntegerPropertyTextParser implements
    CommodityPropertyParser<Long, String> {

  @Override
  public Long parse(String content) {
    if (StringUtils.isEmpty(content)) {
      return null;
    }

    try {
      return NumberUtils.createLong(content);
    } catch (NumberFormatException e) {
      throw new DomainException(CommodityError.CommodityParseError);
    }
  }
}
