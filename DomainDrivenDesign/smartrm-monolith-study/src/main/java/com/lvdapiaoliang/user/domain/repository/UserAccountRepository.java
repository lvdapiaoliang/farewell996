package com.lvdapiaoliang.user.domain.repository;

import com.lvdapiaoliang.user.domain.UserAccount;

/**
 * @author: lvguopeng
 * @description:
 */
public interface UserAccountRepository {

  UserAccount getByOpenId(String openId);

  void add(UserAccount account);

  void update(UserAccount account);

}
