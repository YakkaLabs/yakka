package com.yakka.flex.im.core.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import com.yakka.flex.im.domain.entity.Feed;
import com.yakka.flex.im.domain.vo.req.feed.FeedVo;

@Repository
public interface FeedMapper extends BaseMapper<Feed> {

	FeedVo getDetail(Long id);
}
