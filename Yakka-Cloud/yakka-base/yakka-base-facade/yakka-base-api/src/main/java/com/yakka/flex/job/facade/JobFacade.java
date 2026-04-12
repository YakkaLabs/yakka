package com.yakka.flex.job.facade;

import com.yakka.basic.base.R;
import com.yakka.flex.job.dto.XxlJobInfoVO;

/**
 * @author Jared
 * @since 2024年09月21日00:15:26
 */
public interface JobFacade {
    /**
     * 定时发送接口
     *
     * @param xxlJobInfo 任务
     * @return 任务id
     */
    R<String> addTimingTask(XxlJobInfoVO xxlJobInfo);

}
