package com.yakka.flex.im.common.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import com.yakka.flex.im.domain.entity.User;

/**
 * @author 乾乾
 */
@Getter
public class UserBlackEvent extends ApplicationEvent {
    private final User user;

    public UserBlackEvent(Object source, User user) {
        super(source);
        this.user = user;
    }
}
