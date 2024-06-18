package com.lvdapiaoliang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * @author lvdapiaoliang
 * @Description
 * @create 2024-06-01 22:16
 */
@Configuration
public class MyWebConfiguration {

  //配置底层
  @Bean
  public WebFluxConfigurer webFluxConfigurer() {

    return new WebFluxConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedHeaders("*")
            .allowedMethods("*")
            .allowedOrigins("localhost");
      }
    };
  }
}
