package com.yakka.flex.msg.manager.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.yakka.basic.base.manager.impl.SuperManagerImpl;
import com.yakka.flex.msg.entity.ExtendNotice;
import com.yakka.flex.msg.manager.ExtendNoticeManager;
import com.yakka.flex.msg.mapper.ExtendNoticeMapper;

/**
 * <p>
 * 通用业务实现类
 * 通知表
 * </p>
 *
 * @author Jared
 * @date 2022-07-04 15:51:37
 * @create [2022-07-04 15:51:37] [zuihou] [代码生成器生成]
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class ExtendNoticeManagerImpl extends SuperManagerImpl<ExtendNoticeMapper, ExtendNotice> implements ExtendNoticeManager {

}


