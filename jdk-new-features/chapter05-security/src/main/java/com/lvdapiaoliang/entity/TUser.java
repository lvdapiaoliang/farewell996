package com.lvdapiaoliang.entity;


import java.time.Instant;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "t_user")
public class TUser {
  @Id
  private Long id;
  private String username;
  private String password;
  private String email;
  private String phone;

  private Instant createTime;

  private Instant updateTime;


}
