package com.yakka.flex.im.common.event;

import com.yakka.flex.im.domain.dto.RequestApprovalDto;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author Jared
 */
@Getter
public class UserApprovalEvent extends ApplicationEvent {
    private final RequestApprovalDto requestApprovalDto;

    public UserApprovalEvent(Object source, RequestApprovalDto requestApprovalDto) {
        super(source);
        this.requestApprovalDto = requestApprovalDto;
    }

}
