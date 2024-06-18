package com.lvdapiaoliang.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.lvdapiaoliang.entity.Pay;
import com.lvdapiaoliang.resp.ResultData;
import com.lvdapiaoliang.service.PayService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther 吕国鹏
 * @create 2023-12-29 17:40
 */
@RestController
public class PayGateWayController {
  @Resource
  PayService payService;

  @GetMapping(value = "/pay/gateway/get/{id}")
  public ResultData<Pay> getById(@PathVariable("id") Integer id) {
    Pay pay = payService.getById(id);
    return ResultData.success(pay);
  }

  @GetMapping(value = "/pay/gateway/info")
  public ResultData<String> getGatewayInfo() {
    return ResultData.success("gateway info test：" + IdUtil.simpleUUID());
  }

  @GetMapping(value = "/pay/gateway/filter")
  public ResultData<String> getGatewayFilter(HttpServletRequest request) {
    String result = "";
    Enumeration<String> headers = request.getHeaderNames();
    while (headers.hasMoreElements()) {
      String headName = headers.nextElement();
      String headValue = request.getHeader(headName);
      System.out.println("请求头名: " + headName + "\t\t\t" + "请求头值: " + headValue);

      if (headName.equalsIgnoreCase("X-Request-lvdapiaoliang1")
          || headName.equalsIgnoreCase("X-Request-lvdapiaoliang2")) {
        result = result + headName + "\t " + headValue + " ";
      }
    }
    System.out.println("=============================================");
    String customerId = request.getParameter("customerId");
    System.out.println("request Parameter customerId: " + customerId);

    String customerName = request.getParameter("customerName");
    System.out.println("request Parameter customerName: " + customerName);
    System.out.println("=============================================");

    return ResultData.success("getGatewayFilter 过滤器 test： " + result + " \t " + DateUtil.now());
  }
}