package com.yakka.flex.ws.cache;

import com.yakka.basic.model.cache.CacheKey;
import com.yakka.basic.model.cache.CacheKeyBuilder;
import com.yakka.basic.utils.StrPool;
import com.yakka.flex.common.cache.CacheKeyModular;
import com.yakka.flex.common.cache.CacheKeyTable;

import java.time.Duration;

/**
 * 房间管理员的元数据
 */
public class RoomAdminMetadataCacheKeyBuilder implements CacheKeyBuilder {
    
    // 全局在线用户ZSet键
    public static CacheKey builder(Long roomId) {
        return new RoomAdminMetadataCacheKeyBuilder().key(roomId);
    }

	@Override public String getPrefix() {
		return CacheKeyModular.PREFIX;
	}
	@Override public String getTenant() {
		return StrPool.EMPTY;
	}
	@Override public String getModular() {
		return CacheKeyModular.VideoCall;
	}
	@Override public String getTable() {
		return CacheKeyTable.VideoCall.META_DATA_ADMIN;
	}
	@Override public String getField() {
		return "id";
	}
	@Override public ValueType getValueType() {
		return ValueType.obj;
	}
	@Override public Duration getExpire() {
		return Duration.ofMinutes(60);
	}
}