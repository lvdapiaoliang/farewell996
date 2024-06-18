package com.lvdapiaoliang.commodity.adapter.convertor.plaintext;

import com.lvdapiaoliang.commodity.adapter.convertor.CommodityPropertyParser;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: lvguopeng
 * @description:
 */
public class StringPropertyTextParser implements
    CommodityPropertyParser<String, String> {

  @Override
  public String parse(String content) {
    return StringUtils.trimToNull(content);
  }
}
