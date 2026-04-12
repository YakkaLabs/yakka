package com.yakka.flex.im.common.event.listener;

import com.yakka.basic.context.ContextUtil;
import com.yakka.basic.service.MQProducer;
import com.yakka.flex.common.constant.MqConstant;
import com.yakka.flex.im.common.event.MessageSendEvent;
import com.yakka.flex.im.core.chat.dao.MessageDao;
import com.yakka.flex.im.domain.MsgSendMessageDTO;
import com.yakka.flex.im.domain.entity.Message;
import com.yakka.flex.im.domain.entity.Room;
import com.yakka.flex.im.domain.enums.HotFlagEnum;
import com.yakka.flex.im.core.chat.service.cache.RoomCache;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.Objects;

/**
 * 消息发送监听器
 *
 * @author zhongzb create on 2022/08/26
 */
@Slf4j
@Component
public class MessageSendListener {
    @Resource
    private MessageDao messageDao;
//    @Resource
//    private IChatAIService openAIService;
    @Resource
    private RoomCache roomCache;
    @Resource
    private MQProducer mqProducer;

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT, classes = MessageSendEvent.class, fallbackExecution = true)
    public void messageRoute(MessageSendEvent event) {
        Long msgId = event.getChatMsgSendDto().getMsgId();
        mqProducer.sendSecureMsg(MqConstant.MSG_PUSH_OUTPUT_TOPIC, new MsgSendMessageDTO(msgId, event.getChatMsgSendDto().getUid(), ContextUtil.getTenantId()), msgId);
    }

    @TransactionalEventListener(classes = MessageSendEvent.class, fallbackExecution = true)
    public void handlerMsg(@NotNull MessageSendEvent event) {
        Message message = messageDao.getById(event.getChatMsgSendDto().getMsgId());
        Room room = roomCache.get(message.getRoomId());
        if (isHotRoom(room)) {
//            openAIService.chat(message);
        }
    }

    public boolean isHotRoom(Room room) {
        return Objects.equals(HotFlagEnum.YES.getType(), room.getHotFlag());
    }

    /**
     * 给用户微信推送艾特好友的消息通知
     * （这个没开启，微信不让推）
     */
    @TransactionalEventListener(classes = MessageSendEvent.class, fallbackExecution = true)
    public void publishChatToWechat(@NotNull MessageSendEvent event) {
//        Message message = messageDao.getById(event.getChatMsgSendDto().getMsgId());
//        if (Objects.nonNull(message.getExtra().getAtUidList())) {
//            weChatMsgOperationService.publishChatMsgToWeChatUser(message.getFromUid(), message.getExtra().getAtUidList(),
//                    message.getContent());
//        }
    }
}
