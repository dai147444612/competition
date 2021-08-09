package com.inet.code.service;

import com.inet.code.entity.po.Roles;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author drh
 * @since 2021-08-02
 */
public interface IRolesService extends IService<Roles> {

    String getRole(Integer rid);
}
