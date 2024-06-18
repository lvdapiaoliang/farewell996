package com.lvdapiaoliang.apis;

import com.lvdapiaoliang.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @auther 吕国鹏
 * @create 2024-01-06 14:07
 */
@FeignClient(value = "seata-account-service")
public interface AccountFeignApi {
  //扣减账户余额
  @PostMapping("/account/decrease")
  ResultData decrease(@RequestParam("userId") Long userId, @RequestParam("money") Long money);
}
