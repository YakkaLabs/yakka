package com.yakka.basic.log.event;


import org.springframework.context.ApplicationEvent;
import com.yakka.basic.model.log.OptLogDTO;

/**
 * 系统日志事件
 *
 * @author Jared
 * @date 2019-07-01 15:13
 */
public class SysLogEvent extends ApplicationEvent {

    public SysLogEvent(OptLogDTO source) {
        super(source);
    }
}
