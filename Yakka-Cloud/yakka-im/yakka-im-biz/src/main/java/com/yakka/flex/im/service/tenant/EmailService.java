package com.yakka.flex.im.service.tenant;

import com.yakka.flex.model.vo.query.BindEmailReq;

public interface EmailService {

    // 发送验证码邮件
    Boolean sendVerificationCode(BindEmailReq req);
}