package com.yakka.flex.ai.mapper.knowledge;

import com.yakka.flex.ai.common.pojo.PageResult;
import com.yakka.flex.ai.controller.knowledge.vo.knowledge.AiKnowledgePageReqVO;
import com.yakka.flex.ai.dal.knowledge.AiKnowledgeDO;
import com.yakka.flex.ai.mapper.BaseMapperX;
import com.yakka.flex.ai.mapper.LambdaQueryWrapperX;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AI 知识库 Mapper
 *
 * @author Jared
 */
@Repository
public interface AiKnowledgeMapper extends BaseMapperX<AiKnowledgeDO> {

    default PageResult<AiKnowledgeDO> selectPage(AiKnowledgePageReqVO pageReqVO) {
        return selectPage(pageReqVO, new LambdaQueryWrapperX<AiKnowledgeDO>()
                .likeIfPresent(AiKnowledgeDO::getName, pageReqVO.getName())
                .eqIfPresent(AiKnowledgeDO::getStatus, pageReqVO.getStatus())
                .betweenIfPresent(AiKnowledgeDO::getCreateTime, pageReqVO.getCreateTime())
                .orderByDesc(AiKnowledgeDO::getId));
    }

    default List<AiKnowledgeDO> selectListByStatus(Integer status) {
        return selectList(AiKnowledgeDO::getStatus, status);
    }

}
