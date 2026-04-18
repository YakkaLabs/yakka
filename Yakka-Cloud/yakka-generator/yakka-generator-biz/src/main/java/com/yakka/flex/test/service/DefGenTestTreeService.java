package com.yakka.flex.test.service;

import com.yakka.basic.base.service.SuperService;
import com.yakka.flex.test.entity.DefGenTestTree;
import com.yakka.flex.test.vo.query.DefGenTestTreePageQuery;

import java.util.List;


/**
 * <p>
 * 业务接口
 * 测试树结构
 * </p>
 *
 * @author 乾乾
 * @date 2022-04-20 00:28:30
 * @create [2022-04-20 00:28:30] [zuihou] [代码生成器生成]
 */
public interface DefGenTestTreeService extends SuperService<Long, DefGenTestTree> {

    /**
     * 查询树结构
     *
     * @param query 参数
     * @return 树
     */
    List<DefGenTestTree> findTree(DefGenTestTreePageQuery query);
}


