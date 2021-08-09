package com.inet.code.custom.Impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.IdUtil;
import com.inet.code.custom.userCustom;
import com.inet.code.entity.dto.*;
import com.inet.code.entity.po.*;
import com.inet.code.result.Result;
import com.inet.code.service.*;
import com.inet.code.util.JwtUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.xpath.XPath;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.random;

/**
 * @ClassName userCustomImpl
 * @Description
 * @Author drh
 * @Data 9:32 上午
 * @Version 1.0
 **/
@Service
public class userCustomImpl implements userCustom {
    @Resource
    private ILoginService loginService;
    @Resource
    private IUserService userService;
    @Resource
    private IUser_roleService user_roleService;
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private IContentService contentService;
    @Resource
    private IVideoService videoService;
    @Resource
    private IU_contentService iu_contentService;
    @Resource
    private ISubscriptionService subscriptionService;
    @Override
    public Result register(register register, String path) {
        if (loginService.HaveUsername(register.getUsername())){
            return new Result().result401("用户名已经存在",path);
        }

        String Uid = IdUtil.simpleUUID();
        User user = BeanUtil.copyProperties(register, User.class)
                .setUid(Uid)
                .setCreated(new Date())
                .setModified(new Date());
        Login login = BeanUtil.copyProperties(register, Login.class)
                .setU_id(Uid)
                .setCreated(new Date())
                .setModified(new Date());
        User_role user_role=new User_role()
                .setU_id(Uid)
                .setR_id(1);

        userService.register(user);
        loginService.register(login);
        user_roleService.register(user_role);
        return new Result().result200("注册成功",path);
    }

    @Override
    public Result login(UserLogin login, String path) {
        if (login.getUsername()==null|| login.getPassword()==null){
            return new Result().result401("请输入账号和密码",path);
        }
        Login login1 = loginService.login(login);
        if (login1==null){
            return new Result().result404("请输入正确的账号密码",path);
        }
        userService.setlocation(login1.getU_id(),login.getLocation());

        Map<String,String> map=new HashMap<>();
        map.put("userId",login1.getU_id());
        map.put("username",login1.getUsername());
        map.put("password",login1.getPassword());
        String token = JwtUtils.getToken(map);
        redisTemplate.opsForValue().set(token,login1,7, TimeUnit.DAYS);

        Map<Object, Object> result =new HashMap<>();
        result.put("message","登陆成功");
        result.put("Token",token);
        return new Result().result200(result,path);
    }

    @Override
    public Result changePassword(changePassword changePassword,String token,String path) {
        if (redisTemplate.opsForValue().get(token)==null){
            return new Result().result401("用户未登陆无法进行操作",path);
        }
        if (loginService.ispassword(changePassword)){
            return new Result().result401("账号或者密码不正确",path);
        }
        loginService.changePassword(changePassword);
        return new Result().result200("修改密码成功",path);
    }

    @Override
    public Result searchByKeyWord(String name, String token, String path) {
        if (redisTemplate.opsForValue().get(token)==null){
            return new Result().result401("用户未登陆无法进行操作",path);
        }
        List<Content> contents = contentService.searchByKeyWord(name);
        return new Result().result200(contents,path);
    }

    @Override
    public Result hostoryToday(String token, String path) {
        if (redisTemplate.opsForValue().get(token)==null){
            return new Result().result401("未登陆我发进行查看",path);
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        List<Content> contents = contentService.hostoryToday(dtf.format(localDate));
        return new Result().result200(contents,path);
    }

    @Override
    public Result getRan(String token, String path) {
        if (redisTemplate.opsForValue().get(token)==null){
            return new Result().result401("未登陆我发操作", path);
        }
        Integer contentCount = contentService.getContentCount();
        Content content = contentService.getContent((int) random() * contentCount + 1);
        return new Result().result200(content,path);
    }

    @Override
    public Result getVideo(String token, String path) {
        if (redisTemplate.opsForValue().get(token)==null){
            return new Result().result401("未登陆无法操作",path);
        }
        Integer videoCout = videoService.getVideoCout();
        Video video = videoService.getVideo((int) random() * videoCout + 1);
        return new Result().result200(video,path);
    }

    @Override
    public Result release(userContent userContent, String token, String path) {
        if (redisTemplate.opsForValue().get(token)==null){
            return new Result().result401("未登陆无法发布",path);
        }
        String userId = JwtUtils.getString(token, "userId");
        iu_contentService.release(new U_content().setU_id(userId)
                                                 .setTitle(userContent.getTitle())
                                                 .setContent(userContent.getContent())
                                                 .setCreated(new Date())
                                                 .setModified(new Date()));
        return new Result().result200("发布成功",path);
    }

    @Override
    public Result searchLocal(String token, String path) {
        if (redisTemplate.opsForValue().get(token)==null){
            return new Result().result401("未登陆无法进行查看",path);
        }
        String userId = JwtUtils.getString(token, "userId");
        User user = userService.getLocal(userId);
        List<User> users = userService.searchLocal(user.getLocation(), user.getUid());
        return new Result().result200(users,path);
    }

    @Override
    public Result subscripted(subscripted subscripted, String token, String path) {
        if (redisTemplate.opsForValue().get(token)==null){
            return new Result().result401("未登陆无法订阅",path);
        }
        String userId = JwtUtils.getString(token, "userId");
        subscriptionService.subscripted(subscripted.getS_Uid(),userId);
        return new Result().result200("订阅成功",path);
    }

    @Override
    public Result getSub(String token, String path) {
        if (redisTemplate.opsForValue().get(token)==null){
            return new Result().result401("未登陆无法查看",path);
        }
        String userId = JwtUtils.getString(token, "userId");
        List<Subscription> sub = subscriptionService.getSub(userId);
        List<User> userInfo = userService.getUserInfo(sub);
        return new Result().result200(userInfo,path);
    }

}
