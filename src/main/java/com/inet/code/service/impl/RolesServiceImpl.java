package com.inet.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.inet.code.entity.po.Roles;
import com.inet.code.mapper.RolesMapper;
import com.inet.code.service.IRolesService;
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
public class RolesServiceImpl extends ServiceImpl<RolesMapper, Roles> implements IRolesService {
    @Resource
    private RolesMapper rolesMapper;
    @Override
    public String getRole(Integer rid) {
        QueryWrapper q=new QueryWrapper();
        q.eq("id",rid);
        return rolesMapper.selectOne(q).getRole();
    }
}
