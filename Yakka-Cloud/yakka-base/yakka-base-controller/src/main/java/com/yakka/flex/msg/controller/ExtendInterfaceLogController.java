package com.yakka.flex.msg.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yakka.basic.base.controller.SuperController;
import com.yakka.basic.interfaces.echo.EchoService;
import com.yakka.flex.msg.entity.ExtendInterfaceLog;
import com.yakka.flex.msg.service.ExtendInterfaceLogService;
import com.yakka.flex.msg.vo.query.ExtendInterfaceLogPageQuery;
import com.yakka.flex.msg.vo.result.ExtendInterfaceLogResultVO;
import com.yakka.flex.msg.vo.save.ExtendInterfaceLogSaveVO;
import com.yakka.flex.msg.vo.update.ExtendInterfaceLogUpdateVO;

/**
 * <p>
 * 前端控制器
 * 接口执行日志
 * </p>
 *
 * @author Jared
 * @date 2022-07-09 23:58:59
 * @create [2022-07-09 23:58:59] [zuihou] [代码生成器生成]
 */
@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/extendInterfaceLog")
@Tag(name = "接口执行日志")
public class ExtendInterfaceLogController extends SuperController<ExtendInterfaceLogService, Long, ExtendInterfaceLog, ExtendInterfaceLogSaveVO,
        ExtendInterfaceLogUpdateVO, ExtendInterfaceLogPageQuery, ExtendInterfaceLogResultVO> {
    private final EchoService echoService;

    @Override
    public EchoService getEchoService() {
        return echoService;
    }

}


