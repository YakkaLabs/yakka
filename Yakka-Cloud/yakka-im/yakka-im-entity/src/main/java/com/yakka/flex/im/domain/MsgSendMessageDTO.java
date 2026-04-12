package com.yakka.flex.im.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * @author Jared
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MsgSendMessageDTO implements Serializable {
    /**
     * 消息id
     */
    private Long msgId;
    /**
     * 操作人uid
     */
    private Long uid;
	/**
	 * 租户id
	 */
	private Long tenantId;
}
