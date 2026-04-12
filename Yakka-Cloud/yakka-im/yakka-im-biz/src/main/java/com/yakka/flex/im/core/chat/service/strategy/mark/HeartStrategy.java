package com.yakka.flex.im.core.chat.service.strategy.mark;

import com.yakka.flex.model.enums.MessageMarkTypeEnum;
import org.springframework.stereotype.Component;

/**
 * 爱心标记策略
 * @author Jared
 */
@Component
public class HeartStrategy extends AbstractMsgMarkStrategy {
    @Override
    protected MessageMarkTypeEnum getTypeEnum() {
        return MessageMarkTypeEnum.HEART;
    }
}