package com.yakka.flex.im.common.event;

import com.yakka.flex.im.domain.entity.UserBackpack;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author 乾乾
 */
@Getter
public class ItemReceiveEvent extends ApplicationEvent {
    private final UserBackpack userBackpack;

    public ItemReceiveEvent(Object source, UserBackpack userBackpack) {
        super(source);
        this.userBackpack = userBackpack;
    }

}
