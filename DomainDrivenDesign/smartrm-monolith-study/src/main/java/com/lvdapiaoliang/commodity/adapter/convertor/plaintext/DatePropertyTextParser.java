package com.lvdapiaoliang.commodity.adapter.convertor.plaintext;

import com.lvdapiaoliang.commodity.adapter.convertor.CommodityPropertyParser;
import com.lvdapiaoliang.commodity.domain.model.DateParser;
import com.lvdapiaoliang.commodity.infrastructure.CommodityError;
import com.lvdapiaoliang.infracore.exception.DomainException;
import java.time.LocalDate;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: lvguopeng
 * @description:
 */
public class DatePropertyTextParser implements
    CommodityPropertyParser<LocalDate, String> {

  @Override
  public LocalDate parse(String value) {
    if (StringUtils.isEmpty(value)) {
      return null;
    }

    LocalDate date = DateParser.asLocalDate(value);
    if (date == null) {
      throw new DomainException(CommodityError.CommodityParseError);
    }
    return date;
  }
}
