package com.yakka.flex.ai.mapper.write;

import com.yakka.flex.ai.common.pojo.PageResult;
import com.yakka.flex.ai.controller.write.vo.AiWritePageReqVO;
import com.yakka.flex.ai.dal.write.AiWriteDO;
import com.yakka.flex.ai.mapper.BaseMapperX;
import com.yakka.flex.ai.mapper.LambdaQueryWrapperX;
import org.springframework.stereotype.Repository;

/**
 * AI 写作 Mapper
 *
 * @author Jared
 */
@Repository
public interface AiWriteMapper extends BaseMapperX<AiWriteDO> {

    default PageResult<AiWriteDO> selectPage(AiWritePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AiWriteDO>()
                .eqIfPresent(AiWriteDO::getUserId, reqVO.getUserId())
                .eqIfPresent(AiWriteDO::getType, reqVO.getType())
                .eqIfPresent(AiWriteDO::getPlatform, reqVO.getPlatform())
                .betweenIfPresent(AiWriteDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(AiWriteDO::getId));
    }

}
