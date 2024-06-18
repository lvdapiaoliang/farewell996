package com.lvdapiaoliang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @auther 吕国鹏
 * @create 2023-12-21 17:15
 */
@SpringBootApplication
@MapperScan("com.lvdapiaoliang.mapper")
@EnableDiscoveryClient
@RefreshScope // 动态刷新
public class Main8002 {
  public static void main(String[] args) {
    SpringApplication.run(Main8002.class, args);
  }
}