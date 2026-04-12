package com.yakka.flex.im.common.algorithm.ac;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Jared
 */
@Getter
@Setter
@AllArgsConstructor
public class MatchResult {

    private int startIndex;

    private int endIndex;

    @Override
    public String toString() {
        return "MatchResult{" +
                "startIndex=" + startIndex +
                ", endIndex=" + endIndex +
                '}';
    }
}
