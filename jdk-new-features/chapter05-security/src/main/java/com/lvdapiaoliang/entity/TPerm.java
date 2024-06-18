package com.lvdapiaoliang.entity;


import java.time.Instant;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Table(name = "t_perm")
public class TPerm {
  @Id
  private Long id;

  private String value;
  private String uri;
  private String description;
  private Instant createTime;
  private Instant updateTime;


}
