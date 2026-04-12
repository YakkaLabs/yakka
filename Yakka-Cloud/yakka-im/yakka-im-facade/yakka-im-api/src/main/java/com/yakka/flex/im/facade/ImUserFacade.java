package com.yakka.flex.im.facade;

import com.yakka.basic.interfaces.echo.LoadService;
import com.yakka.flex.im.domain.vo.resp.user.UserInfoResp;

/**
 * 用户
 *
 * @author Jared
 * @date 2019/07/02
 */
public interface ImUserFacade extends LoadService {

    /**
     * 根据id查询实体
     *
     * @param id 唯一键
     * @return
     */
	UserInfoResp getUserInfo(Long id);
}
