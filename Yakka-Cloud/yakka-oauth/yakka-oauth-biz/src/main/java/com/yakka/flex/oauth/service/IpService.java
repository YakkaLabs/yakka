package com.yakka.flex.oauth.service;

import com.yakka.flex.model.entity.base.IpInfo;

/**
 * @author Jared
 */
public interface IpService {
    /**
     * 异步更新用户ip详情
	 * @param uid Im用户id
     * @param userId 系统用户id
	 * @param ipInfo IP信息
     */
    void refreshIpDetailAsync(Long uid, Long userId, IpInfo ipInfo);
}
