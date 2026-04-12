package com.yakka.flex.im.common.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import com.yakka.flex.im.domain.entity.User;

/**
 * @author Jared
 */
@Getter
public class UserRegisterEvent extends ApplicationEvent {
    private final User user;

    public UserRegisterEvent(Object source, User user) {
        super(source);
        this.user = user;
    }
}
