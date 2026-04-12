package com.yakka.flex.model.entity.ws;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Jared
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WSBlack implements Serializable {
    private Long uid;
}
