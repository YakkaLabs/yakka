package com.yakka.flex.im.controller.user;

import com.yakka.flex.im.domain.vo.req.IdReqVO;
import com.yakka.flex.im.domain.vo.res.IdRespVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.yakka.basic.base.R;
import com.yakka.basic.context.ContextUtil;
import com.yakka.flex.im.domain.vo.req.user.UserEmojiReq;
import com.yakka.flex.im.domain.vo.resp.user.UserEmojiResp;
import com.yakka.flex.im.core.user.service.UserEmojiService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户表情包
 * @author Jared
 */
@RestController
@RequestMapping("/user/emoji")
@Tag(name = "用户表情包管理相关接口")
public class UserEmojiController {

    /**
     * 用户表情包 Service
     */
    @Resource
    private UserEmojiService emojiService;


    /**
     * 表情包列表
     *
     * @return 表情包列表
     * @author Jared
     **/
    @GetMapping("/list")
    @Operation(summary = "表情包列表")
    public R<List<UserEmojiResp>> getEmojisPage() {
        return R.success(emojiService.list(ContextUtil.getUid()));
    }


    /**
     * 新增表情包
     *
     * @param req 用户表情包
     * @return 表情包
     * @author Jared
     **/
    @PostMapping()
    @Operation(summary = "新增表情包")
    public R<IdRespVO> insertEmojis(@Valid @RequestBody UserEmojiReq req) {
        return emojiService.insert(req, ContextUtil.getUid());
    }

    /**
     * 删除表情包
     *
     * @return 删除结果
     * @author Jared
     **/
    @DeleteMapping()
    @Operation(summary = "删除表情包")
    public R<Void> deleteEmojis(@Valid @RequestBody IdReqVO reqVO) {
        emojiService.remove(reqVO.getId(), ContextUtil.getUid());
        return R.success();
    }
}
