package com.yakka.flex.generator.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yakka.basic.base.request.PageParams;
import com.yakka.basic.base.service.SuperService;
import com.yakka.flex.generator.entity.DefGenTableColumn;
import com.yakka.flex.generator.vo.query.DefGenTableColumnPageQuery;
import com.yakka.flex.generator.vo.result.DefGenTableColumnResultVO;

/**
 * <p>
 * 业务接口
 * 代码生成字段
 * </p>
 *
 * @author Jared
 * @date 2022-03-01
 */
public interface DefGenTableColumnService extends SuperService<Long, DefGenTableColumn> {

    /**
     * 分页查询指定表的字段
     *
     * @param params params
     * @return com.baomidou.mybatisplus.core.metadata.IPage<com.yakka.flex.generator.vo.result.DefGenTableColumnResultVO>
     * @author Jared
     * @date 2022/10/28 4:54 PM
     * @create [2022/10/28 4:54 PM ] [tangyh] [初始创建]
     */
    IPage<DefGenTableColumnResultVO> pageColumn(PageParams<DefGenTableColumnPageQuery> params);

    /**
     * 同步字段结构和注释
     *
     * @param id      id
     * @param tableId
     * @return java.lang.Boolean
     * @author Jared
     * @date 2022/3/26 11:19 AM
     * @create [2022/3/26 11:19 AM ] [tangyh] [初始创建]
     */
    Boolean syncField(Long tableId, Long id);
}
