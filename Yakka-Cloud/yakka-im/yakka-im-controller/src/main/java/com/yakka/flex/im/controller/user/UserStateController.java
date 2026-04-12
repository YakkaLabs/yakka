package com.yakka.flex.im.controller.user;

import com.yakka.basic.base.R;
import com.yakka.basic.context.ContextUtil;
import com.yakka.flex.im.domain.entity.UserState;
import com.yakka.flex.im.core.user.service.UserStateService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户在线状态管理
 */
@RestController
@RequestMapping("/user/state/")
public class UserStateController {

	@Resource
	private UserStateService userStateService;

	@PostMapping("changeState")
	@Operation(summary = "用户状态改变")
	public R<Boolean> changeState(@RequestParam("id") Long id){
		return R.success(userStateService.changeState(ContextUtil.getUid(), id));
	}

	@GetMapping("list")
	@Operation(summary = "获取所有用户状态")
	public R<List<UserState>> list(){
		return R.success(userStateService.list());
	}
}
