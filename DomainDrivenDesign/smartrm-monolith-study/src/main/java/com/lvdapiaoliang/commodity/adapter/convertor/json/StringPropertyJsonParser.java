package com.lvdapiaoliang.commodity.adapter.convertor.json;

import com.fasterxml.jackson.databind.JsonNode;
import com.lvdapiaoliang.commodity.adapter.convertor.CommodityPropertyParser;
import com.lvdapiaoliang.commodity.infrastructure.CommodityError;
import com.lvdapiaoliang.infracore.exception.DomainException;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: lvguopeng
 * @description:
 */
public class StringPropertyJsonParser implements
    CommodityPropertyParser<String, JsonNode> {

  @Override
  public String parse(JsonNode fieldNode) {
    if (fieldNode == null || fieldNode.isNull()) {
      return null;
    }

    if (!fieldNode.isValueNode()) {
      throw new DomainException(CommodityError.CommodityParseError);
    }

    return StringUtils.trimToNull(fieldNode.asText());
  }
}
