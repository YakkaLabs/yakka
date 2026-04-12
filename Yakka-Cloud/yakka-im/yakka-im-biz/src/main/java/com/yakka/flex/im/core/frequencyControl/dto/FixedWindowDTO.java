package com.yakka.flex.im.core.frequencyControl.dto;

import lombok.Data;

/**
 * 限流策略定义
 * @author Jared
 */
@Data
public class FixedWindowDTO extends FrequencyControlDTO {

    /**
     * 频控时间范围，默认单位秒
     *  时间范围
     */
    private Integer time;

}
