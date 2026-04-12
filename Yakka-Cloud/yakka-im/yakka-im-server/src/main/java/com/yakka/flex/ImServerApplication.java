package com.yakka.flex;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import com.yakka.basic.validator.annotation.EnableFormValidator;
import com.yakka.flex.common.ServerApplication;

import java.net.UnknownHostException;

import static com.yakka.flex.common.constant.BizConstant.BUSINESS_PACKAGE;
import static com.yakka.flex.common.constant.BizConstant.UTIL_PACKAGE;

/**
 * https://mp.weixin.qq.com/s/zkxI5IQP0jFTjVYe5pTsXw
 * EnableAspectJAutoProxy(proxyTargetClass=true, exposeProxy=true) 配合 @EnableCaching
 * 才能解决在同一个类中通过 AopContext.currentProxy() 调用时，使缓存生效
 *
 * @author Jared
 * @date 2018-01-13 1:34
 */
@SpringBootApplication
@EnableDiscoveryClient
@Configuration
@ComponentScan({
        UTIL_PACKAGE, BUSINESS_PACKAGE
})
@EnableFeignClients(value = {
        UTIL_PACKAGE, BUSINESS_PACKAGE
})
@Slf4j
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@EnableFormValidator
public class ImServerApplication extends ServerApplication {
    public static void main(String[] args) throws UnknownHostException {
        start(ImServerApplication.class, args);
    }
}
