package com.yakka.flex.base.service.system.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yakka.basic.base.service.impl.SuperCacheServiceImpl;
import com.yakka.basic.database.mybatis.conditions.Wraps;
import com.yakka.basic.utils.ArgumentAssert;

import com.yakka.flex.base.entity.system.DefParameter;
import com.yakka.flex.base.manager.system.DefParameterManager;
import com.yakka.flex.base.vo.save.system.DefParameterSaveVO;
import com.yakka.flex.model.enumeration.system.DataTypeEnum;
import com.yakka.flex.base.service.system.DefParameterService;

/**
 * <p>
 * 业务实现类
 * 参数配置
 * </p>
 *
 * @author Jared
 * @date 2021-10-13
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)

public class DefParameterServiceImpl extends SuperCacheServiceImpl<DefParameterManager, Long, DefParameter> implements DefParameterService {

    @Override
    protected <SaveVO> DefParameter saveBefore(SaveVO saveVO) {
        DefParameterSaveVO defParameterSaveVO = (DefParameterSaveVO) saveVO;
        DefParameter defParameter = super.saveBefore(defParameterSaveVO);
        defParameter.setParamType(DataTypeEnum.SYSTEM.getCode());
        return defParameter;
    }

    @Override
    public Boolean checkKey(String key, Long id) {
        ArgumentAssert.notEmpty(key, "请填写参数健");
        return superManager.count(Wraps.<DefParameter>lbQ().eq(DefParameter::getKey, key).ne(DefParameter::getId, id)) > 0;
    }
}
