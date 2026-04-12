package com.yakka.flex.generator.rules.enumeration;

import lombok.Data;

import java.util.List;

/**
 * @author Jared
 * @date 2022/3/22 15:51
 */
@Data
public class EnumTypeKeyValue {
    private String key;
    private List<String> values;
}
