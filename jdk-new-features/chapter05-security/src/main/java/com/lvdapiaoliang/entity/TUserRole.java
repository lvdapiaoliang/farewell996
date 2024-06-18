package com.lvdapiaoliang.entity;


import java.time.Instant;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "t_user_role")
public class TUserRole {
  @Id
  private Long id;
  private Long userId;
  private Long roleId;
  private Instant createTime;
  private Instant updateTime;

}
