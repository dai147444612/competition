package com.inet.code.service;

import com.inet.code.entity.po.Permissions;
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
public interface IPermissionsService extends IService<Permissions> {

    Permissions getPermission(Integer Pid);
}
