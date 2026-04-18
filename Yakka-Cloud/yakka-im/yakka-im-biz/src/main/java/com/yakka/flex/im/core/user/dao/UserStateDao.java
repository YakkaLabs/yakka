package com.yakka.flex.im.core.user.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yakka.flex.im.domain.entity.UserState;
import com.yakka.flex.im.core.user.mapper.UserStateMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户在线状态表
 * </p>
 *
 * @author 乾乾
 */
@Service
public class UserStateDao extends ServiceImpl<UserStateMapper, UserState> {

	@Cacheable(cacheNames = "yakka:user", key = "'state'")
	public List<UserState> list() {
		return lambdaQuery()
				.list();
	}
}
