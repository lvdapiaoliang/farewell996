package com.lvdapiaoliang.commodity.adapter.convertor;

/**
 * @author: lvguopeng
 * @description:
 */
public interface CommodityPropertyParser<T, V> {

  T parse(V content);

}
