package com.yakka.flex.im.common.event.listener;

import com.yakka.flex.im.common.enums.IdempotentEnum;
import com.yakka.flex.im.common.event.UserRegisterEvent;
import com.yakka.flex.im.core.user.dao.UserDao;
import com.yakka.flex.im.domain.entity.User;
import com.yakka.flex.im.domain.enums.ItemEnum;
import com.yakka.flex.im.core.user.service.UserBackpackService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import static com.yakka.flex.im.common.config.ThreadPoolConfig.YAKKA_EXECUTOR;

/**
 * 用户注册监听器
 * @author Jared
 */
@Slf4j
@Component
public class UserRegisterListener {
    @Resource
    private UserDao userDao;
    @Resource
    @Lazy
    private UserBackpackService userBackpackService;

    @Async(YAKKA_EXECUTOR)
    @EventListener(classes = UserRegisterEvent.class)
    public void sendCard(UserRegisterEvent event) {
        User user = event.getUser();
        //送一张改名卡
        userBackpackService.acquireItem(user.getId(), ItemEnum.MODIFY_NAME_CARD.getId(), IdempotentEnum.UID, user.getId().toString());
    }

    @Async(YAKKA_EXECUTOR)
    @EventListener(classes = UserRegisterEvent.class)
    public void sendBadge(UserRegisterEvent event) {
        User user = event.getUser();
        // 性能瓶颈，等注册用户多了直接删掉
        int count = (int) userDao.count();
        if (count <= 10) {
            userBackpackService.acquireItem(user.getId(), ItemEnum.REG_TOP10_BADGE.getId(), IdempotentEnum.UID, user.getId().toString());
        } else if (count <= 100) {
            userBackpackService.acquireItem(user.getId(), ItemEnum.REG_TOP100_BADGE.getId(), IdempotentEnum.UID, user.getId().toString());
        }
    }

}
