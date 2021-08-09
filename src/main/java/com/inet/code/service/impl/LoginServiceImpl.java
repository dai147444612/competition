package com.inet.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.inet.code.entity.dto.UserLogin;
import com.inet.code.entity.dto.changePassword;
import com.inet.code.entity.po.Login;
import com.inet.code.mapper.LoginMapper;
import com.inet.code.service.ILoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class LoginServiceImpl extends ServiceImpl<LoginMapper, Login> implements ILoginService {
    @Resource
    private LoginMapper loginMapper;
    @Override
    public Login checkLogin(String userId) {
        QueryWrapper q=new QueryWrapper();
        q.eq("U_id",userId);
        return loginMapper.selectOne(q);
    }

    @Override
    public Boolean HaveUsername(String username) {
        QueryWrapper q=new QueryWrapper();
        q.eq("username",username);
        return loginMapper.selectOne(q)!=null;
    }

    @Override
    public void register(Login login) {
        loginMapper.insert(login);
    }

    @Override
    public Login login(UserLogin login) {
        QueryWrapper q=new QueryWrapper();
        q.eq("username",login.getUsername());
        q.eq("password",login.getPassword());
        return loginMapper.selectOne(q);
    }

    @Override
    public boolean ispassword(changePassword changepassword) {
        QueryWrapper q=new QueryWrapper();
        q.eq("username",changepassword.getUsername());
        q.eq("password",changepassword.getPassword());
        return loginMapper==null;
    }

    @Override
    public void changePassword(changePassword changePassword) {
        QueryWrapper q=new QueryWrapper();
        q.eq("username",changePassword.getUsername());
        q.eq("password",changePassword.getPassword());
        loginMapper.update(new Login().setPassword(changePassword.getNewPassword()),q);
    }
}
