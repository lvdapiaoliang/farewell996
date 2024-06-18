package com.lvdapiaoliang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 工单附件表(易问e答)
 * </p>
 *
 * @author 吕国鹏
 * @since 2024-06-06
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("work_order_answer_file_easy_ask")
public class WorkOrderAnswerFileEasyAsk {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * work_order_answer_easy_ask表主键id
     */
    @TableField("work_order_answer_id")
    private Long workOrderAnswerId;

    /**
     * work_order_main_easy_ask表id
     */
    @TableField("work_order_id")
    private Long workOrderId;

    /**
     * 文件url
     */
    @TableField("file_url")
    private String fileUrl;
}
