package com.inet.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.inet.code.entity.po.Permissions;
import com.inet.code.mapper.PermissionsMapper;
import com.inet.code.service.IPermissionsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
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
public class PermissionsServiceImpl extends ServiceImpl<PermissionsMapper, Permissions> implements IPermissionsService {
    @Resource
    private PermissionsMapper permissionsMapper;
    @Override
    public Permissions getPermission(Integer Pid) {
        QueryWrapper q=new QueryWrapper();
        q.eq("id",Pid);
        return permissionsMapper.selectOne(q);
    }
}
