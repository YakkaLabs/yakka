package com.yakka.flex.im.common.event;

import com.yakka.flex.model.entity.dto.ChatMsgRecallDTO;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.List;

@Getter
public class MessageRecallEvent extends ApplicationEvent {

    private final ChatMsgRecallDTO recallDTO;
	private final List<Long> uidList;

    public MessageRecallEvent(Object source, List<Long> uidList, ChatMsgRecallDTO recallDTO) {
        super(source);
        this.recallDTO = recallDTO;
		this.uidList = uidList;
    }

}
