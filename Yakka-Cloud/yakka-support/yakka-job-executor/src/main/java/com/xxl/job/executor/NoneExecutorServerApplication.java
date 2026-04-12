package com.xxl.job.executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import com.yakka.basic.validator.annotation.EnableFormValidator;

import static com.yakka.flex.common.constant.BizConstant.BUSINESS_PACKAGE;
import static com.yakka.flex.common.constant.BizConstant.UTIL_PACKAGE;

/**
 * @author Jared
 */
@SpringBootApplication
@ComponentScan({
        UTIL_PACKAGE, BUSINESS_PACKAGE, "com.xxl.job.executor"
})
@EnableFormValidator
public class NoneExecutorServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoneExecutorServerApplication.class, args);
    }

}
