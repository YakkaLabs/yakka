package com.yakka.flex.im.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.yakka.basic.base.entity.TenantEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 消息标记表
 * </p>
 *
 * @author Jared
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("im_message_mark")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageMark extends TenantEntity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 消息表id
     */
    @TableField("msg_id")
    private Long msgId;

    /**
     * 标记人uid
     */
    @TableField("uid")
    private Long uid;

    /**
     * 标记类型 @see com.yakka.flex.model.enums.MessageMarkTypeEnum
     */
    @TableField("type")
    private Integer type;

    /**
     * 消息状态 0正常 1取消
     */
    @TableField("status")
    private Integer status;
}
