package com.lvdapiaoliang.entity;


import java.time.Instant;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "t_roles")
public class TRoles {
  @Id
  private Long id;
  private String name;
  private String value;
  private Instant createTime;
  private Instant updateTime;

}
