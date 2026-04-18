package com.yakka.flex.oauth.event.listener;

import com.yakka.flex.base.entity.tenant.DefUser;
import com.yakka.flex.base.service.tenant.DefUserService;
import com.yakka.flex.model.event.UserOfflineEvent;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 用户下线监听器 [后续如果要修改im_user表的信息要通过原创api]
 *
 * @author 乾乾
 */
@Slf4j
@Component
public class UserOfflineListener {

    @Resource
	private DefUserService defUserService;

    @Async
    @EventListener(classes = UserOfflineEvent.class)
    public void saveRedisAndPush(UserOfflineEvent event) {
		DefUser defUser = new DefUser();
		defUser.setId(event.getDefUserId());
		defUser.setLastLoginTime(event.getLastOptTime());
		defUserService.updateById(defUser);
	}

}
