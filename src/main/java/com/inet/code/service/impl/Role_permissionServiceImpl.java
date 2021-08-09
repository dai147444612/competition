package com.inet.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.inet.code.entity.po.Role_permission;
import com.inet.code.mapper.Role_permissionMapper;
import com.inet.code.service.IRole_permissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author drh
 * @since 2021-08-02
 */
@Service
public class Role_permissionServiceImpl extends ServiceImpl<Role_permissionMapper, Role_permission> implements IRole_permissionService {
    @Resource
    private Role_permissionMapper role_permissionMapper;

    @Override
    public List<Integer> getPermissionId(Integer rid) {
        QueryWrapper q=new QueryWrapper();
        q.eq("R_id",rid);
        return role_permissionMapper.selectList(q);
    }
}
