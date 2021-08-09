package com.inet.code.controller;

import com.inet.code.custom.userCustom;
import com.inet.code.entity.dto.*;
import com.inet.code.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.ResultSet;

/**
 * @ClassName userController
 * @Description
 * @Author drh
 * @Data 10:12 上午
 * @Version 1.0
 **/
@RestController
@Api(value = "用户功能接口")
public class userController {
    @Resource
    private userCustom userCustom;

    @ApiOperation(value = "注册接口")
    @PostMapping(value = "/register")
    public Result register(@RequestBody register register){
        return userCustom.register(register,"/register");
    }
    @ApiOperation(value = "登陆接口")
    @PostMapping(value = "login")
    public Result login(@RequestBody UserLogin login){
        return userCustom.login(login,"/login");
    }

    @ApiOperation(value = "修改密码接口")
    @PostMapping(value = "changePassword")
    @RequiresRoles(logical = Logical.OR,value = {"user","manager","superManager"})
    public Result changePassword(@RequestBody changePassword changePassword,
                                 @RequestHeader(defaultValue = "",value = "Token")String token){
        return userCustom.changePassword(changePassword,token,"changePasswrod");
    }
    @ApiOperation(value = "根据关键字搜索接口")
    @GetMapping(value = "searchByKeyWord")
    @RequiresRoles(logical = Logical.OR,value = {"user","manager","superManager"})
    public Result searchByKeyWord(@RequestParam String name,
                                  @RequestHeader(defaultValue = "",value = "Token")String token){
        return userCustom.searchByKeyWord(name,token,"/searchByWord");
    }

    @ApiOperation(value = "获取历史上的今天")
    @GetMapping(value = "hostoryToday")
    @RequiresRoles(logical = Logical.OR,value = {"user","manager","superManager"})
    public Result hostoryToday(@RequestHeader(defaultValue = "",value = "Token")String token){
        return userCustom.hostoryToday(token,"/hostoryToday");
    }

    @ApiOperation(value = "随机产生一条咨询")
    @GetMapping(value = "getRan")
    @RequiresRoles(logical = Logical.OR,value = {"user","manager","superManager"})
    public Result getRan(@RequestHeader(value = "Token",defaultValue = "")String token){
        return userCustom.getRan(token,"getRan");
    }

    @ApiOperation(value = "随机产生视频")
    @GetMapping(value = "getVideo")
    @RequiresRoles(logical = Logical.OR,value = {"user","manager","superManager"})
    public Result getVideo(@RequestHeader(value = "Token",defaultValue = "")String token){
        return userCustom.getVideo(token,"getVideo");
    }

    @ApiOperation(value = "发布一条咨询")
    @PostMapping(value = "release")
    @RequiresRoles(logical = Logical.OR,value = {"user","manager","superManager"})
    public Result release(@RequestHeader(value = "Token",defaultValue = "")String token,
                          @RequestBody userContent userContent){
        return userCustom.release(userContent,token,"release");
    }

    @ApiOperation(value = "查看附近的人发布的咨询")
    @GetMapping(value = "searchLocal")
    @RequiresRoles(logical = Logical.OR,value = {"user","manager","superManager"})
    public Result searchLocal(@RequestHeader(value = "Token",defaultValue = "")String token){
        return userCustom.searchLocal(token,"searchLocal");
    }

    @ApiOperation(value = "订阅接口")
    @PostMapping(value = "subscripted")
    public Result Subscripted(@RequestBody subscripted subscripted,
                              @RequestHeader(defaultValue = "",value = "Token")String token ){
        return userCustom.subscripted(subscripted,token,"subscripted");
    }

    @ApiOperation(value = "展示订阅的人")
    @GetMapping(value = "getSub")
    public Result getSub(@RequestHeader(defaultValue = "",value = "Token")String token){
        return userCustom.getSub(token,"getSub");
    }
}
