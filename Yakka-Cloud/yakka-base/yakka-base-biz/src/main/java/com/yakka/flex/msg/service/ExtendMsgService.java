package com.yakka.flex.msg.service;

import com.yakka.basic.base.service.SuperService;
import com.yakka.flex.base.entity.system.DefMsgTemplate;
import com.yakka.flex.model.entity.system.SysUser;
import com.yakka.flex.msg.entity.ExtendMsg;
import com.yakka.flex.msg.vo.result.ExtendMsgResultVO;
import com.yakka.flex.msg.vo.update.ExtendMsgPublishVO;
import com.yakka.flex.msg.vo.update.ExtendMsgSendVO;


/**
 * <p>
 * 业务接口
 * 消息
 * </p>
 *
 * @author Jared
 * @date 2022-07-10 11:41:17
 * @create [2022-07-10 11:41:17] [zuihou] [代码生成器生成]
 */
public interface ExtendMsgService extends SuperService<Long, ExtendMsg> {

    /**
     * 发送消息
     *
     * @param data        消息
     * @param msgTemplate 消息模版
     * @param sysUser     当前用户
     * @return 是否执行
     * @author Jared
     * @date 2022/10/28 4:57 PM
     * @create [2022/10/28 4:57 PM ] [tangyh] [初始创建]
     */

    Boolean send(ExtendMsgSendVO data, DefMsgTemplate msgTemplate, SysUser sysUser);

    /**
     * 定时发布通知
     *
     * @param msgId 消息id
     */
    void publishNotice(Long msgId);

    /**
     * 发布消息
     *
     * @param data
     * @param sysUser
     * @return
     * @author Jared
     * @date 2022/10/28 4:57 PM
     * @create [2022/10/28 4:57 PM ] [tangyh] [初始创建]
     */
    Boolean publish(ExtendMsgPublishVO data, SysUser sysUser);

    /**
     * 查询消息详情
     *
     * @param id
     * @return
     */
    ExtendMsgResultVO getResultById(Long id);
}


