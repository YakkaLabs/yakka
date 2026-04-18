package com.yakka.flex.im.domain.vo.res;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 乾乾
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IdRespVO {
	@Schema(description = "id")
    private long id;
}
