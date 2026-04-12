package com.yakka.flex.base.manager.tenant;

import com.yakka.basic.base.manager.SuperCacheManager;
import com.yakka.flex.base.entity.tenant.DefUserTenantRel;
import com.yakka.flex.base.vo.query.tenant.DefUserTenantRelResultVO;

import java.util.List;

/**
 * <p>
 * 通用业务接口
 * 员工
 * </p>
 *
 * @author Jared
 * @date 2021-10-27
 */
public interface DefUserTenantRelManager extends SuperCacheManager<DefUserTenantRel> {
    /**
     * 根据用户id查询员工
     *
     * @param userId 用户id
     * @return
     */
    List<DefUserTenantRelResultVO> listEmployeeByUserId(Long userId);
}
