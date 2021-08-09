package com.inet.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.inet.code.entity.po.Content;
import com.inet.code.mapper.ContentMapper;
import com.inet.code.service.IContentService;
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
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content> implements IContentService {
    @Resource
    private ContentMapper contentMapper;
    @Override
    public List<Content> searchByKeyWord(String name) {
        QueryWrapper q=new QueryWrapper();
        q.like("content",name);
        return contentMapper.selectList(q);
    }

    @Override
    public List<Content> hostoryToday(String format) {
        QueryWrapper q=new QueryWrapper();
        q.like("content_time",format);
        return contentMapper.selectList(q);
    }

    @Override
    public Integer getContentCount() {
        return contentMapper.getContentCount();
    }

    @Override
    public Content getContent(Integer v) {
        return contentMapper.selectById(v);
    }
}
