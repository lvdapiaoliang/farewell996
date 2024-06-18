package com.lvdapiaoliang.apis;

import com.lvdapiaoliang.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @auther 吕国鹏
 * @create 2024-01-05 13:05
 */
@FeignClient(value = "nacos-payment-provider", fallback = PayFeignSentinelApiFallBack.class)
public interface PayFeignSentinelApi {
  @GetMapping(value = "/pay/nacos/get/{orderNo}")
  public ResultData getPayByOrderNo(@PathVariable("orderNo") String orderNo);
}
