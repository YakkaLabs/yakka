package com.yakka.flex.oauth.biz;

import cn.hutool.core.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.yakka.basic.context.ContextUtil;
import com.yakka.flex.base.entity.tenant.DefUser;
import com.yakka.flex.base.entity.user.BaseEmployee;
import com.yakka.flex.base.service.tenant.DefUserService;
import com.yakka.flex.base.service.user.BaseEmployeeService;
import com.yakka.flex.base.vo.result.user.BaseEmployeeResultVO;
import com.yakka.flex.oauth.vo.result.DefUserInfoResultVO;
import com.yakka.flex.base.entity.application.DefApplication;
import com.yakka.flex.base.service.application.DefApplicationService;
import com.yakka.flex.base.vo.result.application.DefApplicationResultVO;

/**
 * 用户大业务
 *
 * @author Jared
 * @date 2021/10/28 13:09
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class OauthUserBiz {
    private final BaseEmployeeService baseEmployeeService;
    private final DefUserService defUserService;
    private final DefApplicationService defApplicationService;

    public DefUserInfoResultVO getUserById(Long id) {
        // 查默认库
        DefUser defUser = defUserService.getByIdCache(id);
        if (defUser == null) {
            return null;
        }

        // 用户信息
        DefUserInfoResultVO resultVO = new DefUserInfoResultVO();
        BeanUtil.copyProperties(defUser, resultVO);

        resultVO.setAvatar(defUser.getAvatar());
        Long uid = ContextUtil.getUid();
        resultVO.setUid(uid);

        //查 租户库
        BaseEmployee employee = baseEmployeeService.getById(uid);
        resultVO.setBaseEmployee(BeanUtil.toBean(employee, BaseEmployeeResultVO.class));

        DefApplication defApplication = defApplicationService.getDefApp(id);
        resultVO.setDefApplication(BeanUtil.toBean(defApplication, DefApplicationResultVO.class));
        return resultVO;
    }
}
