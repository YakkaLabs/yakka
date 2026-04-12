package com.yakka.flex.base.service;

import com.yakka.basic.base.manager.SuperCacheManager;
import com.yakka.flex.base.entity.user.BaseEmployee;

/**
 * @author Jared
 * @version v1.0
 * @date 2022/9/20 11:31 AM
 * @create [2022/9/20 11:31 AM ] [tangyh] [初始创建]
 */
public interface BaseEmployeeTestService extends SuperCacheManager<BaseEmployee> {
    /**
     * 单体查询
     *
     * @param id id
     * @return com.yakka.flex.base.entity.user.BaseEmployee
     * @author Jared
     * @date 2022/10/28 9:20 AM
     * @create [2022/10/28 9:20 AM ] [tangyh] [初始创建]
     */
    BaseEmployee get(Long id);
}
