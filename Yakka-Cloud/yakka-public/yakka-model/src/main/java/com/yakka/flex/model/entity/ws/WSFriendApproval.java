package com.yakka.flex.model.entity.ws;

import io.swagger.v3.oas.annotations.media.Schema;
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
public class WSFriendApproval implements Serializable {
    @Schema(description ="申请人")
    private Long uid;
}
