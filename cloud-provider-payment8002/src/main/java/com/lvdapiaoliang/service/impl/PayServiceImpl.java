package com.lvdapiaoliang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lvdapiaoliang.entity.Pay;
import com.lvdapiaoliang.mapper.PayMapper;
import com.lvdapiaoliang.service.PayService;
import jakarta.annotation.Resource;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付交易表 服务实现类
 * </p>
 *
 * @author 吕国鹏
 * @since 2024-05-24
 */
@Service
public class PayServiceImpl extends ServiceImpl<PayMapper, Pay> implements PayService {

  @Resource
  private PayMapper payMapper;

  @Override
  public int add(Pay pay) {
    return payMapper.insert(pay);
  }

  @Override
  public int delete(Integer id) {
    return payMapper.deleteById(id);
  }

  @Override
  public int update(Pay pay) {
    return payMapper.updateById(pay);
  }

  @Override
  public Pay getById(Integer id) {
    return payMapper.selectById(id);
  }

  @Override
  public List<Pay> getAll() {
    // 创建一个查询条件的wrapper
    QueryWrapper<Pay> queryWrapper = new QueryWrapper<>();
    // 使用selectList查询全部数据
    return payMapper.selectList(queryWrapper);
  }
}
