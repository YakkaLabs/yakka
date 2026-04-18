package com.yakka.flex.im.domain.vo.req.room;

import com.yakka.flex.im.domain.vo.req.PageBaseReq;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 群成员分页请求
 * @author 乾乾
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GroupMemberPageReq extends PageBaseReq {

    @NotNull(message = "房间ID不能为空")
    @Schema(description = "房间ID")
    private Long roomId;
}
