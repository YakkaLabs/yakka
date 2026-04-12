package com.yakka.flex.im.common.event;

import com.yakka.flex.im.domain.dto.ChatMsgSendDto;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author Jared
 */
@Getter
public class MessageSendEvent extends ApplicationEvent {
    private final ChatMsgSendDto chatMsgSendDto;

    public MessageSendEvent(Object source, ChatMsgSendDto chatMsgSendDto) {
        super(source);
        this.chatMsgSendDto = chatMsgSendDto;
    }
}
