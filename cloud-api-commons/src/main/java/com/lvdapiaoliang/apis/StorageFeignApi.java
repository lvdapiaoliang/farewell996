package com.lvdapiaoliang.apis;

import com.lvdapiaoliang.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @auther 吕国鹏
 * @create 2024-01-06 14:06
 */
@FeignClient(value = "seata-storage-service")
public interface StorageFeignApi {
  /**
   * 扣减库存
   */
  @PostMapping(value = "/storage/decrease")
  ResultData decrease(
      @RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
