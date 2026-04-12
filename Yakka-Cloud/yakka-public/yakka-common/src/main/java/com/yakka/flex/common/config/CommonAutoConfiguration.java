package com.yakka.flex.common.config;

import cn.hutool.core.util.StrUtil;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.yakka.flex.common.aspect.YakkaLogAspect;
import com.yakka.flex.common.cache.CacheKeyModular;
import com.yakka.flex.common.properties.IgnoreProperties;
import com.yakka.flex.common.properties.SystemProperties;

/**
 * @author Jared
 * @version v1.0
 * @date 2021/9/5 8:04 下午
 * @create [2021/9/5 8:04 下午 ] [tangyh] [初始创建]
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
@ConditionalOnWebApplication
@EnableConfigurationProperties({SystemProperties.class, IgnoreProperties.class})
public class CommonAutoConfiguration {
    private final SystemProperties systemProperties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = SystemProperties.PREFIX, name = "recordYakka", havingValue = "true", matchIfMissing = true)
    public YakkaLogAspect getYakkaLogAspect() {
        return new YakkaLogAspect(systemProperties);
    }

    @PostConstruct
    public void init() {
        if (StrUtil.isNotEmpty(systemProperties.getCachePrefix())) {
            CacheKeyModular.PREFIX = systemProperties.getCachePrefix();
            log.info("检查到配置文件中：{}.cachePrefix={}", SystemProperties.PREFIX, systemProperties.getCachePrefix());
        }
    }


}
