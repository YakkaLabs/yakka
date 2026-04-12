package com.yakka.flex.im.service.tenant;

import com.yakka.basic.base.service.SuperService;
import com.yakka.flex.im.entity.tenant.DefDatasourceConfig;

/**
 * <p>
 * 业务接口
 * 数据源
 * </p>
 *
 * @author Jared
 * @date 2021-09-13
 */
public interface DefDatasourceConfigService extends SuperService<Long, DefDatasourceConfig> {
    /**
     * 测试数据源链接
     *
     * @param id 数据源信息
     * @return
     */
    Boolean testConnection(Long id);
}
