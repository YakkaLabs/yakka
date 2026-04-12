package com.yakka.flex.base.mapper.system;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import com.yakka.basic.base.mapper.SuperMapper;
import com.yakka.flex.base.entity.system.DefArea;

/**
 * <p>
 * Mapper 接口
 * 地区表
 * </p>
 *
 * @author Jared
 * @date 2021-10-13
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface DefAreaMapper extends SuperMapper<DefArea> {

}
