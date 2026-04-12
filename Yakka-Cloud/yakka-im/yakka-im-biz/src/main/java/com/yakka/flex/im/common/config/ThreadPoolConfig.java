package com.yakka.flex.im.common.config;

import com.yakka.basic.context.ContextUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import com.yakka.flex.im.common.factory.MyThreadFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义线程池配置, 不再实现AsyncConfigurer，底层DefaultAsyncTaskConfig已经做了实现
 *
 * @author Jared
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig {
    /**
     * 项目共用线程池
     */
    public static final String YAKKA_EXECUTOR = "yakkaExecutor";

	@Bean(YAKKA_EXECUTOR)
	@Primary
	public Executor yakkaExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(5);
		executor.setMaxPoolSize(20);
		executor.setQueueCapacity(50);
		executor.setKeepAliveSeconds(60); // 空闲线程存活时间
		executor.setThreadNamePrefix("yakka-executor-");
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		executor.setWaitForTasksToCompleteOnShutdown(true);
		executor.setAwaitTerminationSeconds(30); // 停机等待超时
		executor.setThreadFactory(new MyThreadFactory(executor));
		executor.initialize();
		return ContextUtil.getContextAwareExecutor(executor);
	}
}