package com.yakka.flex.im.common.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import com.yakka.flex.im.domain.entity.UserApply;

/**
 * @author Jared
 */
@Getter
public class UserApplyEvent extends ApplicationEvent {
    private final UserApply userApply;

    public UserApplyEvent(Object source, UserApply userApply) {
        super(source);
        this.userApply = userApply;
    }

}
