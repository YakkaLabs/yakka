package com.yakka.flex.msg.facade.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import com.yakka.basic.base.R;
import com.yakka.flex.msg.api.MsgApi;
import com.yakka.flex.msg.facade.MsgFacade;
import com.yakka.flex.msg.vo.update.ExtendMsgSendVO;

/**
 * 消息接口
 *
 * @author 乾乾
 * @since 2024年09月20日10:37:50
 *
 */
@Service
public class MsgFacadeImpl implements MsgFacade {
    @Lazy
    @Autowired
    private MsgApi msgApi;

    /**
     * 根据模板发送消息
     *
     * @param data 发送内容
     * @return
     */
    @Override
    public Boolean sendByTemplate(ExtendMsgSendVO data) {
        R<Boolean> result = msgApi.sendByTemplate(data);
        return result.getsuccess() && result.getData();
    }
}
