package com.yakka.flex.base.mapper.application;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.yakka.basic.base.mapper.SuperMapper;
import com.yakka.flex.base.entity.application.DefTenantApplicationRel;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * 租户的应用
 * </p>
 *
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface DefTenantApplicationRelMapper extends SuperMapper<DefTenantApplicationRel> {

}
