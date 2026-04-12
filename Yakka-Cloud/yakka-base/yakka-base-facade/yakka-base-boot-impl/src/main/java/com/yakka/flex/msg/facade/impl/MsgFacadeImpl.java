package com.yakka.flex.msg.facade.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.yakka.flex.msg.biz.MsgBiz;
import com.yakka.flex.msg.facade.MsgFacade;
import com.yakka.flex.msg.vo.update.ExtendMsgSendVO;

/**
 * 消息接口
 *
 * @author Jared
 * @since 2024年09月20日10:37:50
 *
 */
@Service
@RequiredArgsConstructor
public class MsgFacadeImpl implements MsgFacade {
    private final MsgBiz msgBiz;

    /**
     * 根据模板发送消息
     *
     * @param data 发送内容
     * @return
     */
    @Override
    public Boolean sendByTemplate(ExtendMsgSendVO data) {
        return msgBiz.sendByTemplate(data, null);
    }
}
