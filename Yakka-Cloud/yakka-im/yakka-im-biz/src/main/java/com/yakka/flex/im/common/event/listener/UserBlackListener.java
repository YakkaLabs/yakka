package com.yakka.flex.im.common.event.listener;

import com.yakka.basic.context.ContextUtil;
import com.yakka.flex.im.core.user.service.cache.UserSummaryCache;
import com.yakka.flex.im.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import com.yakka.flex.im.common.event.UserBlackEvent;
import com.yakka.flex.im.core.chat.dao.MessageDao;
import com.yakka.flex.model.entity.WSRespTypeEnum;
import com.yakka.flex.model.entity.WsBaseResp;
import com.yakka.flex.model.entity.ws.WSBlack;
import com.yakka.flex.im.core.user.service.impl.PushService;
import com.yakka.flex.im.api.DefUserApi;

import static com.yakka.flex.im.common.config.ThreadPoolConfig.YAKKA_EXECUTOR;

/**
 * 用户拉黑监听器
 *
 * @author Jared
 */
@Slf4j
@Component
@AllArgsConstructor
public class UserBlackListener {

    private final MessageDao messageDao;
    private final UserSummaryCache userSummaryCache;
    private final PushService pushService;
    private final DefUserApi defUserApi;

    @Async(YAKKA_EXECUTOR)
    @EventListener(classes = UserBlackEvent.class)
    public void refreshRedis(UserBlackEvent event) {
		userSummaryCache.evictBlackMap();
    }

    @Async(YAKKA_EXECUTOR)
    @EventListener(classes = UserBlackEvent.class)
    public void deleteMsg(UserBlackEvent event) {
        messageDao.invalidByUid(event.getUser().getId());
    }

    @Async(YAKKA_EXECUTOR)
    @EventListener(classes = UserBlackEvent.class)
    public void sendPush(UserBlackEvent event) {
        User user = event.getUser();
        Long uid = user.getId();
        WsBaseResp<WSBlack> resp = new WsBaseResp<>();
        WSBlack black = new WSBlack(uid);
        resp.setData(black);
        resp.setType(WSRespTypeEnum.INVALID_USER.getType());
        pushService.sendPushMsg(resp, uid, ContextUtil.getUid());
        try {
            defUserApi.logout(uid, null);
        } catch (Exception e) {
            log.error("黑名单强制下线失败, uid={}", uid, e);
        }
    }
}
