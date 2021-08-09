package com.inet.code.service;

import com.inet.code.entity.dto.UserLogin;
import com.inet.code.entity.po.Subscription;
import com.inet.code.entity.po.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author drh
 * @since 2021-08-02
 */
public interface IUserService extends IService<User> {

    void register(User user);

    User getLocal(String userId);

    List<User> searchLocal(String location,String uid);

    void setlocation(String u_id, String location);

    List<User> getUserList();

    List<User> getUserInfo(List<Subscription> sub);
}
