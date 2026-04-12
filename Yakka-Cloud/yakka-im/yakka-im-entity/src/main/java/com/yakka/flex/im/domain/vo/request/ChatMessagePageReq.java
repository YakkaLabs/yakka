package com.yakka.flex.im.domain.vo.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.yakka.flex.im.domain.vo.req.CursorPageBaseReq;


/**
 * 消息列表请求
 * @author Jared
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessagePageReq extends CursorPageBaseReq {
    @NotNull
    @Schema(description ="会话id")
    private Long roomId;

	private Boolean skip = false;
}
