package com.yakka.flex.im.core.chat.service.strategy.mark;

import com.yakka.flex.model.enums.MessageMarkTypeEnum;
import org.springframework.stereotype.Component;

/**
 * 疑问标记策略
 * @author Jared
 */
@Component
public class ConfusedStrategy extends AbstractMsgMarkStrategy {
    @Override
    protected MessageMarkTypeEnum getTypeEnum() {
        return MessageMarkTypeEnum.CONFUSED;
    }
}