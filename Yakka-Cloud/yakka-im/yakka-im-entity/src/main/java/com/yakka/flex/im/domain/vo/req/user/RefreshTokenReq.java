package com.yakka.flex.im.domain.vo.req.user;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Jared
 */
@Data
public class RefreshTokenReq implements Serializable {

    @NotEmpty(message = "refreshToken不能为空")
    private String refreshToken;
}
