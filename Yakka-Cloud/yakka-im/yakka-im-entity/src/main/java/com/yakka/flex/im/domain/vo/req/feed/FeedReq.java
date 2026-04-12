package com.yakka.flex.im.domain.vo.req.feed;

import com.yakka.flex.model.vo.query.OperParam;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 查询朋友圈的参数
 */
@Data
public class FeedReq extends OperParam {

	@NotNull(message = "请选择朋友圈")
	private Long feedId;
}
