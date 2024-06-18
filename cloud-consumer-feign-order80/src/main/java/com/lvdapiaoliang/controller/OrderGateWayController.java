package com.lvdapiaoliang.controller;

import com.lvdapiaoliang.apis.PayFeignApi;
import com.lvdapiaoliang.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther 吕国鹏
 * @create 2023-12-29 19:00
 */
@RestController
public class OrderGateWayController {
  @Resource
  private PayFeignApi payFeignApi;

  @GetMapping(value = "/feign/pay/gateway/get/{id}")
  public ResultData getById(@PathVariable("id") Integer id) {
    return payFeignApi.getById(id);
  }

  @GetMapping(value = "/feign/pay/gateway/info")
  public ResultData<String> getGatewayInfo() {
    return payFeignApi.getGatewayInfo();
  }
}
