package com.yakka.flex.im.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 申请阅读状态枚举
 * @author 乾乾
 */
@Getter
@AllArgsConstructor
public enum ApplyReadStatusEnum {

    UNREAD(1, "未读"),

    READ(2, "已读");

    private final Integer code;

    private final String desc;
}
