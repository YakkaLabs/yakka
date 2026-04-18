package com.yakka.flex.im.common.event.listener;

import com.yakka.flex.im.common.event.GroupInviteMemberEvent;
import com.yakka.flex.im.core.chat.service.ChatService;
import com.yakka.flex.im.core.chat.service.adapter.RoomAdapter;
import com.yakka.flex.im.core.user.service.cache.UserCache;
import com.yakka.flex.im.domain.entity.User;
import com.yakka.flex.im.domain.vo.request.ChatMessageReq;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.List;

import static com.yakka.flex.im.common.config.ThreadPoolConfig.YAKKA_EXECUTOR;

/**
 * 邀请群成员监听器
 *
 * @author 乾乾
 */
@Slf4j
@Component
@AllArgsConstructor
public class GroupInviteMemberListener {

    private ChatService chatService;
    private UserCache userCache;

	/**
	 * 触发邀请群员的消息
	 * @param event
	 */
    @Async(YAKKA_EXECUTOR)
    @TransactionalEventListener(classes = GroupInviteMemberEvent.class, fallbackExecution = true, phase = TransactionPhase.AFTER_COMMIT)
    public void sendAddMsg(GroupInviteMemberEvent event) {
        List<Long> uidList = event.getMemberList();
        Long roomId = event.getRoomId();
        User user = userCache.get(event.getUid());
        ChatMessageReq chatMessageReq = RoomAdapter.buildGroupAddMessage(event.getApplyFor(), event.getChannel(), roomId, user, userCache.getBatch(uidList));
        chatService.sendMsg(chatMessageReq, user.getId());
    }

}
