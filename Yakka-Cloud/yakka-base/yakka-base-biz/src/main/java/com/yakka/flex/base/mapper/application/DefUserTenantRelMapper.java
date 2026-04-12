package com.yakka.flex.base.mapper.application;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.yakka.basic.base.mapper.SuperMapper;
import com.yakka.flex.base.entity.tenant.DefUserTenantRel;
import com.yakka.flex.base.vo.query.tenant.DefUserTenantRelResultVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * 员工
 * </p>
 *
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface DefUserTenantRelMapper extends SuperMapper<DefUserTenantRel> {
    /**
     * 根据用户id查询员工
     *
     * @param userId 用户id
     * @return
     */
    List<DefUserTenantRelResultVO> listEmployeeByUserId(@Param("userId") Long userId);
}
