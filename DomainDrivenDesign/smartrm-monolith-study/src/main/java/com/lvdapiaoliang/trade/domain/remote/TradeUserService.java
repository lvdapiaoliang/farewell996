package com.lvdapiaoliang.trade.domain.remote;

/**
 * @author: lvguopeng
 * @description:
 */
public interface TradeUserService {

  /**
   * 获取用户信息
   *
   * @param openId
   * @return
   */
  UserInfo getUserInfo(String openId);


}
