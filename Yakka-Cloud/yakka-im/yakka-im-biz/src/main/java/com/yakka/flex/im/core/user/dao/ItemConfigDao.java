package com.yakka.flex.im.core.user.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yakka.flex.im.domain.entity.ItemConfig;
import com.yakka.flex.im.core.user.mapper.ItemConfigMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 功能物品配置表 服务实现类
 * </p>
 *
 * @author Jared
 */
@Service
public class ItemConfigDao extends ServiceImpl<ItemConfigMapper, ItemConfig> {

	public List<ItemConfig> getByType(Integer type) {
		return lambdaQuery()
				.eq(ItemConfig::getType, type)
				.list();
	}
}
