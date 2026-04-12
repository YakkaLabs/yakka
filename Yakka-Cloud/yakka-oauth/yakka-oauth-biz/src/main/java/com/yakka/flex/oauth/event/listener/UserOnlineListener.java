package com.yakka.flex.oauth.event.listener;

import com.yakka.flex.base.entity.tenant.DefUser;
import com.yakka.flex.base.service.tenant.DefUserService;
import com.yakka.flex.model.entity.base.IpInfo;
import com.yakka.flex.model.event.UserOnlineEvent;
import com.yakka.flex.oauth.service.IpService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 用户上线监听器
 *
 * @author Jared
 */
@Slf4j
@Component
@AllArgsConstructor
public class UserOnlineListener {

	private IpService ipService;
    private DefUserService defUserService;

    @Async
    @EventListener(classes = UserOnlineEvent.class)
    public void saveDb(UserOnlineEvent event) {
        Long userId = event.getUserId();
		LocalDateTime lastOptTime = event.getLastOptTime();
		IpInfo ipInfo = event.getIpInfo();

		DefUser defUser = new DefUser();
		defUser.setId(userId);
		defUser.setLastLoginTime(lastOptTime);
		defUser.setIpInfo(ipInfo);
		defUserService.updateById(defUser);

        // 更新用户ip详情
        ipService.refreshIpDetailAsync(event.getUid(), userId, ipInfo);
    }

}
