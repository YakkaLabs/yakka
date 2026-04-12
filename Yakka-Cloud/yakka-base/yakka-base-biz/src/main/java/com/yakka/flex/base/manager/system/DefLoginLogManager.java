package com.yakka.flex.base.manager.system;

import com.yakka.basic.base.manager.SuperManager;
import com.yakka.flex.base.entity.system.DefLoginLog;

import java.time.LocalDateTime;

/**
 * <p>
 * 通用业务接口
 * 登录日志
 * </p>
 *
 * @author Jared
 * @date 2021-11-12
 */
public interface DefLoginLogManager extends SuperManager<DefLoginLog> {
    /**
     * 清理日志
     *
     * @param clearBeforeTime 多久之前的
     * @param clearBeforeNum  多少条
     * @return 是否成功
     */
    Long clearLog(LocalDateTime clearBeforeTime, Integer clearBeforeNum);
}
