package com.yakka.flex.im.facade;

import com.yakka.basic.base.R;
import com.yakka.basic.interfaces.echo.LoadService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 用户
 *
 * @author 乾乾
 * @date 2019/07/02
 */
public interface DefUserFacade extends LoadService {
    /**
     * 查询所有的用户id
     *
     * @return 用户id
     */

    R<List<Long>> findAllUserId();

    /**
     * 根据id查询实体
     *
     * @param ids 唯一键（可能不是主键ID)
     * @return
     */
    @Override
    Map<Serializable, Object> findByIds(Set<Serializable> ids);


}
