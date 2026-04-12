package com.yakka.flex.im.core.chat.service.strategy.mark;

import com.yakka.flex.model.enums.MessageMarkTypeEnum;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 不满标记策略类
 * @author Jared
 */
@Component
public class DisLikeStrategy extends AbstractMsgMarkStrategy {

    @Override
    protected MessageMarkTypeEnum getTypeEnum() {
        return MessageMarkTypeEnum.DISLIKE;
    }

    @Override
    public void doMark(Long uid, List<Long> uidList, Long msgId) {
        super.doMark(uid, uidList, msgId);
        //同时取消点赞的动作
        MsgMarkFactory.getStrategyNoNull(MessageMarkTypeEnum.LIKE.getType()).unMark(uid, uidList, msgId);
    }

}
