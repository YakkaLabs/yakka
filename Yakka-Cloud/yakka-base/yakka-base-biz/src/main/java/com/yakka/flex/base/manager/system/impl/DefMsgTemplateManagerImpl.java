package com.yakka.flex.base.manager.system.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.yakka.basic.base.manager.impl.SuperManagerImpl;
import com.yakka.basic.database.mybatis.conditions.Wraps;
import com.yakka.flex.base.entity.system.DefMsgTemplate;
import com.yakka.flex.base.manager.system.DefMsgTemplateManager;
import com.yakka.flex.base.mapper.system.DefMsgTemplateMapper;

/**
 * <p>
 * 通用业务实现类
 * 消息模板
 * </p>
 *
 * @author Jared
 * @date 2022-07-04 15:51:37
 * @create [2022-07-04 15:51:37] [zuihou] [代码生成器生成]
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class DefMsgTemplateManagerImpl extends SuperManagerImpl<DefMsgTemplateMapper, DefMsgTemplate> implements DefMsgTemplateManager {
    @Override
    public DefMsgTemplate getByCode(String code) {
        return getOne(Wraps.<DefMsgTemplate>lbQ().eq(DefMsgTemplate::getCode, code));
    }
}


