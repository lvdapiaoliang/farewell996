package com.lvdapiaoliang.service;

import com.lvdapiaoliang.entity.Pay;
import java.util.List;

/**
 * <p>
 * 支付交易表 服务类
 * </p>
 *
 * @author 吕国鹏
 * @since 2024-05-24
 */
public interface PayService {

  public int add(Pay pay);

  public int delete(Integer id);

  public int update(Pay pay);

  public Pay getById(Integer id);

  public List<Pay> getAll();

}
