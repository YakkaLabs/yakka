package com.yakka.flex.oauth.service;

import com.yakka.flex.base.entity.user.BaseOrg;
import com.yakka.flex.model.entity.system.SysUser;
import com.yakka.flex.oauth.vo.param.RegisterByEmailVO;
import com.yakka.flex.oauth.vo.param.RegisterByMobileVO;
import com.yakka.flex.oauth.vo.result.OrgResultVO;

import java.util.List;

/**
 * @author Jared
 * @version v1.0
 * @date 2022/9/16 12:21 PM
 * @create [2022/9/16 12:21 PM ] [tangyh] [初始创建]
 */
public interface UserInfoService {
    /**
     * 根据单位ID查找部门
     *
     * @param companyId 单位ID
     * @param employeeId  员工id
     * @return java.util.List<com.yakka.flex.model.entity.base.SysOrg>
     * @author Jared
     * @date 2022/9/29 11:18 PM
     * @create [2022/9/29 11:18 PM ] [tangyh] [初始创建]
     */
    List<BaseOrg> findDeptByCompany(Long companyId, Long employeeId);

    /**
     * 查询单位和部门信息
     *
     * @return com.yakka.flex.oauth.vo.result.OrgResultVO
     * @author Jared
     * @date 2022/9/15 2:37 PM
     * @create [2022/9/15 2:37 PM ] [tangyh] [初始创建]
     */
    OrgResultVO findCompanyAndDept();


    /**
     * 注册
     *
     * @param register 注册
     * @return
     */
    String registerByMobile(RegisterByMobileVO register);

    /**
     * 注册
	 * @param sysUser 	登录用户的信息，im系统注册时返回是null
     * @param register  注册
     * @return
     */
    String registerByEmail(SysUser sysUser, RegisterByEmailVO register);

	/**
	 * 校验邮箱是否存在
	 * @param email 	邮箱信息
	 */
	Boolean checkEmail(String email);
}
