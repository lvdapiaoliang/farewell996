package com.lvdapiaoliang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.lvdapiaoliang", exclude = {SecurityAutoConfiguration.class})
@MapperScan({"com.lvdapiaoliang.device.infrastructure.mapper",
    "com.lvdapiaoliang.user.infrastructure.mapper",
    "com.lvdapiaoliang.payment.infrastructure.mapper",
    "com.lvdapiaoliang.trade.infrastructure.mapper",
    "com.lvdapiaoliang.infracore.idgenerator.impl.mapper",
    "com.lvdapiaoliang.operation.infrastructure.mapper"})
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SmartrmMonolithApplication {

  public static void main(String[] args) {
    SpringApplication.run(SmartrmMonolithApplication.class, args);
  }

}
