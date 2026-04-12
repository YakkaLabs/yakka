package com.yakka.flex.im.facae.impl;

import com.yakka.flex.im.facade.DefUserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.yakka.basic.base.R;
import com.yakka.flex.base.service.tenant.DefUserService;
import com.yakka.flex.model.constant.EchoApi;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Jared
 * @since 2024/9/20 23:33
 */
@Service(EchoApi.DEF_USER_ID_CLASS)
@RequiredArgsConstructor
public class DefUserFacadeImpl implements DefUserFacade {
    private final DefUserService defUserService;

    @Override
    public R<List<Long>> findAllUserId() {
        return R.success(defUserService.findUserIdList(null));
    }

    @Override
    public Map<Serializable, Object> findByIds(Set<Serializable> ids) {
        return defUserService.findByIds(ids);
    }

}
