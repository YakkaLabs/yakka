package com.yakka.flex.loginuser.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.yakka.basic.base.R;
import com.yakka.basic.constant.Constants;
import com.yakka.flex.model.entity.system.SysUser;

/**
 * @author Jared
 * @version v1.0
 * @date 2022/9/29 11:05 PM
 * @create [2022/9/29 11:05 PM ] [tangyh] [初始创建]
 */
@FeignClient(name = "${" + Constants.PROJECT_PREFIX + ".feign.system-server:yakka-system-server}")
public interface SystemApi {
    /**
     * 查询用户信息
     *
     * @param id 用户ID
     * @return com.yakka.basic.base.R<com.yakka.flex.model.entity.system.SysUser>
     * @author Jared
     * @date 2022/11/18 2:22 PM
     * @create [2022/11/18 2:22 PM ] [tangyh] [初始创建]
     */
    @GetMapping("/defUser/{id}")
    R<SysUser> getUserById(@PathVariable Long id);
}
