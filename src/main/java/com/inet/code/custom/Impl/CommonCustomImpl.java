package com.inet.code.custom.Impl;

import com.inet.code.custom.CommonCustom;
import com.inet.code.entity.po.Title;
import com.inet.code.entity.po.User;
import com.inet.code.result.Result;
import com.inet.code.service.ITitleService;
import com.inet.code.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName CommonCustomImpl
 * @Description
 * @Author drh
 * @Data 12:41 下午
 * @Version 1.0
 **/
@Service
public class CommonCustomImpl implements CommonCustom {
    @Resource
    private ITitleService titleService;
    @Resource
    private IUserService userService;
    @Override
    public Result getTitle(String path) {
        List<Title> title = titleService.getTitle();
        return new Result().result200(title,path);
    }

    @Override
    public Result getUserList(String path) {
        List<User> user=userService.getUserList();
        return new Result().result200(user,path);
    }
}
