package com.yakka.flex.im.domain.vo.req.user;

import com.yakka.flex.im.domain.vo.req.PageBaseReq;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 黑名单分页查询请求
 * @author Jared
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "黑名单分页查询请求")
public class BlackPageReq extends PageBaseReq implements Serializable {

    @Schema(description = "拉黑目标（支持模糊查询）")
    private String target;
}
