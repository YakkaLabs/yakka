package com.yakka.flex.ai.mapper.platform;

import com.yakka.flex.ai.dal.platform.AiPlatformDO;
import com.yakka.flex.ai.mapper.BaseMapperX;
import com.yakka.flex.ai.mapper.LambdaQueryWrapperX;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AI 平台配置 Mapper
 */
@Repository
public interface AiPlatformMapper extends BaseMapperX<AiPlatformDO> {

    /**
     * 查询启用状态的平台列表，按排序字段升序
     */
    default List<AiPlatformDO> selectListByStatus() {
        return selectList(new LambdaQueryWrapperX<AiPlatformDO>()
                .eq(AiPlatformDO::getStatus, 0)
                .orderByAsc(AiPlatformDO::getSort));
    }
}
