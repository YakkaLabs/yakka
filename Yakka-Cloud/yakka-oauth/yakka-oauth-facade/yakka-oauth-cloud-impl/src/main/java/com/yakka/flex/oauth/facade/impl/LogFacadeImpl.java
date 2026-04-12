package com.yakka.flex.oauth.facade.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import com.yakka.basic.model.log.OptLogDTO;
import com.yakka.flex.oauth.api.LogApi;
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
    @Autowired
    @Lazy  // 一定要延迟加载，否则yakka-gateway-server无法启动
    private LogApi logApi;

    /**
     * 保存日志
     *
     * @param data 操作日志
     * @return 操作日志
     */
    public void save(OptLogDTO data) {
        logApi.save(data);
    }

}
