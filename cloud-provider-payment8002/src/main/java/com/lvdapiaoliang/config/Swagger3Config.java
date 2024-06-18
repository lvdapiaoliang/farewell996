package com.lvdapiaoliang.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther 吕国鹏
 * @create 2023-12-22 14:50
 */
@Configuration
public class Swagger3Config {
  // Swagger3地址：http://localhost:8001/swagger-ui/index.html
  @Bean
  public GroupedOpenApi PayApi() {
    return GroupedOpenApi.builder().group("支付微服务模块").pathsToMatch("/pay/**").build();
  }

  @Bean
  public GroupedOpenApi OtherApi() {
    return GroupedOpenApi.builder().group("其它微服务模块").pathsToMatch("/other/**", "/others")
        .build();
  }
    /*@Bean
    public GroupedOpenApi CustomerApi()
    {
        return GroupedOpenApi.builder().group("客户微服务模块").pathsToMatch("/customer/**",
        "/customers").build();
    }*/

  @Bean
  public OpenAPI docsOpenApi() {
    return new OpenAPI()
        .info(new Info().title("告别996项目API")
                  .description("告别996项目API")
                  .version("v1.0"))
        .externalDocs(new ExternalDocumentation()
                          .description("www.baidu.com")
                          .url("https://www.baidu.com"));
  }
}

