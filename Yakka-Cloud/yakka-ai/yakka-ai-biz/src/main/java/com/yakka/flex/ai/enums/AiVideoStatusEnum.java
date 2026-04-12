package com.yakka.flex.ai.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AiVideoStatusEnum {

    IN_PROGRESS(10, "执行中"),
    SUCCESS(20, "生成成功"),
    FAIL(30, "生成失败");

    /**
     * 閻樿埖鈧?     */
    private final Integer status;
    /**
     * 閻樿埖鈧礁鎮?     */
    private final String name;

    public static AiVideoStatusEnum valueOfStatus(Integer status) {
        for (AiVideoStatusEnum statusEnum : AiVideoStatusEnum.values()) {
            if (statusEnum.getStatus().equals(status)) {
                return statusEnum;
            }
        }
        throw new IllegalArgumentException("閺堫亞鐓＄憴鍡涱暥閻㈢喐鍨氶悩鑸碘偓渚婄窗 " + status);
    }

}
