package com.yakka.flex.ai.mapper.mindmap;

import com.yakka.flex.ai.common.pojo.PageResult;
import com.yakka.flex.ai.controller.mindmap.vo.AiMindMapPageReqVO;
import com.yakka.flex.ai.dal.mindmap.AiMindMapDO;
import com.yakka.flex.ai.mapper.BaseMapperX;
import com.yakka.flex.ai.mapper.LambdaQueryWrapperX;
import org.springframework.stereotype.Repository;

/**
 * AI 思维导图 Mapper
 *
 * @author Jared
 */
@Repository
public interface AiMindMapMapper extends BaseMapperX<AiMindMapDO> {

    default PageResult<AiMindMapDO> selectPage(AiMindMapPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AiMindMapDO>()
                .eqIfPresent(AiMindMapDO::getUserId, reqVO.getUserId())
                .eqIfPresent(AiMindMapDO::getPrompt, reqVO.getPrompt())
                .betweenIfPresent(AiMindMapDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(AiMindMapDO::getId));
    }

}
