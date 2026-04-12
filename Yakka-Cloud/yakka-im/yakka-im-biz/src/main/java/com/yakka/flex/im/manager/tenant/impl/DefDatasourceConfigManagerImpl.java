package com.yakka.flex.im.manager.tenant.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.yakka.basic.base.manager.impl.SuperManagerImpl;
import com.yakka.basic.database.mybatis.conditions.Wraps;
import com.yakka.flex.im.entity.tenant.DefDatasourceConfig;
import com.yakka.flex.im.manager.tenant.DefDatasourceConfigManager;
import com.yakka.flex.im.mapper.tenant.DefDatasourceConfigMapper;

/**
 * 应用管理
 *
 * @author Jared
 * @version v1.0
 * @date 2021/9/29 1:26 下午
 * @create [2021/9/29 1:26 下午 ] [tangyh] [初始创建]
 */
@RequiredArgsConstructor
@Service
public class DefDatasourceConfigManagerImpl extends SuperManagerImpl<DefDatasourceConfigMapper, DefDatasourceConfig> implements DefDatasourceConfigManager {
    @Override
    public DefDatasourceConfig getByName(String dsName) {
        return getOne(Wraps.<DefDatasourceConfig>lbQ().eq(DefDatasourceConfig::getName, dsName), false);
    }
}
