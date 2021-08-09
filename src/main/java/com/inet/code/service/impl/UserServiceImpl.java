package com.inet.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.inet.code.entity.dto.UserLogin;
import com.inet.code.entity.po.Subscription;
import com.inet.code.entity.po.User;
import com.inet.code.mapper.UserMapper;
import com.inet.code.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author drh
 * @since 2021-08-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public void register(User user) {
        userMapper.insert(user);
    }

    @Override
    public User getLocal(String userId) {
        QueryWrapper q=new QueryWrapper();
        q.eq("Uid",userId);
        return userMapper.selectOne(q);
    }

    @Override
    public List<User> searchLocal(String location,String uid) {
        QueryWrapper q=new QueryWrapper();
        q.eq("location",location);
        q.ne("Uid",uid);
        return userMapper.selectList(q);
    }

    @Override
    public void setlocation(String u_id, String location) {
        QueryWrapper q=new QueryWrapper();
        q.eq("Uid",u_id);
        userMapper.update(new User().setLocation(location),q);
    }

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public List<User> getUserInfo(List<Subscription> sub) {
        List<User> users=new ArrayList<>();
        for (Subscription subscription:sub) {
            QueryWrapper q = new QueryWrapper();
            q.eq("Uid",subscription.getS_Uid());
            User user = userMapper.selectOne(q);
            users.add(user);
        }
        return users;
    }


}
