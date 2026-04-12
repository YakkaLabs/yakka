package com.yakka.flex.base.manager.system.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.yakka.basic.base.manager.impl.SuperManagerImpl;
import com.yakka.basic.cache.repository.CacheOps;
import com.yakka.basic.database.mybatis.conditions.Wraps;
import com.yakka.basic.model.cache.CacheKey;
import com.yakka.flex.base.entity.system.BaseRoleResourceRel;
import com.yakka.flex.base.manager.system.BaseRoleResourceRelManager;
import com.yakka.flex.base.mapper.system.BaseRoleResourceRelMapper;
import com.yakka.flex.common.cache.base.system.RoleResourceCacheKeyBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 通用业务实现类
 * 角色的资源
 * </p>
 *
 * @author Jared
 * @date 2021-10-18
 * @create [2021-10-18] [zuihou] [代码生成器生成]
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class BaseRoleResourceRelManagerImpl extends SuperManagerImpl<BaseRoleResourceRelMapper, BaseRoleResourceRel> implements BaseRoleResourceRelManager {
    private final CacheOps cacheOps;

    @Override
    public List<BaseRoleResourceRel> findByRoleIdAndCategory(Long roleId, String category) {
        return baseMapper.findByRoleIdAndCategory(roleId, category);
    }

    @Override
    public void deleteByRole(Collection<Long> roleIdList) {
        List<BaseRoleResourceRel> roleResourceRelList = list(Wraps.<BaseRoleResourceRel>lbQ().in(BaseRoleResourceRel::getRoleId, roleIdList));
        super.remove(Wraps.<BaseRoleResourceRel>lbQ().in(BaseRoleResourceRel::getRoleId, roleIdList));

        List<CacheKey> keys = new ArrayList<>();
        for (BaseRoleResourceRel rr : roleResourceRelList) {
            keys.add(RoleResourceCacheKeyBuilder.build(rr.getApplicationId(), rr.getRoleId()));
            keys.add(RoleResourceCacheKeyBuilder.build(null, rr.getRoleId()));
        }
        cacheOps.del(keys);
    }
}
