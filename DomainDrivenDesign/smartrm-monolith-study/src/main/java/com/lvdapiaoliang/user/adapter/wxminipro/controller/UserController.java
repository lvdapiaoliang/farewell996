package com.lvdapiaoliang.user.adapter.wxminipro.controller;

import com.lvdapiaoliang.infracore.api.CommonResponse;
import com.lvdapiaoliang.user.adapter.wxminipro.vo.SignInResultVo;
import com.lvdapiaoliang.user.application.dto.SignInCommandDto;
import com.lvdapiaoliang.user.application.dto.SignInResultDto;
import com.lvdapiaoliang.user.application.dto.UserInfoDto;
import com.lvdapiaoliang.user.application.dto.UserInfoQueryDto;
import com.lvdapiaoliang.user.application.service.AppUserService;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lvguopeng
 * @description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private AppUserService appUserService;

  @RequestMapping(value = "/signIn", method = RequestMethod.POST)
  @ResponseBody
  public CommonResponse<SignInResultVo> signIn(@Validated @RequestBody SignInCommandDto cmd,
      final HttpServletResponse response) {
    SignInResultDto result = appUserService.signInOrSignUp(cmd);
    if (result.getToken() != null) {
      response.setHeader("Authorization", result.getToken());
    }
    SignInResultVo data = new SignInResultVo();
    data.setResult(result.getResult().code());
    return CommonResponse.success(data);
  }

  @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
  @ResponseBody
  public CommonResponse<UserInfoDto> getUserInfo(@NotBlank @RequestParam String openId) {
    UserInfoQueryDto query = new UserInfoQueryDto();
    query.setOpenId(openId);
    return CommonResponse.success(appUserService.getUserInfo(query));
  }

}
