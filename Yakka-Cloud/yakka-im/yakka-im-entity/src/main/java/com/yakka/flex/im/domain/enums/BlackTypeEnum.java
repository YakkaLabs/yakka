package com.yakka.flex.im.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 物品枚举
 * @author Jared
 */
@AllArgsConstructor
@Getter
public enum BlackTypeEnum {
    IP(1),
    UID(2),
    ;

    private final Integer type;

}
