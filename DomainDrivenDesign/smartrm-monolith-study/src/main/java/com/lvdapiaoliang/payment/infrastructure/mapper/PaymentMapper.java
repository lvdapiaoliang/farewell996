package com.lvdapiaoliang.payment.infrastructure.mapper;

import com.lvdapiaoliang.payment.infrastructure.dataobject.PaymentDo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author: lvguopeng
 * @description:
 */
@Mapper
public interface PaymentMapper {

  @Insert({
      "insert into payment ("
          + "machine_id, order_id, order_type, amount, state, platform_type, payment_type, account_id, contract_id, retried_times, last_retry_time) "
          + " values ("
          + "#{machineId}, #{orderId}, #{orderType}, #{amount}, #{state}, #{platformType}, #{paymentType}, #{accountId}, #{contractId}, #{retriedTimes}, #{lastRetryTime})"})
  @Options(useGeneratedKeys = true, keyProperty = "paymentId")
  int add(PaymentDo paymentDo);

  @Select({"select * from payment where order_id=#{orderId}"})
  PaymentDo selectByOrderId(Long orderId);

  @Update({
      "update payment set "
          + "machine_id=#{machineId}, "
          + "order_id=#{orderId}, "
          + "order_type=#{orderType}, "
          + "amount=#{amount},"
          + "state=#{state}, "
          + "platform_type=#{platformType}, "
          + "payment_type=#{paymentType}, "
          + "account_id=#{accountId}, "
          + "contract_id=#{contractId}, "
          + "retried_times=#{retriedTimes}, "
          + "last_retry_time=#{lastRetryTime} "
          + "where payment_id=#{paymentId}"})
  int update(PaymentDo paymentDo);
}
