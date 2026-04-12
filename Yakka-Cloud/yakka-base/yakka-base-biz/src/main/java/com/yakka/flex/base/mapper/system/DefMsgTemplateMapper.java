package com.yakka.flex.base.mapper.system;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import com.yakka.basic.base.mapper.SuperMapper;
import com.yakka.flex.base.entity.system.DefMsgTemplate;

/**
 * <p>
 * Mapper 接口
 * 消息模板
 * </p>
 *
 * @author Jared
 * @date 2022-07-04 15:51:37
 * @create [2022-07-04 15:51:37] [zuihou] [代码生成器生成]
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface DefMsgTemplateMapper extends SuperMapper<DefMsgTemplate> {

}


