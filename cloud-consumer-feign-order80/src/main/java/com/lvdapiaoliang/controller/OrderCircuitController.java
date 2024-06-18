package com.lvdapiaoliang.controller;

import com.lvdapiaoliang.apis.PayFeignApi;
import jakarta.annotation.Resource;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther 吕国鹏
 * @create 2023-12-26 22:37
 */
@RestController
public class OrderCircuitController {
  @Resource
  private PayFeignApi payFeignApi;

  @GetMapping(value = "/feign/pay/circuit/{id}")
  public String myCircuitBreaker(@PathVariable("id") Integer id) {
    return payFeignApi.myCircuit(id);
  }

  //myCircuitFallback就是服务降级后的兜底处理方法
  public String myCircuitFallback(Integer id, Throwable t) {
    // 这里是容错处理逻辑，返回备用结果
    return "myCircuitFallback，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~";
  }

  /**
   *(船的)舱壁,隔离
   * @param id
   * @return
   */
    /*@GetMapping(value = "/feign/pay/bulkhead/{id}")
    @Bulkhead(name = "cloud-payment-service",fallbackMethod = "myBulkheadFallback",type =
    Bulkhead.Type.SEMAPHORE)
    public String myBulkhead(@PathVariable("id") Integer id)
    {
        return payFeignApi.myBulkhead(id);
    }
    public String myBulkheadFallback(Throwable t)
    {
        return "myBulkheadFallback，隔板超出最大数量限制，系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~";
    }*/

  /**
   * (船的)舱壁,隔离  threadPool
   *
   * @param id
   * @return
   */
  @GetMapping(value = "/feign/pay/bulkhead/{id}")
  public CompletableFuture<String> myBulkheadTHREADPOOL(@PathVariable("id") Integer id) {
    System.out.println(Thread.currentThread().getName() + "\t" + "---开始进入");
    try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
    System.out.println(Thread.currentThread().getName() + "\t" + "---准备离开");

    return CompletableFuture.supplyAsync(
        () -> payFeignApi.myBulkhead(id) + "\t" + "Bulkhead.Type.THREADPOOL");
  }

  public CompletableFuture<String> myBulkheadPoolFallback(Integer id, Throwable t) {
    return CompletableFuture.supplyAsync(
        () -> "Bulkhead.Type.THREADPOOL,系统繁忙，请稍后再试-----/(ㄒoㄒ)/~~");
  }

  @GetMapping(value = "/feign/pay/ratelimit/{id}")
  public String myBulkhead(@PathVariable("id") Integer id) {
    return payFeignApi.myRatelimit(id);
  }

  public String myRatelimitFallback(Integer id, Throwable t) {
    return "你被限流了，禁止访问/(ㄒoㄒ)/~~";
  }
}