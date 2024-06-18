package com.lvdapiaoliang.commodity.adapter.convertor.plaintext;

import com.lvdapiaoliang.commodity.adapter.convertor.CommodityPropertyParser;
import com.lvdapiaoliang.commodity.domain.model.DateParser;
import com.lvdapiaoliang.commodity.infrastructure.CommodityError;
import com.lvdapiaoliang.infracore.exception.DomainException;
import java.time.LocalDateTime;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: lvguopeng
 * @description:
 */
public class DateTimePropertyTextParser implements
    CommodityPropertyParser<LocalDateTime, String> {

  @Override
  public LocalDateTime parse(String content) {
    if (StringUtils.isEmpty(content)) {
      return null;
    }

    LocalDateTime dateTime = DateParser.asLocalDateTime(content);
    if (dateTime == null) {
      throw new DomainException(CommodityError.CommodityParseError);
    }
    return dateTime;
  }
}
