package com.yakka.flex.oauth.granter;

import cn.dev33.satoken.config.SaTokenConfig;
import com.yakka.flex.base.service.system.DefClientService;
import com.yakka.flex.base.service.tenant.DefUserService;
import com.yakka.flex.base.service.user.BaseEmployeeService;
import com.yakka.flex.base.service.user.BaseOrgService;
import com.yakka.flex.common.properties.SystemProperties;
import com.yakka.flex.im.api.ImUserApi;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.yakka.basic.base.R;
import com.yakka.basic.exception.BizException;
import com.yakka.basic.utils.SpringUtils;
import com.yakka.basic.utils.StrHelper;
import com.yakka.flex.oauth.event.LoginEvent;
import com.yakka.flex.oauth.event.model.LoginStatusDTO;
import com.yakka.flex.oauth.service.CaptchaService;
import com.yakka.flex.oauth.vo.param.LoginParamVO;
import com.yakka.flex.oauth.vo.result.LoginResultVO;
import com.yakka.flex.oauth.enumeration.system.LoginStatusEnum;

import static com.yakka.flex.oauth.granter.CaptchaTokenGranter.GRANT_TYPE;

/**
 * 验证码TokenGranter
 *
 * @author Jared
 */
@Component(GRANT_TYPE)
@Slf4j
public class CaptchaTokenGranter extends PasswordTokenGranter implements TokenGranter {

    public static final String GRANT_TYPE = "CAPTCHA";
	@Resource
    private CaptchaService captchaService;

	public CaptchaTokenGranter(SystemProperties systemProperties, DefClientService defClientService, DefUserService defUserService, BaseEmployeeService baseEmployeeService, BaseOrgService baseOrgService, SaTokenConfig saTokenConfig, ImUserApi userApi, com.yakka.flex.oauth.biz.StpInterfaceBiz stpInterfaceBiz) {
		super(systemProperties, defClientService, defUserService, baseEmployeeService, baseOrgService, saTokenConfig, userApi, stpInterfaceBiz);
	}

	@Override
    protected R<LoginResultVO> checkCaptcha(LoginParamVO loginParam) {
        if (systemProperties.getVerifyCaptcha()) {
            R<Boolean> check = captchaService.checkCaptcha(loginParam.getKey(), GRANT_TYPE, loginParam.getCode());
            if (!check.getsuccess()) {
                String msg = check.getMsg();
                SpringUtils.publishEvent(new LoginEvent(LoginStatusDTO.fail(loginParam.getAccount(), LoginStatusEnum.CAPTCHA_ERROR, msg)));
                throw BizException.validFail(check.getMsg());
            }
        }
        return R.success(null);
    }

    @Override
    public R<LoginResultVO> checkParam(LoginParamVO loginParam) {
        String account = loginParam.getAccount();
        String password = loginParam.getPassword();
        if (StrHelper.isAnyBlank(account, password)) {
            return R.fail("请输入用户名或密码");
        }
        if (StrHelper.isAnyBlank(loginParam.getCode(), loginParam.getKey())) {
            return R.fail("请输入验证码");
        }

        return R.success(null);
    }

}
