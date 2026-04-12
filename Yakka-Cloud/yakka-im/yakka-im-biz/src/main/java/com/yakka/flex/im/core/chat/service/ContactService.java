package com.yakka.flex.im.core.chat.service;

import com.yakka.flex.im.domain.dto.MsgReadInfoDTO;
import com.yakka.flex.im.domain.entity.Contact;
import com.yakka.flex.im.domain.entity.Message;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 会话列表 服务类
 * </p>
 *
 * @author Jared
 */
public interface ContactService {
    /**
     * 创建会话
     */
    void createContact(Long uid, Long roomId);

    Integer getMsgReadCount(Message message);

    Integer getMsgUnReadCount(Message message);

    Map<Long, MsgReadInfoDTO> getMsgReadInfo(List<Message> messages);
}
