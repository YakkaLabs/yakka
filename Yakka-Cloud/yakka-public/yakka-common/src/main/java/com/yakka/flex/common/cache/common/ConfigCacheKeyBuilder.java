package com.yakka.flex.common.cache.common;

import com.yakka.basic.base.entity.SuperEntity;
import com.yakka.basic.model.cache.CacheHashKey;
import com.yakka.basic.model.cache.CacheKeyBuilder;
import com.yakka.flex.common.cache.CacheKeyModular;
import com.yakka.flex.common.cache.CacheKeyTable;

import java.time.Duration;

/**
 * 系统配置 KEY
 * <p>
 *
 * @author Jared
 * @date 2024/04/20 6:45 下午
 */
public class ConfigCacheKeyBuilder implements CacheKeyBuilder {
    public static CacheHashKey build(String key) {
        return new ConfigCacheKeyBuilder().hashFieldKey(key);
    }

    @Override
    public String getTable() {
        return CacheKeyTable.System.SYS_CONFIG;
    }

	@Override
	public String getModular() {
		return CacheKeyModular.SYSTEM;
	}

	@Override
	public String getPrefix() {
		return CacheKeyModular.PREFIX;
	}

	@Override
	public String getTenant() {
		return null;
	}

    @Override
    public String getField() {
        return SuperEntity.ID_FIELD;
    }

    @Override
    public Duration getExpire() {
        return Duration.ofHours(24 * 30);
    }

    @Override
    public ValueType getValueType() {
        return ValueType.string;
    }
}
