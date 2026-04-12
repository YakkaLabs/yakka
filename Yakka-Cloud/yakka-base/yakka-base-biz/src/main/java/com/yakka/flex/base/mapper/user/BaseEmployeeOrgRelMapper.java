package com.yakka.flex.base.mapper.user;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.yakka.basic.base.mapper.SuperMapper;
import com.yakka.flex.base.entity.user.BaseEmployeeOrgRel;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * 员工所在部门
 * </p>
 *
 * @author Jared
 * @date 2021-10-18
 */
@Repository
public interface BaseEmployeeOrgRelMapper extends SuperMapper<BaseEmployeeOrgRel> {

    /**
     * 查询员工拥有的机构
     *
     * @param employeeId employeeId
     * @return java.util.List<java.lang.Long>
     * @author Jared
     * @date 2022/10/20 3:44 PM
     * @create [2022/10/20 3:44 PM ] [tangyh] [初始创建]
     */
    List<Long> selectOrgByEmployeeId(@Param("employeeId") Long employeeId);
}
