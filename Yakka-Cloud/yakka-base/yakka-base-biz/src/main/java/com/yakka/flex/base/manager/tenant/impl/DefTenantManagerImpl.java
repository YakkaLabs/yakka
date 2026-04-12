package com.yakka.flex.base.manager.tenant.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.yakka.basic.base.manager.impl.SuperCacheManagerImpl;
import com.yakka.basic.database.mybatis.conditions.Wraps;
import com.yakka.basic.model.cache.CacheKeyBuilder;
import com.yakka.basic.utils.BeanPlusUtil;
import com.yakka.basic.utils.CollHelper;
import com.yakka.flex.base.entity.tenant.DefTenant;
import com.yakka.flex.base.entity.tenant.DefUserTenantRel;
import com.yakka.flex.base.manager.tenant.DefTenantManager;
import com.yakka.flex.base.mapper.application.DefUserTenantRelMapper;
import com.yakka.flex.base.mapper.tenant.DefTenantMapper;
import com.yakka.flex.base.vo.result.user.DefTenantResultVO;
import com.yakka.flex.common.cache.tenant.application.TenantCacheKeyBuilder;
import com.yakka.flex.model.constant.EchoApi;
import com.yakka.flex.model.enumeration.system.DefTenantStatusEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 应用管理
 *
 * @author Jared
 * @version v1.0
 * @date 2021/9/29 1:26 下午
 * @create [2021/9/29 1:26 下午 ] [tangyh] [初始创建]
 */
@RequiredArgsConstructor
@Service(EchoApi.DEF_TENANT_SERVICE_IMPL_CLASS)
public class DefTenantManagerImpl extends SuperCacheManagerImpl<DefTenantMapper, DefTenant> implements DefTenantManager {

    private final DefUserTenantRelMapper defUserTenantRelMapper;

    @Override
    protected CacheKeyBuilder cacheKeyBuilder() {
        return new TenantCacheKeyBuilder();
    }

    @Override
    public Map<Serializable, Object> findByIds(Set<Serializable> ids) {
        return CollHelper.uniqueIndex(find(ids), DefTenant::getId, DefTenant::getName);
    }

    public List<DefTenant> find(Set<Serializable> ids) {
        // 强转， 防止数据库隐式转换，  若你的id 是string类型，请勿强转
        return findByIds(ids, null).stream().filter(Objects::nonNull).toList();
    }


    @Override
    public List<DefTenant> listNormal() {
        return list(Wraps.<DefTenant>lbQ().eq(DefTenant::getStatus, DefTenantStatusEnum.NORMAL.getCode()));
    }

    @Override
    public List<DefTenantResultVO> listTenantByUserId(Long userId) {
        // 1. 查询用户的所有租户关系（员工信息）
        List<DefUserTenantRel> userTenantRelList = defUserTenantRelMapper.selectList(
                Wrappers.<DefUserTenantRel>lambdaQuery()
                        .eq(DefUserTenantRel::getUserId, userId)
        );

        if (userTenantRelList.isEmpty()) {
            return List.of();
        }

        // 2. 提取租户ID列表
        List<Long> tenantIds = userTenantRelList.stream()
                .map(DefUserTenantRel::getTenantId)
                .collect(Collectors.toList());

        // 3. 查询租户信息
        List<DefTenant> tenantList = baseMapper.selectByIds(tenantIds);

        // 4. 转换为 VO 并填充员工信息
        Map<Long, DefUserTenantRel> relMap = userTenantRelList.stream()
                .collect(Collectors.toMap(DefUserTenantRel::getTenantId, rel -> rel));

        return tenantList.stream()
                .map(tenant -> {
                    DefTenantResultVO vo = BeanPlusUtil.toBean(tenant, DefTenantResultVO.class);
                    DefUserTenantRel rel = relMap.get(tenant.getId());
                    if (rel != null) {
                        vo.setEmployeeId(rel.getId());
                        vo.setEmployeeState(rel.getState());
                        vo.setIsDefault(rel.getIsDefault());
                    }
                    return vo;
                })
                .collect(Collectors.toList());
    }
}
