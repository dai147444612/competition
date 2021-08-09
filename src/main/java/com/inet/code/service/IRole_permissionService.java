package com.inet.code.service;

import com.inet.code.entity.po.Role_permission;
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
public interface IRole_permissionService extends IService<Role_permission> {

    List<Integer> getPermissionId(Integer rid);
}
