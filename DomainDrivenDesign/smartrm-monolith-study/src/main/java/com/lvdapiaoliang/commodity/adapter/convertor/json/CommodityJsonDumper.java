package com.lvdapiaoliang.commodity.adapter.convertor.json;

import com.lvdapiaoliang.commodity.adapter.convertor.CommodityDumper;
import com.lvdapiaoliang.commodity.adapter.convertor.JsonPropertyConvertor;
import java.io.OutputStream;

/**
 * @author: lvguopeng
 * @description:
 */
public class CommodityJsonDumper extends CommodityDumper {

  public CommodityJsonDumper(OutputStream ostream) {
    super(new JsonPropertyConvertor(), ostream);
  }

}
