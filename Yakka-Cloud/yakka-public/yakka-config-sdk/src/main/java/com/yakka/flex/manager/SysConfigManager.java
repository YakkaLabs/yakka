package com.yakka.flex.manager;

import com.yakka.flex.entity.Config;
import com.yakka.flex.mapper.SysConfigMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.yakka.basic.base.manager.SuperCacheManager;
import com.yakka.basic.base.manager.impl.SuperCacheManagerImpl;
import com.yakka.basic.interfaces.echo.LoadService;
import com.yakka.basic.model.cache.CacheKeyBuilder;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * 系统配置
 *
 * @author Jared
 * @date 2024-04-18
 */
@RequiredArgsConstructor
@Service
public class SysConfigManager extends SuperCacheManagerImpl<SysConfigMapper, Config>
		implements SuperCacheManager<Config>, LoadService {

	@Override
	public Map<Serializable, Object> findByIds(Set<Serializable> ids) {
		return null;
	}

	@Override
	protected CacheKeyBuilder cacheKeyBuilder() {
		return null;
	}
}
