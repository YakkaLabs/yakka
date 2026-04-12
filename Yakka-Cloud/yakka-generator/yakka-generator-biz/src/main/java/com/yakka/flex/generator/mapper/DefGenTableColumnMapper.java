package com.yakka.flex.generator.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import com.yakka.basic.base.mapper.SuperMapper;
import com.yakka.flex.generator.entity.DefGenTableColumn;

/**
 * <p>
 * Mapper 接口
 * 代码生成字段
 * </p>
 *
 * @author Jared
 * @date 2022-03-01
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface DefGenTableColumnMapper extends SuperMapper<DefGenTableColumn> {

}
