package com.yakka.flex.base.manager.application.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.yakka.basic.base.manager.impl.SuperCacheManagerImpl;
import com.yakka.basic.database.mybatis.conditions.Wraps;
import com.yakka.basic.model.cache.CacheKeyBuilder;
import com.yakka.basic.utils.CollHelper;
import com.yakka.flex.base.entity.application.DefApplication;
import com.yakka.flex.base.mapper.application.DefApplicationMapper;
import com.yakka.flex.base.vo.result.application.DefApplicationResultVO;
import com.yakka.flex.common.cache.tenant.application.ApplicationCacheKeyBuilder;
import com.yakka.flex.model.constant.EchoApi;
import com.yakka.flex.base.manager.application.DefApplicationManager;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 应用管理
 *
 * @author Jared
 * @version v1.0
 * @date 2021/9/29 1:26 下午
 * @create [2021/9/29 1:26 下午 ] [tangyh] [初始创建]
 */
@RequiredArgsConstructor
@Service(EchoApi.DEF_APPLICATION_SERVICE_IMPL_CLASS)
public class DefApplicationManagerImpl extends SuperCacheManagerImpl<DefApplicationMapper, DefApplication> implements DefApplicationManager {

    @Override
    protected CacheKeyBuilder cacheKeyBuilder() {
        return new ApplicationCacheKeyBuilder();
    }


    @Override
    public Map<Serializable, Object> findByIds(Set<Serializable> ids) {
        return CollHelper.uniqueIndex(find(ids), DefApplication::getId, DefApplication::getName);
    }

    public List<DefApplication> find(Set<Serializable> ids) {
//         强转， 防止数据库隐式转换，  若你的id 是string类型，请勿强转
        return findByIds(ids, null).stream().filter(Objects::nonNull).toList();
    }

    @Override
    public List<DefApplicationResultVO> findMyApplication(String name) {
        return baseMapper.findMyApplication(name);
    }

    @Override
    public List<DefApplicationResultVO> findRecommendApplication(String name) {
        return Collections.emptyList();
    }

    @Override
    public List<DefApplication> findGeneral() {
        return list(Wraps.<DefApplication>lbQ().eq(DefApplication::getIsGeneral, true));
    }

}
