package com.yakka.flex.im.controller;

import com.yakka.basic.base.R;
import com.yakka.basic.context.ContextUtil;
import com.yakka.flex.im.core.user.service.ApplyService;
import com.yakka.flex.im.domain.entity.UserApply;
import com.yakka.flex.im.domain.vo.req.friend.FriendApplyReq;
import com.yakka.flex.im.domain.vo.request.RoomApplyReq;
import com.yakka.flex.im.domain.vo.request.member.ApplyReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 申请接口
 * @author Jared
 */
@RestController
@RequestMapping("/room/apply")
@Tag(name = "申请相关接口")
@Slf4j
public class ApplyController {
    @Resource
    private ApplyService applyService;

    @PostMapping("/apply")
    @Operation(summary = "好友申请")
    public R<UserApply> apply(@Valid @RequestBody FriendApplyReq request) {
        return R.success(applyService.handlerApply(ContextUtil.getUid(), request));
    }

	@Operation(summary ="审批别人邀请的进群、好友申请")
	@PostMapping("/handler/apply")
	public R<Void> handlerApply(@Valid @RequestBody ApplyReq request) {
		applyService.handlerApply(ContextUtil.getUid(), request);
		return R.success();
	}

	@PostMapping("/group")
	@Operation(summary = "申请加群")
	public R<Boolean> applyGroup(@Valid @RequestBody RoomApplyReq request){
		return R.success(applyService.applyGroup(ContextUtil.getUid(), request));
	}

    @DeleteMapping("/delete")
    @Operation(summary = "删除好友申请")
    public R<Boolean> deleteApprove(@Valid @RequestBody ApplyReq request) {
		applyService.deleteApprove(ContextUtil.getUid(), request);
        return R.success();
    }
}

