package com.yakka.flex.im.core.chat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yakka.flex.model.entity.ws.ChatMember;
import com.yakka.flex.model.entity.ws.ChatMemberResp;
import org.springframework.stereotype.Repository;
import com.yakka.flex.im.domain.entity.GroupMember;

import java.util.List;

/**
 * <p>
 * 群成员表 Mapper 接口
 * </p>
 *
 * @author Jared
 */
@Repository
public interface GroupMemberMapper extends BaseMapper<GroupMember> {

	List<ChatMemberResp> getMemberListByGroupId(Long groupId);

	List<ChatMember> getMemberListByUid(List<Long> memberList);
}
