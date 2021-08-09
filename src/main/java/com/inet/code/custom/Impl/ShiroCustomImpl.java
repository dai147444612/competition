package com.inet.code.custom.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.inet.code.custom.ShiroCustom;
import com.inet.code.entity.po.Permissions;
import com.inet.code.entity.po.User_role;
import com.inet.code.service.IPermissionsService;
import com.inet.code.service.IRole_permissionService;
import com.inet.code.service.IRolesService;
import com.inet.code.service.IUser_roleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.management.relation.Role;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName ShiroCustomImpl
 * @Description
 * @Author drh
 * @Data 10:29 上午
 * @Version 1.0
 **/
@Service
public class ShiroCustomImpl implements ShiroCustom {
    @Resource
    private IUser_roleService user_roleService;
    @Resource
    private IRole_permissionService role_permissionService;
    @Resource
    private IRolesService rolesService;
    @Resource
    private IPermissionsService permissionsService;


    @Override
    public Integer getRoleid(String Uid) {
        return  user_roleService.getRoleId(Uid);
    }

    @Override
    public String getRole(Integer Rid) {
        return rolesService.getRole(Rid);
    }

    @Override
    public List<Integer> getpermissionId(Integer Rid) {
        return role_permissionService.getPermissionId(Rid);
    }

    @Override
    public Permissions getPermission(Integer Pid) {
        return permissionsService.getPermission(Pid);
    }
}
