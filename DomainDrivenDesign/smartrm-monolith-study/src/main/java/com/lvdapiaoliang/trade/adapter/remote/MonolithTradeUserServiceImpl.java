package com.lvdapiaoliang.trade.adapter.remote;

import com.lvdapiaoliang.trade.domain.remote.TradeUserService;
import com.lvdapiaoliang.trade.domain.remote.UserInfo;
import com.lvdapiaoliang.user.application.dto.UserInfoDto;
import com.lvdapiaoliang.user.application.dto.UserInfoQueryDto;
import com.lvdapiaoliang.user.application.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lvguopeng
 * @description:
 */
@Service
public class MonolithTradeUserServiceImpl implements TradeUserService {

  @Autowired
  AppUserService userService;

  @Override
  public UserInfo getUserInfo(String openId) {
    UserInfoQueryDto query = new UserInfoQueryDto();
    query.setOpenId(openId);
    UserInfoDto dto = userService.getUserInfo(query);
    return UserInfo.Builder().accountId(dto.getAccountId())
        .contractId(dto.getContractId())
        .wxOpenId(dto.getWxOpenId())
        .wxUnionId(dto.getWxUnionId()).build();
  }
}
