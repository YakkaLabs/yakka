package com.yakka.flex.common.cache.base.system;

import com.yakka.basic.base.entity.SuperEntity;
import com.yakka.basic.model.cache.CacheKey;
import com.yakka.basic.model.cache.CacheKeyBuilder;
import com.yakka.flex.common.cache.CacheKeyModular;
import com.yakka.flex.common.cache.CacheKeyTable;

import java.time.Duration;

/**
 * 角色 KEY
 * <p>
 *
 * @author Jared
 * @date 2020/9/20 6:45 下午
 */
public class RoleCacheKeyBuilder implements CacheKeyBuilder {
    public static CacheKey build(Long roleId) {
        return new RoleCacheKeyBuilder().key(roleId);
    }

    @Override
    public String getTenant() {
        return null;
    }

    @Override
    public String getTable() {
        return CacheKeyTable.Base.ROLE;
    }

    @Override
    public String getPrefix() {
        return CacheKeyModular.PREFIX;
    }

    @Override
    public String getModular() {
        return CacheKeyModular.BASE;
    }

    @Override
    public String getField() {
        return SuperEntity.ID_FIELD;
    }

    @Override
    public Duration getExpire() {
        return Duration.ofHours(24);
    }

    @Override
    public ValueType getValueType() {
        return ValueType.obj;
    }
}
