package com.yakka.flex.oauth.facade;

import com.yakka.basic.model.log.OptLogDTO;

/**
 * 操作日志保存 API
 *
 * @author 乾乾
 * @date 2019/07/02
 */
public interface LogFacade {

    /**
     * 保存日志
     *
     * @param log 操作日志
     */
    void save(OptLogDTO log);

}
