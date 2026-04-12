package com.yakka.flex.oauth.facde.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.yakka.basic.base.R;
import com.yakka.flex.oauth.facade.CaptchaFacade;
import com.yakka.flex.oauth.service.CaptchaService;

/**
 *
 * @author Jared
 * @since 2024/9/20 15:42
 */
@Service
@RequiredArgsConstructor
public class CaptchaFacadeImpl implements CaptchaFacade {

    private final CaptchaService captchaService;

    public Boolean check(String key, String code, String templateCode) {
        R<Boolean> result = captchaService.checkCaptcha(key, code, templateCode);
        return result.getData();
    }
}
