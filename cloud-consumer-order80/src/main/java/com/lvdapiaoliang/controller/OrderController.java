package com.lvdapiaoliang.controller;

import com.lvdapiaoliang.entity.PayDTO;
import com.lvdapiaoliang.resp.ResultData;
import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @auther 吕国鹏
 * @create 2024-01-22 22:33
 */
@RestController
public class OrderController {
  //public static final String PaymentSrv_URL = "http://localhost:8001";//先写死，硬编码
  public static final String PaymentSrv_URL = "http://cloud-payment-service";//服务注册中心上的微服务名称

  @Resource
  private RestTemplate restTemplate;
  @Resource
  private DiscoveryClient discoveryClient;

  // 删除和修改作为家庭作业

  @GetMapping(value = "/consumer/pay/add")
  public ResultData addOrder(PayDTO payDTO) {
    return restTemplate.postForObject(PaymentSrv_URL + "/pay/add", payDTO, ResultData.class);
  }

  @GetMapping(value = "/consumer/pay/get/{id}")
  public ResultData getPayInfo(@PathVariable("id") Integer id) {
    return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/" + id, ResultData.class, id);
  }

  @GetMapping(value = "/consumer/pay/get/info")
  private String getInfoByConsul() {
    return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/info", String.class);
  }

  @GetMapping("/consumer/discovery")
  public String discovery() {
    List<String> services = discoveryClient.getServices();
    for (String element : services) {
      System.out.println(element);
    }

    System.out.println("===================================");

    List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
    for (ServiceInstance element : instances) {
      System.out.println(
          element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
              + element.getUri());
    }

    return instances.get(0).getServiceId() + ":" + instances.get(0).getPort();
  }

}
