package com.yakka.flex.im.common.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import com.yakka.flex.im.domain.dto.ChatMessageMarkDTO;
import java.util.List;

/**
 * @author Jared
 */
@Getter
public class MessageMarkEvent extends ApplicationEvent {

    private final ChatMessageMarkDTO dto;
	// 需要推送的用户id
	private final List<Long> uidList;

    public MessageMarkEvent(Object source, List<Long> uidList, ChatMessageMarkDTO dto) {
        super(source);
        this.dto = dto;
		this.uidList = uidList;
    }

}
