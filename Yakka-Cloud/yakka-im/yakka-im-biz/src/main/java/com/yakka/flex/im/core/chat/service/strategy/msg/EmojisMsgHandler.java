package com.yakka.flex.im.core.chat.service.strategy.msg;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import com.yakka.flex.im.core.chat.dao.MessageDao;
import com.yakka.flex.im.domain.entity.Message;
import com.yakka.flex.im.domain.vo.response.msg.EmojisMsgDTO;
import com.yakka.flex.im.domain.entity.msg.MessageExtra;
import com.yakka.flex.im.domain.enums.MessageTypeEnum;

import java.util.Optional;

/**
 * 表情消息
 * @author Jared
 */
@Component
public class EmojisMsgHandler extends AbstractMsgHandler<EmojisMsgDTO> {
    @Resource
    private MessageDao messageDao;

    @Override
    MessageTypeEnum getMsgTypeEnum() {
        return MessageTypeEnum.EMOJI;
    }

    @Override
    public void saveMsg(Message msg, EmojisMsgDTO body) {
        MessageExtra extra = Optional.ofNullable(msg.getExtra()).orElse(new MessageExtra());
        Message update = new Message();
        update.setId(msg.getId());
        update.setExtra(extra);
		update.setReplyMsgId(body.getReplyMsgId());
        extra.setEmojisMsgDTO(body);
        messageDao.updateById(update);
    }

    @Override
    public Object showMsg(Message msg) {
		EmojisMsgDTO resp = msg.getExtra().getEmojisMsgDTO();
		resp.setAtUidList(Optional.ofNullable(msg.getExtra()).map(MessageExtra::getAtUidList).orElse(null));
		resp.setReply(replyMsg(msg));
		return resp;
    }

    @Override
    public Object showReplyMsg(Message msg) {
        return "表情";
    }

    @Override
    public String showContactMsg(Message msg) {
        return "[动画表情]";
    }
}
