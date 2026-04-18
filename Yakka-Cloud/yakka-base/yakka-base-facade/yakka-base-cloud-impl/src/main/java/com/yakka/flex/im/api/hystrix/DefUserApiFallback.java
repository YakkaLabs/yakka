package com.yakka.flex.im.api.hystrix;

import org.springframework.stereotype.Component;
import com.yakka.basic.base.R;
import com.yakka.flex.model.entity.system.SysUser;
import com.yakka.flex.model.vo.result.UserQuery;
import com.yakka.flex.im.api.DefUserApi;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 用户API熔断
 *
 * @author 乾乾
 * @date 2019/07/23
 */
@Component
public class DefUserApiFallback implements DefUserApi {
    @Override
    public R<List<Long>> findAllUserId() {
        return R.timeout();
    }

    @Override
    public Map<Serializable, Object> findByIds(Set<Serializable> ids) {
        return Map.of();
    }

    @Override
    public R<SysUser> getById(UserQuery userQuery) {
        return R.timeout();
    }

    @Override
    public R<Boolean> logout(Long userId, String token) {
        return R.timeout();
    }
}
