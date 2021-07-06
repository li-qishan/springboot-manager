package com.company.project.app.controller;

import com.company.project.common.app.api.CommonResult;
import com.company.project.app.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 会员登录注册管理Controller
 * Created by macro on 2018/8/3.
 */
@Controller
@Api(tags = "MemberController", description = "会员登录注册管理")
@RequestMapping("/sso")
public class AppLoginController {
    @Autowired
    private MemberService memberService;

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAuthCode(@PathVariable("mobile") String mobile) {
        return memberService.generateAuthCode(mobile);
    }

    @ApiOperation("判断验证码是否正确")
    @RequestMapping(value = "/verifyAuthCode", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult verifyAuthCode(@RequestParam String telephone,
                                 @RequestParam String authCode) {
        return memberService.verifyAuthCode(telephone,authCode);
    }
}
