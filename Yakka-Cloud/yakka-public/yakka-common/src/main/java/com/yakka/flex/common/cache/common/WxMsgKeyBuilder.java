package com.yakka.flex.common.cache.common;

import com.yakka.basic.model.cache.CacheHashKey;
import com.yakka.basic.model.cache.CacheKeyBuilder;
import com.yakka.flex.common.cache.CacheKeyModular;
import com.yakka.flex.common.cache.CacheKeyTable;

import java.time.Duration;

/**
 * 密码 KEY
 * [服务模块名:]业务类型[:业务字段][:value类型][:应用id] -> obj
 * tenant:def_application:id:obj:1 -> {}
 * <p>
 * #def_application
 *
 * @author Jared
 * @date 2020/9/20 6:45 下午
 */
public class WxMsgKeyBuilder implements CacheKeyBuilder {
	public static CacheHashKey builder(String uuid) {
		return new WxMsgKeyBuilder().hashKey(uuid);
	}

	public static CacheHashKey builder(String uuid, Long expire) {
		CacheHashKey cacheKey = builder(uuid);
		if (expire != null) {
			cacheKey.setExpire(Duration.ofSeconds(expire));
		}
		return cacheKey;
	}

	@Override
	public String getTable() {
		return CacheKeyTable.Chat.WX_MSG;
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
	public String getModular() {
		return CacheKeyModular.CHAT;
	}

	@Override
	public String getField() {
		return null;
	}

	@Override
	public ValueType getValueType() {
		return ValueType.string;
	}
}
