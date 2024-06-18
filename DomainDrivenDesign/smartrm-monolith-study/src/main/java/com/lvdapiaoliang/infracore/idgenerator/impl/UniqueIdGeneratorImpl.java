package com.lvdapiaoliang.infracore.idgenerator.impl;

import com.lvdapiaoliang.infracore.idgenerator.UniqueIdGenerator;
import com.lvdapiaoliang.infracore.idgenerator.impl.mapper.UniqueIdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lvguopeng
 * @description:
 */
@Service
public class UniqueIdGeneratorImpl implements UniqueIdGenerator {

  @Autowired
  UniqueIdMapper mapper;

  @Override
  public long next() {
    UniqueIdDo id = new UniqueIdDo();
    mapper.nextUniqueId(id);
    return id.getId();
  }
}
