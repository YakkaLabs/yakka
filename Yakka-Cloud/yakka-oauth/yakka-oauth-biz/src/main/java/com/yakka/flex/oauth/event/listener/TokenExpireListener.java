package com.yakka.flex.oauth.event.listener;

import com.yakka.basic.context.ContextUtil;
import com.yakka.basic.service.MQProducer;
import com.yakka.flex.common.constant.MqConstant;
import com.yakka.flex.model.entity.WSRespTypeEnum;
import com.yakka.flex.model.entity.WsBaseResp;
import com.yakka.flex.model.entity.dto.RouterPushDTO;
import com.yakka.flex.model.entity.ws.OffLineResp;
import com.yakka.flex.oauth.event.TokenExpireEvent;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * 同类设备重复登录事件 [只推送给自己的设备]
 *
 * @author 乾乾
 */
@Slf4j
@Component
public class TokenExpireListener {

	@Resource
	private MQProducer mqProducer;

    @Async
    @TransactionalEventListener(classes = TokenExpireEvent.class, fallbackExecution = true)
    public void forceOffline(TokenExpireEvent event) {
		OffLineResp offLine = event.getOffLine();
		WsBaseResp<OffLineResp> wsBaseResp = new WsBaseResp<>();
		wsBaseResp.setType(WSRespTypeEnum.TOKEN_EXPIRED.getType());
		wsBaseResp.setData(offLine);
		mqProducer.sendMsg(MqConstant.PUSH_TOPIC, new RouterPushDTO(wsBaseResp, offLine.getUid(), offLine.getUid(), ContextUtil.getTenantId()));
    }

}
