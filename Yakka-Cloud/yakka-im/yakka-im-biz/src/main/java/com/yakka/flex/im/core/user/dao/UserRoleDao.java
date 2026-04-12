package com.yakka.flex.im.core.user.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yakka.flex.im.domain.entity.UserRole;
import com.yakka.flex.im.core.user.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户角色关系表 服务实现类
 * </p>
 *
 * @author Jared
 */
@Service
public class UserRoleDao extends ServiceImpl<UserRoleMapper, UserRole> {

	public Set<Long> listByUid(Long uid) {
		return lambdaQuery()
				.eq(UserRole::getUid, uid).select(UserRole::getUid).list().stream().map(UserRole::getUid).collect(Collectors.toSet());
	}
}
