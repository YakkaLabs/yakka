package com.yakka.flex.im.core.chat.service.cache;

import com.yakka.flex.im.common.constant.RedisKey;
import com.yakka.flex.im.common.service.cache.AbstractRedisStringCache;
import com.yakka.flex.im.core.chat.dao.RoomGroupDao;
import com.yakka.flex.im.domain.entity.RoomGroup;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 群组基本信息的缓存 [id版]
 * @author 乾乾
 */
@Component
public class GroupCache extends AbstractRedisStringCache<Long, RoomGroup> {
    @Resource
    private RoomGroupDao roomGroupDao;

    @Override
    protected String getKey(Long groupId) {
        return RedisKey.getKey(RedisKey.GROUP_INFO_FORMAT, groupId);
    }

    @Override
    protected Long getExpireSeconds() {
        return 5 * 60L;
    }

    @Override
    protected Map<Long, RoomGroup> load(List<Long> groupIds) {
        List<RoomGroup> roomGroups = roomGroupDao.listByIds(groupIds);
        return roomGroups.stream().collect(Collectors.toMap(RoomGroup::getId, Function.identity()));
    }
}
