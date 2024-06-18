package com.lvdapiaoliang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @auther 吕国鹏
 * @create 2024-01-22 22:33
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Main80 {
  public static void main(String[] args) {
    SpringApplication.run(Main80.class, args);
  }
}