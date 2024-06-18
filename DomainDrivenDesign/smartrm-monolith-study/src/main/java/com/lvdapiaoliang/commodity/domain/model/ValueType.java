package com.lvdapiaoliang.commodity.domain.model;

public interface ValueType<T> {

  ValueTypeCode getType();

  Class<T> getValueClass();

}
