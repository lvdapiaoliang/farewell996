package com.lvdapiaoliang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 工单答复列表(易问e答)
 * </p>
 *
 * @author 吕国鹏
 * @since 2024-06-06
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("work_order_answer_easy_ask")
public class WorkOrderAnswerEasyAsk {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 工单号
     */
    @TableField("work_order_no")
    private String workOrderNo;

    /**
     * 答复人编码
     */
    @TableField("answer_person_code")
    private String answerPersonCode;

    /**
     * 答复人姓名
     */
    @TableField("answer_person_name")
    private String answerPersonName;

    /**
     * 答复信息
     */
    @TableField("answer_description")
    private String answerDescription;

    /**
     * 答复时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;
}
