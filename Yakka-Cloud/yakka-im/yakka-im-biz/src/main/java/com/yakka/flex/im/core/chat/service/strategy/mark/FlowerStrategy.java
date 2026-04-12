package com.yakka.flex.im.core.chat.service.strategy.mark;

import org.springframework.stereotype.Component;
import com.yakka.flex.model.enums.MessageMarkTypeEnum;

/**
 * 鲜花标记策略
 * @author Jared
 */
@Component
public class FlowerStrategy extends AbstractMsgMarkStrategy {
    @Override
    protected MessageMarkTypeEnum getTypeEnum() {
        return MessageMarkTypeEnum.FLOWER;
    }
}