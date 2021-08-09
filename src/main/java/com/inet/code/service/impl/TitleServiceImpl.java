package com.inet.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.inet.code.entity.po.Title;
import com.inet.code.mapper.TitleMapper;
import com.inet.code.result.Result;
import com.inet.code.service.ITitleService;
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
public class TitleServiceImpl extends ServiceImpl<TitleMapper, Title> implements ITitleService {
    @Resource
    private TitleMapper titleMapper;
    @Override
    public List<Title> getTitle() {

        return titleMapper.getTitle();
    }
}
