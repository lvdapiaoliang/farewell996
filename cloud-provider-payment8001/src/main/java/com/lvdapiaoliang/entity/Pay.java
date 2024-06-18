package com.lvdapiaoliang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 支付交易表
 * </p>
 *
 * @author 吕国鹏
 * @since 2024-05-24
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("t_pay")
@Schema(title = "支付交易表实体类")
public class Pay {

  @TableId(value = "id", type = IdType.AUTO)
  @Schema(title = "主键")
  private Integer id;

  /**
   * 支付流水号
   */
  @TableField("pay_no")
  @Schema(title = "支付流水号")
  private String payNo;

  /**
   * 订单流水号
   */
  @TableField("order_no")
  @Schema(title = "订单流水号")
  private String orderNo;

  /**
   * 用户账号ID
   */
  @TableField("user_id")
  @Schema(title = "用户账号ID")
  private Integer userId;

  /**
   * 交易金额
   */
  @TableField("amount")
  @Schema(title = "交易金额")
  private BigDecimal amount;

  /**
   * 删除标志，默认0不删除，1删除
   */
  @TableField("deleted")
  private Byte deleted;

  /**
   * 创建时间
   */
  @TableField("create_time")
  @Schema(title = "创建时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private LocalDateTime createTime;

  /**
   * 更新时间
   */
  @TableField("update_time")
  @Schema(title = "更新时间")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private LocalDateTime updateTime;
}
