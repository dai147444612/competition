package com.inet.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.inet.code.entity.po.User_role;
import com.inet.code.mapper.User_roleMapper;
import com.inet.code.service.IUser_roleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author drh
 * @since 2021-08-02
 */
@Service
public class User_roleServiceImpl extends ServiceImpl<User_roleMapper, User_role> implements IUser_roleService {
    @Resource
    private User_roleMapper user_roleMapper;

    @Override
    public Integer getRoleId(String Uid) {
        QueryWrapper q=new QueryWrapper<>();
        q.eq("U_id",Uid);
        return user_roleMapper.selectOne(q).getR_id();
    }

    @Override
    public void register(User_role user_role) {
        user_roleMapper.insert(user_role);
    }
}
