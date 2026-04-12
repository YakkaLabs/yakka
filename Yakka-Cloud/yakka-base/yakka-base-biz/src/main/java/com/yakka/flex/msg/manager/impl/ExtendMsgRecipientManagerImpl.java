package com.yakka.flex.msg.manager.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.yakka.basic.base.manager.impl.SuperManagerImpl;
import com.yakka.basic.database.mybatis.conditions.Wraps;
import com.yakka.flex.msg.entity.ExtendMsgRecipient;
import com.yakka.flex.msg.manager.ExtendMsgRecipientManager;
import com.yakka.flex.msg.mapper.ExtendMsgRecipientMapper;

import java.util.List;

/**
 * <p>
 * 通用业务实现类
 * 消息接收人
 * </p>
 *
 * @author Jared
 * @date 2022-07-10 11:41:17
 * @create [2022-07-10 11:41:17] [zuihou] [代码生成器生成]
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ExtendMsgRecipientManagerImpl extends SuperManagerImpl<ExtendMsgRecipientMapper, ExtendMsgRecipient> implements ExtendMsgRecipientManager {
    @Override
    public List<ExtendMsgRecipient> listByMsgId(Long id) {
        return list(Wraps.<ExtendMsgRecipient>lbQ().eq(ExtendMsgRecipient::getMsgId, id));
    }
}


