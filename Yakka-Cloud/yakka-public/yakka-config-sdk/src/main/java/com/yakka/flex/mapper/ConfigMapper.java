package com.yakka.flex.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.yakka.basic.base.mapper.SuperMapper;
import com.yakka.flex.entity.Config;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * 系统配置
 * </p>
 *
 * @author 乾乾
 * @date 2024-04-18
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface ConfigMapper extends SuperMapper<Config> {

}
