package com.lvdapiaoliang.controller;

import com.lvdapiaoliang.entity.Pay;
import com.lvdapiaoliang.entity.PayDTO;
import com.lvdapiaoliang.resp.ResultData;
import com.lvdapiaoliang.resp.ReturnCodeEnum;
import com.lvdapiaoliang.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 支付交易表 前端控制器
 * </p>
 *
 * @author 吕国鹏
 * @since 2024-05-24
 */
@RestController
@Slf4j
@Tag(name = "支付微服务模块", description = "支付CRUD")
public class PayController {

  @Resource
  private PayService payService;

  @Value("${server.port}")
  private String port;

  @PostMapping(value = "/pay/add")
  @Operation(summary = "新增", description = "新增支付流水方法,json串做参数")
  public ResultData<String> addPay(@RequestBody Pay pay) {
    System.out.println(pay.toString());
    int i = payService.add(pay);
    return ResultData.success("成功插入记录，返回值: " + i);
  }

  @DeleteMapping(value = "/pay/del/{id}")
  @Operation(summary = "删除", description = "删除支付流水方法")
  public ResultData<Integer> deletePay(@PathVariable("id") Integer id) {
    int i = payService.delete(id);
    return ResultData.success(i);
  }

  @PutMapping(value = "/pay/update")
  @Operation(summary = "修改", description = "修改支付流水方法")
  public ResultData<String> updatePay(@RequestBody PayDTO payDTO) {
    Pay pay = new Pay();
    BeanUtils.copyProperties(payDTO, pay);

    int i = payService.update(pay);
    return ResultData.success("成功修改记录，返回值: " + i);
  }

  //全部查询getall作为家庭作业
  @GetMapping(value = "/pay/getAll")
  public ResultData<List<Pay>> getAll() {
    List<Pay> payList = payService.getAll();

    return ResultData.success(payList);
  }

  @GetMapping(value = "/pay/get/{id}")
  @Operation(summary = "按照ID查流水", description = "查询支付流水方法")
  public ResultData<Pay> getById(@PathVariable("id") Integer id) {
    if (id == -4) {
      throw new RuntimeException("id不能为负数");
    }

    //暂停62秒钟线程,故意写bug，测试出feign的默认调用超时时间
    //    try {TimeUnit.SECONDS.sleep(62);} catch (InterruptedException e) {e.printStackTrace();}

    Pay pay = payService.getById(id);

    return ResultData.success(pay);
  }

  @GetMapping(value = "/pay/error")
  public ResultData<Integer> getPayError() {
    Integer integer = Integer.valueOf(200);
    try {
      System.out.println("come in payerror test");
      int age = 10 / 0;
    } catch (Exception e) {
      e.printStackTrace();
      return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
    }
    return ResultData.success(integer);
  }

  @GetMapping(value = "/pay/get/info")
  public String getInfoByConsul(@Value("${lvdapiaoliang.info}") String lvdapiaoliangInfo) {
    return "lvdapiaoliangInfo: " + lvdapiaoliangInfo + "\t" + "port: " + port;
  }

}