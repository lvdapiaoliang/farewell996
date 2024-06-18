package com.lvdapiaoliang.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @auther 吕国鹏
 * @create 2024-01-22 22:33
 */
@Configuration
@LoadBalancerClient(value = "cloud-payment-service", configuration = RestTemplateConfig.class)
public class RestTemplateConfig {
  @Bean
  @LoadBalanced //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  //    @Bean
  //    ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment,
  //                                                            LoadBalancerClientFactory
  //                                                            loadBalancerClientFactory) {
  //        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
  //
  //        return new RandomLoadBalancer(loadBalancerClientFactory.getLazyProvider(name,
  //        ServiceInstanceListSupplier.class), name);
  //    }
}
