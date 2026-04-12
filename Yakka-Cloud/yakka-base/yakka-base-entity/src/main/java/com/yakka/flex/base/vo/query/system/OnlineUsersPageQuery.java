package com.yakka.flex.base.vo.query.system;

import lombok.Data;

/**
 * 在线用户
 * @author Jared
 * @since 2024/8/1 15:40
 */
@Data
public class OnlineUsersPageQuery {

    /**
     * 用户名;
     */
    private String username;
    private String nickName;
    private String sessionId;

}
