package com.lvdapiaoliang.trade.domain;

import com.lvdapiaoliang.trade.domain.remote.UserInfo;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

/**
 * @author: lvguopeng
 * @description:
 */
@Service
public class ActivityService {

  public BigDecimal caculateOrderAmount(Order order, UserInfo userInfo) {
    // caculate order amount with activity
    return BigDecimal.ZERO;
  }
}
