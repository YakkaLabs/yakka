package com.yakka.flex.base.manager.user;

import com.yakka.basic.base.manager.SuperManager;
import com.yakka.flex.base.entity.user.BaseOrgRoleRel;

import java.util.Collection;

/**
 * <p>
 * 通用业务接口
 * 组织的角色
 * </p>
 *
 * @author Jared
 * @date 2021-10-18
 */
public interface BaseOrgRoleRelManager extends SuperManager<BaseOrgRoleRel> {

    /**
     * 根据机构ID删除机构的角色
     *
     * @param idList idList
     * @author Jared
     * @date 2022/10/25 9:17 PM
     * @create [2022/10/25 9:17 PM ] [tangyh] [初始创建]
     */
    void deleteByOrg(Collection<Long> idList);

    /**
     * 根据角色ID，删除机构的角色
     *
     * @param idList idList
     * @author Jared
     * @date 2022/10/25 11:21 PM
     * @create [2022/10/25 11:21 PM ] [tangyh] [初始创建]
     */
    void deleteByRole(Collection<Long> idList);
}
