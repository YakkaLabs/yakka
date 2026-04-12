package com.yakka.flex.base.manager.system.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.yakka.basic.base.manager.impl.SuperManagerImpl;
import com.yakka.flex.base.entity.system.DefArea;
import com.yakka.flex.base.manager.system.DefAreaManager;
import com.yakka.flex.base.mapper.system.DefAreaMapper;

/**
 * <p>
 * 通用业务实现类
 * 地区表
 * </p>
 *
 * @author Jared
 * @date 2021-10-13
 * @create [2021-10-13] [zuihou] [代码生成器生成]
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DefAreaManagerImpl extends SuperManagerImpl<DefAreaMapper, DefArea> implements DefAreaManager {
}
