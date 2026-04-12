package com.yakka.flex.im.core.user.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yakka.flex.im.domain.entity.Black;
import com.yakka.flex.im.core.user.mapper.BlackMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 黑名单 服务实现类
 * </p>
 *
 * @author Jared
 */
@Service
public class BlackDao extends ServiceImpl<BlackMapper, Black> implements IService<Black> {

}
