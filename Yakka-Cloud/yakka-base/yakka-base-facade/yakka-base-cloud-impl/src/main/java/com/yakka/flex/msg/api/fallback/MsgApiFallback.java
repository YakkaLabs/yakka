package com.yakka.flex.msg.api.fallback;

import org.springframework.stereotype.Component;
import com.yakka.basic.base.R;
import com.yakka.flex.msg.api.MsgApi;
import com.yakka.flex.msg.vo.update.ExtendMsgSendVO;

/**
 * 熔断
 *
 * @author 乾乾
 * @date 2019/07/25
 */
@Component
public class MsgApiFallback implements MsgApi {
    @Override
    public R<Boolean> sendByTemplate(ExtendMsgSendVO data) {
        return R.timeout();
    }
}
