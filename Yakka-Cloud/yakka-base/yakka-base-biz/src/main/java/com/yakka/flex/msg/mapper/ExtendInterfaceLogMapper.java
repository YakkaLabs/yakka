package com.yakka.flex.msg.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.yakka.basic.base.mapper.SuperMapper;
import com.yakka.flex.msg.entity.ExtendInterfaceLog;

import java.time.LocalDateTime;

/**
 * <p>
 * Mapper 接口
 * 接口执行日志
 * </p>
 *
 * @author Jared
 * @date 2022-07-09 23:58:59
 * @create [2022-07-09 23:58:59] [zuihou] [代码生成器生成]
 */
@Repository
public interface ExtendInterfaceLogMapper extends SuperMapper<ExtendInterfaceLog> {
    /**
     * 递增成功次数
     *
     * @param id  日志ID
     * @param now 当前时间
     * @return
     */
    int incrSuccessCount(@Param("id") Long id, @Param("now") LocalDateTime now);

    /**
     * 递增失败次数
     *
     * @param id  日志ID
     * @param now 当前时间
     * @return
     */
    int incrFailCount(@Param("id") Long id, @Param("now") LocalDateTime now);
}


