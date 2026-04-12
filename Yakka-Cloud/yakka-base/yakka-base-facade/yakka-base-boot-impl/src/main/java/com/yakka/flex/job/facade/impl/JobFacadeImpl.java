package com.yakka.flex.job.facade.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.yakka.basic.base.R;
import com.yakka.flex.job.dto.XxlJobInfoVO;
import com.yakka.flex.job.facade.JobFacade;

/**
 *
 * @author Jared
 * @since 2024/9/21 00:09
 */
@Service
@RequiredArgsConstructor
public class JobFacadeImpl implements JobFacade {
    @Value("${yakka.feign.job-server:http://127.0.0.1:8767}")
    private String jobServerUrl;

    @Override
    public R<String> addTimingTask(XxlJobInfoVO xxlJobInfo) {
        String URL = "/xxl-job-admin/jobinfo/save";
        String result = HttpRequest.post(jobServerUrl + URL)
                .body(JSONUtil.toJsonStr(xxlJobInfo))
                .timeout(20000)//超时，毫秒
                .execute().body();
        return R.success(result);
    }


}
