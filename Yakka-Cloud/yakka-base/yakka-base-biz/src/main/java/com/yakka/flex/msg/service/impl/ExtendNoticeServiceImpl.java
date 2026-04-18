package com.yakka.flex.msg.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yakka.basic.base.request.PageParams;
import com.yakka.basic.base.service.impl.SuperServiceImpl;
import com.yakka.basic.database.mybatis.conditions.Wraps;
import com.yakka.basic.utils.ArgumentAssert;
import com.yakka.flex.msg.entity.ExtendNotice;
import com.yakka.flex.msg.manager.ExtendNoticeManager;
import com.yakka.flex.msg.service.ExtendNoticeService;
import com.yakka.flex.msg.vo.query.ExtendNoticePageQuery;
import com.yakka.flex.msg.vo.result.ExtendNoticeResultVO;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 业务实现类
 * 通知表
 * </p>
 *
 * @author 乾乾
 * @date 2022-07-04 15:51:37
 * @create [2022-07-04 15:51:37] [zuihou] [代码生成器生成]
 */

@Slf4j
@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ExtendNoticeServiceImpl extends SuperServiceImpl<ExtendNoticeManager, Long, ExtendNotice> implements ExtendNoticeService {
    @Override
    public IPage<ExtendNoticeResultVO> page(IPage<ExtendNoticeResultVO> page, PageParams<ExtendNoticePageQuery> params) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean mark(List<Long> noticeIds, Long employeeId) {
        if (CollectionUtil.isEmpty(noticeIds) || employeeId == null) {
            return true;
        }

        return superManager.update(
                Wraps.<ExtendNotice>lbU().eq(ExtendNotice::getRecipientId, employeeId)
                        .in(ExtendNotice::getId, noticeIds)
                        .set(ExtendNotice::getIsRead, true)
                        .set(ExtendNotice::getReadTime, LocalDateTime.now())
        );
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteMyNotice(List<Long> noticeIds) {
        ArgumentAssert.notEmpty(noticeIds, "请选择需要删除的消息");
        return superManager.removeByIds(noticeIds);
    }
}


