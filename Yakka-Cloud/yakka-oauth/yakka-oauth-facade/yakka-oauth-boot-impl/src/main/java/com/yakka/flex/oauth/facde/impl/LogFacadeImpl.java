package com.yakka.flex.oauth.facde.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.yakka.basic.model.log.OptLogDTO;
import com.yakka.basic.utils.BeanPlusUtil;
import com.yakka.flex.base.service.system.BaseOperationLogService;
import com.yakka.flex.base.vo.save.system.BaseOperationLogSaveVO;
import com.yakka.flex.oauth.facade.LogFacade;

/**
 * 操作日志保存 API
 *
 * @author Jared
 * @date 2019/07/02
 */
@Service
@RequiredArgsConstructor
public class LogFacadeImpl implements LogFacade {
    private final BaseOperationLogService baseOperationLogService;

    /**
     * 保存日志
     *
     * @param data 操作日志
     * @return 操作日志
     */
    public void save(OptLogDTO data) {
        BaseOperationLogSaveVO bean = BeanPlusUtil.toBean(data, BaseOperationLogSaveVO.class);
        baseOperationLogService.save(bean);
    }

}
