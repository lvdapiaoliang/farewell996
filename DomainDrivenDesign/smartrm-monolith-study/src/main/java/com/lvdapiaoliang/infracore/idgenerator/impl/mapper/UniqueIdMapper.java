package com.lvdapiaoliang.infracore.idgenerator.impl.mapper;

import com.lvdapiaoliang.infracore.idgenerator.impl.UniqueIdDo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * @author: lvguopeng
 * @description:
 */
@Mapper
public interface UniqueIdMapper {

  @Insert({"insert into unique_id_generator () values ()"})
  @Options(useGeneratedKeys = true, keyProperty = "id")
  int nextUniqueId(UniqueIdDo uniqueIdDo);
}
