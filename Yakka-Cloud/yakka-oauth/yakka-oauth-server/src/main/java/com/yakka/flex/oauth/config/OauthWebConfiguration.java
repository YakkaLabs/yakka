package com.yakka.flex.oauth.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.yakka.basic.boot.config.BaseConfig;
import com.yakka.basic.log.event.SysLogListener;
import com.yakka.basic.utils.BeanPlusUtil;
import com.yakka.flex.base.service.system.BaseOperationLogService;
import com.yakka.flex.base.vo.save.system.BaseOperationLogSaveVO;
import com.yakka.flex.common.properties.SystemProperties;

/**
 * @author Jared
 * @date 2017-12-15 14:42
 */
@Configuration
@EnableConfigurationProperties(SystemProperties.class)
public class OauthWebConfiguration extends BaseConfig {

    /**
     * yakka.log.enabled = true 并且 yakka.log.type=DB时实例该类
     */
    @Bean
    @ConditionalOnExpression("${yakka.log.enabled:true} && 'DB'.equals('${yakka.log.type:LOGGER}')")
    public SysLogListener sysLogListener(BaseOperationLogService logApi) {
        return new SysLogListener(data -> logApi.save(BeanPlusUtil.toBean(data, BaseOperationLogSaveVO.class)));
    }
}
