package com.lvdapiaoliang.apis;

import com.lvdapiaoliang.resp.ResultData;
import com.lvdapiaoliang.resp.ReturnCodeEnum;
import org.springframework.stereotype.Component;

/**
 * @auther 吕国鹏
 * @create 2024-01-05 13:07
 */
@Component
public class PayFeignSentinelApiFallBack implements PayFeignSentinelApi {
  @Override
  public ResultData getPayByOrderNo(String orderNo) {
    return ResultData.fail(
        ReturnCodeEnum.RC500.getCode(),
        "对方服务宕机或不可用，FallBack服务降级o(╥﹏╥)o");
  }
}
