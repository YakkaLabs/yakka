package com.yakka.flex.im.core.chat.service.cache;

import com.yakka.flex.im.common.constant.RedisKey;
import com.yakka.flex.im.common.service.cache.AbstractRedisStringCache;
import com.yakka.flex.im.core.chat.dao.RoomGroupDao;
import com.yakka.flex.im.domain.entity.RoomGroup;
import jakarta.annotation.Resource;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 群组基本信息的缓存 [roomId版]
 * @author Jared
 */
@Component
public class RoomGroupCache extends AbstractRedisStringCache<Long, RoomGroup> {
    @Resource
    private RoomGroupDao roomGroupDao;

    @Override
    protected String getKey(Long roomId) {
        return RedisKey.getKey(RedisKey.GROUP_INFO_FORMAT, roomId);
    }

    @Override
    protected Long getExpireSeconds() {
        return 5 * 60L;
    }

    @Override
    protected Map<Long, RoomGroup> load(List<Long> roomIds) {
        List<RoomGroup> roomGroups = roomGroupDao.listByRoomIds(roomIds);
        return roomGroups.stream().collect(Collectors.toMap(RoomGroup::getRoomId, Function.identity()));
    }

	public RoomGroup getByRoomId(Long roomId) {
		return roomGroupDao.getByRoomId(roomId);
	}

	public boolean removeById(Serializable id) {
		return roomGroupDao.removeById(id);
	}

	/**
	 * 根据群号查询群信息
	 */
	@Cacheable(cacheNames = "yakka:room:findGroup", key = "#account")
	public List<RoomGroup> searchGroup(String account) {
		return roomGroupDao.searchGroup(account);
	}

	/**
	 * 当 key 的数据改变后需要调用此方法
	 * @param account
	 * @return
	 */
	@CacheEvict(cacheNames = "yakka:room:findGroup", key = "#account")
	public List<Long> evictGroup(String account) {
		return null;
	}

	/**
	 * 清除所有群组相关缓存
	 */
	@CacheEvict(cacheNames = "yakka:room:findGroup", allEntries = true)
	public void evictAllCaches() {
	}
}
