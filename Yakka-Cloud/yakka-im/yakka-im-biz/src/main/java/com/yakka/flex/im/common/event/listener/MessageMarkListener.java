package com.yakka.flex.im.common.event.listener;

import com.yakka.flex.im.common.enums.IdempotentEnum;
import com.yakka.flex.im.common.event.MessageMarkEvent;
import com.yakka.flex.im.core.chat.dao.MessageDao;
import com.yakka.flex.im.core.chat.dao.MessageMarkDao;
import com.yakka.flex.im.domain.dto.ChatMessageMarkDTO;
import com.yakka.flex.im.domain.entity.Message;
import com.yakka.flex.model.enums.MessageMarkTypeEnum;
import com.yakka.flex.im.domain.enums.MessageTypeEnum;
import com.yakka.flex.im.domain.enums.ItemEnum;
import com.yakka.flex.im.core.user.service.UserBackpackService;
import com.yakka.flex.im.core.user.service.adapter.WsAdapter;
import com.yakka.flex.im.core.user.service.impl.PushService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.Objects;

import static com.yakka.flex.im.common.config.ThreadPoolConfig.YAKKA_EXECUTOR;

/**
 * 消息标记监听器
 *
 * @author zhongzb create on 2022/08/26
 */
@Slf4j
@Component
@AllArgsConstructor
public class MessageMarkListener {

    private MessageMarkDao messageMarkDao;
    private MessageDao messageDao;
    private UserBackpackService userBackpackService;
    private PushService pushService;

    @Async(YAKKA_EXECUTOR)
    @TransactionalEventListener(classes = MessageMarkEvent.class, fallbackExecution = true)
    public void changeMsgType(MessageMarkEvent event) {
        ChatMessageMarkDTO dto = event.getDto();
        Message msg = messageDao.getById(dto.getMsgId());
        if (!Objects.equals(msg.getType(), MessageTypeEnum.TEXT.getType())) {
            // 普通消息才需要升级
            return;
        }
        // 消息被标记次数
        Integer markCount = messageMarkDao.getMarkCount(dto.getMsgId(), dto.getMarkType());
        MessageMarkTypeEnum markTypeEnum = MessageMarkTypeEnum.of(dto.getMarkType());
        if (markCount < markTypeEnum.getRiseNum()) {
            return;
        }
        if (MessageMarkTypeEnum.LIKE.getType().equals(dto.getMarkType())) {
            // 尝试给用户发送一张徽章
            userBackpackService.acquireItem(msg.getFromUid(), ItemEnum.LIKE_BADGE.getId(), IdempotentEnum.MSG_ID, msg.getId().toString());
        }
    }

    // 后续可做合并查询，目前异步影响不大
    @Async(YAKKA_EXECUTOR)
    @TransactionalEventListener(classes = MessageMarkEvent.class, fallbackExecution = true)
    public void notifyAll(MessageMarkEvent event) {
        ChatMessageMarkDTO dto = event.getDto();
        Integer markCount = messageMarkDao.getMarkCount(dto.getMsgId(), dto.getMarkType());
        pushService.sendPushMsg(WsAdapter.buildMsgMarkSend(dto, markCount), event.getUidList(), dto.getUid());
    }

}
