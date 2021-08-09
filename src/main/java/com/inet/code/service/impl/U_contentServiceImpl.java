package com.inet.code.service.impl;

import com.inet.code.entity.po.U_content;
import com.inet.code.mapper.U_contentMapper;
import com.inet.code.service.IU_contentService;
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
public class U_contentServiceImpl extends ServiceImpl<U_contentMapper, U_content> implements IU_contentService {
    @Resource
    private U_contentMapper u_contentMapper;
    @Override
    public void release(U_content content) {
        u_contentMapper.insert(content);
    }
}
