package com.yakka.flex.im.core.user.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.yakka.flex.im.domain.entity.Role;
import com.yakka.flex.im.core.user.mapper.RoleMapper;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author Jared
 */
@Service
public class RoleDao extends ServiceImpl<RoleMapper, Role> {

}
