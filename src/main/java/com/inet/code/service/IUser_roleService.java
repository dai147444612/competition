package com.inet.code.service;

import com.inet.code.entity.po.User_role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author drh
 * @since 2021-08-02
 */
public interface IUser_roleService extends IService<User_role> {

    Integer getRoleId(String Uid);

    void register(User_role user_role);
}
