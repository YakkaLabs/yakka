package com.yakka.flex.im.core.user.service.impl;

import com.yakka.flex.im.core.user.dao.UserRoleDao;
import com.yakka.flex.im.core.user.service.cache.UserSummaryCache;
import com.yakka.flex.im.domain.entity.UserRole;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import com.yakka.flex.im.domain.enums.RoleTypeEnum;
import com.yakka.flex.im.core.user.service.RoleService;

import java.util.List;
import java.util.Set;

/**
 * @author Jared
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private UserRoleDao userRoleDao;

    @Override
    public boolean hasRole(Long uid, RoleTypeEnum roleTypeEnum) {
        Set<Long> roleSet = userRoleDao.listByUid(uid);
        return isAdmin(roleSet) || roleSet.contains(roleTypeEnum.getId());
    }

    private boolean isAdmin(Set<Long> roleSet) {
        return roleSet.contains(RoleTypeEnum.ADMIN.getId());
    }
}
