package com.yakka.flex.base.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.yakka.basic.boot.config.BaseConfig;
import com.yakka.basic.constant.Constants;
import com.yakka.basic.log.event.SysLogListener;
import com.yakka.flex.oauth.facade.LogFacade;

/**
 * 基础服务-Web配置
 *
 * @author 乾乾
 * @date 2021-10-08
 */
@Configuration
public class BaseWebConfiguration extends BaseConfig {

    /**
     * yakka.log.enabled = true 并且 yakka.log.type=DB时实例该类
     */
    @Bean
    @ConditionalOnExpression("${" + Constants.PROJECT_PREFIX + ".log.enabled:true} && 'DB'.equals('${" + Constants.PROJECT_PREFIX + ".log.type:LOGGER}')")
    public SysLogListener sysLogListener(LogFacade logApi) {
        return new SysLogListener(logApi::save);
    }
}
