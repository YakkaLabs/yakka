package com.yakka.flex.base.service.system;

import com.yakka.basic.base.service.SuperCacheService;
import com.yakka.flex.base.entity.system.DefClient;

/**
 * <p>
 * 业务接口
 * 客户端
 * </p>
 *
 * @author Jared
 * @date 2021-10-13
 */
public interface DefClientService extends SuperCacheService<Long, DefClient> {

    /**
     * 根据 客户端id 和 客户端秘钥查询应用
     *
     * @param clientId
     * @param clientSecret
     * @return
     */
    DefClient getClient(String clientId, String clientSecret);
}
