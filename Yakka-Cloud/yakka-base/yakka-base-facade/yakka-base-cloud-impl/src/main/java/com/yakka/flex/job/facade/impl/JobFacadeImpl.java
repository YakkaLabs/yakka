package com.yakka.flex.job.facade.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import com.yakka.basic.base.R;
import com.yakka.flex.job.api.JobApi;
import com.yakka.flex.job.dto.XxlJobInfoVO;
import com.yakka.flex.job.facade.JobFacade;

/**
 *
 * @author Jared
 * @since 2024/9/21 00:15
 */
@Service
@RequiredArgsConstructor
public class JobFacadeImpl implements JobFacade {
    @Autowired
    @Lazy  // 一定要延迟加载，否则yakka-gateway-server无法启动
    private JobApi jobApi;

    @Override
    public R<String> addTimingTask(XxlJobInfoVO xxlJobInfo) {
        return jobApi.addTimingTask(xxlJobInfo);
    }
}
