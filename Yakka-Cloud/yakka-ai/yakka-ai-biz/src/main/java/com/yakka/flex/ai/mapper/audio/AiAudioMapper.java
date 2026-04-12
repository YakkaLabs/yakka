package com.yakka.flex.ai.mapper.audio;

import com.yakka.flex.ai.common.pojo.PageResult;
import com.yakka.flex.ai.controller.audio.vo.AiAudioPageReqVO;
import com.yakka.flex.ai.dal.audio.AiAudioDO;
import com.yakka.flex.ai.mapper.BaseMapperX;
import com.yakka.flex.ai.mapper.LambdaQueryWrapperX;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AiAudioMapper extends BaseMapperX<AiAudioDO> {

    default PageResult<AiAudioDO> selectPage(AiAudioPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AiAudioDO>()
                .eqIfPresent(AiAudioDO::getUserId, reqVO.getUserId())
                .eqIfPresent(AiAudioDO::getPlatform, reqVO.getPlatform())
                .likeIfPresent(AiAudioDO::getPrompt, reqVO.getPrompt())
                .eqIfPresent(AiAudioDO::getStatus, reqVO.getStatus())
                .eqIfPresent(AiAudioDO::getPublicStatus, reqVO.getPublicStatus())
                .betweenIfPresent(AiAudioDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(AiAudioDO::getId));
    }

    default List<AiAudioDO> selectListByIds(List<Long> ids) {
        return selectList(new LambdaQueryWrapperX<AiAudioDO>()
                .in(AiAudioDO::getId, ids));
    }
}
