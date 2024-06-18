package com.lvdapiaoliang.commodity.adapter.convertor.plaintext;

import com.lvdapiaoliang.commodity.adapter.convertor.CommodityPropertyParser;
import com.lvdapiaoliang.commodity.infrastructure.CommodityError;
import com.lvdapiaoliang.infracore.exception.DomainException;
import java.math.BigDecimal;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * @author: lvguopeng
 * @description:
 */
public class CurrencyPropertyTextParser implements
    CommodityPropertyParser<BigDecimal, String> {

  @Override
  public BigDecimal parse(String value) {
    if (StringUtils.isEmpty(value)) {
      return null;
    }

    try {
      return NumberUtils.createBigDecimal(value);
    } catch (NumberFormatException e) {
      throw new DomainException(CommodityError.CommodityParseError);
    }
  }
}
