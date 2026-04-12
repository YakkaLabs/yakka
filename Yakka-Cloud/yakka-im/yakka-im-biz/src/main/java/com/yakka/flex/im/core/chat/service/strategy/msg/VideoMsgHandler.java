package com.yakka.flex.im.core.chat.service.strategy.msg;

import com.yakka.flex.im.core.chat.dao.MessageDao;
import com.yakka.flex.im.domain.entity.Message;
import com.yakka.flex.im.domain.entity.msg.MessageExtra;
import com.yakka.flex.im.domain.vo.response.msg.VideoMsgDTO;
import com.yakka.flex.im.domain.enums.MessageTypeEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 视频消息
 * @author Jared
 */
@Component
@AllArgsConstructor
public class VideoMsgHandler extends AbstractMsgHandler<VideoMsgDTO> {
    private MessageDao messageDao;

    @Override
    MessageTypeEnum getMsgTypeEnum() {
        return MessageTypeEnum.VIDEO;
    }

    @Override
    public void saveMsg(Message msg, VideoMsgDTO body) {
        MessageExtra extra = Optional.ofNullable(msg.getExtra()).orElse(new MessageExtra());
        Message update = new Message();
        update.setId(msg.getId());
        update.setExtra(extra);
		update.setReplyMsgId(body.getReplyMsgId());
        extra.setVideoMsgDTO(body);
        messageDao.updateById(update);
    }

    @Override
    public Object showMsg(Message msg) {
		VideoMsgDTO resp = msg.getExtra().getVideoMsgDTO();
		resp.setAtUidList(Optional.ofNullable(msg.getExtra()).map(MessageExtra::getAtUidList).orElse(null));
		resp.setReply(replyMsg(msg));
		return resp;
    }

    @Override
    public Object showReplyMsg(Message msg) {
        return "视频";
    }

    @Override
    public String showContactMsg(Message msg) {
        return "[视频]";
    }
}
