package com.yakka.flex.im.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.yakka.basic.boot.config.BaseConfig;
import com.yakka.basic.log.event.SysLogListener;
import com.yakka.flex.oauth.facade.LogFacade;

/**
 * @author Jared
 * @date 2017-12-15 14:42
 */
@Configuration
public class SystemWebConfiguration extends BaseConfig {

    /**
     * yakka.log.enabled = true 并且 yakka.log.type=DB时实例该类
     */
    @Bean
    @ConditionalOnExpression("${yakka.log.enabled:true} && 'DB'.equals('${yakka.log.type:LOGGER}')")
    public SysLogListener sysLogListener(LogFacade logApi) {
        return new SysLogListener(logApi::save);
    }
}
