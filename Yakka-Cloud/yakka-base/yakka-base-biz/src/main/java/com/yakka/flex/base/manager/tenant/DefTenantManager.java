package com.yakka.flex.base.manager.tenant;

import com.yakka.basic.base.manager.SuperCacheManager;
import com.yakka.basic.interfaces.echo.LoadService;
import com.yakka.flex.base.entity.tenant.DefTenant;
import com.yakka.flex.base.vo.result.user.DefTenantResultVO;

import java.util.List;

/**
 * <p>
 * 企业租户
 * </p>
 *
 */
public interface DefTenantManager extends SuperCacheManager<DefTenant>, LoadService {
    /**
     * 查询所有可用的租户
     *
     * @return
     */
    List<DefTenant> listNormal();

    /**
     * 查询用户的可用企业
     *
     * @param userId 用户id
     * @return
     */
    List<DefTenantResultVO> listTenantByUserId(Long userId);
}
