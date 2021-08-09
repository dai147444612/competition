package com.inet.code.controller;

import com.inet.code.custom.CommonCustom;
import com.inet.code.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName common
 * @Description
 * @Author drh
 * @Data 12:40 下午
 * @Version 1.0
 **/
@RestController
public class CommonController {
    @Resource
    private CommonCustom commonCustom;

    @ApiOperation(value = "根据标题进行分类（获取标题）")
    @GetMapping(value = "getTitle")
    public Result getTitle(){
        return commonCustom.getTitle("/getTitle");
    }

    @ApiOperation(value = "列出用户")
    @GetMapping(value = "getUserList")
    public Result getUserList(){
        return commonCustom.getUserList("/getUserList");
    }

}
