package com.yakka.flex.im.sensitive.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 敏感词
 *
 * @author Jared
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("im_sensitive_word")
public class SensitiveWord {
    private String word;
}
