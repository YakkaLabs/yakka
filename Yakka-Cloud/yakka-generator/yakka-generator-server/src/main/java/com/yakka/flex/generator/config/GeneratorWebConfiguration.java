package com.yakka.flex.generator.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.yakka.basic.boot.config.BaseConfig;
import com.yakka.basic.log.event.SysLogListener;
import com.yakka.flex.oauth.facade.LogFacade;

/**
 * 在线代码生成器模块-Web配置
 *
 * @author 乾乾
 * @date 2022-02-28
 */
@Configuration
public class GeneratorWebConfiguration extends BaseConfig {

    /**
     * yakka.log.enabled = true 并且 yakka.log.type=DB时实例该类
     */
    @Bean
    @ConditionalOnExpression("${yakka.log.enabled:true} && 'DB'.equals('${yakka.log.type:LOGGER}')")
    public SysLogListener sysLogListener(LogFacade logApi) {
        return new SysLogListener(logApi::save);
    }
}
