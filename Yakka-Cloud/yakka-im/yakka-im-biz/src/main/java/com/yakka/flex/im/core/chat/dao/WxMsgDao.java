package com.yakka.flex.im.core.chat.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yakka.flex.im.domain.entity.WxMsg;
import com.yakka.flex.im.core.chat.mapper.WxMsgMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 微信消息表 服务实现类
 * </p>
 *
 * @author Jared
 */
@Service
public class WxMsgDao extends ServiceImpl<WxMsgMapper, WxMsg> {

}
