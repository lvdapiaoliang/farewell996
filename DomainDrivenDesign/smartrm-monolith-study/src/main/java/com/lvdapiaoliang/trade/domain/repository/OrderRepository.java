package com.lvdapiaoliang.trade.domain.repository;

import com.lvdapiaoliang.trade.domain.Order;

/**
 * @author: lvguopeng
 * @description: 订单资源库，以接口的形式暴露给上层(领域层和应用层)。
 */
public interface OrderRepository {

  Order getOrderById(long orderId);

  void addOrder(Order order);

  void updateOrder(Order order);

  void addOrUpdate(Order order);

}
