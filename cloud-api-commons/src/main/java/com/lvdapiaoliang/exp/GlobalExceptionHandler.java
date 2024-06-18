package com.lvdapiaoliang.exp;

import com.lvdapiaoliang.resp.ResultData;
import com.lvdapiaoliang.resp.ReturnCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @auther 吕国鹏
 * @create 2024-04-22 17:09
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(RuntimeException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResultData<String> exception(Exception e) {
    log.error("全局异常信息:{}", e.getMessage(), e);

    return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
  }
}
