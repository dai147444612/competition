package com.inet.code.service;

import com.inet.code.entity.dto.UserLogin;
import com.inet.code.entity.dto.changePassword;
import com.inet.code.entity.po.Login;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author drh
 * @since 2021-08-02
 */
public interface ILoginService extends IService<Login> {

    Login checkLogin(String userId);

    Boolean HaveUsername(String username);

    void register(Login login);

    Login login(UserLogin login);

    boolean ispassword(changePassword changepassword);

    void changePassword(changePassword changePassword);
}
