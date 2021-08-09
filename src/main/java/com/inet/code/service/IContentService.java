package com.inet.code.service;

import com.inet.code.entity.po.Content;
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
public interface IContentService extends IService<Content> {

    List<Content> searchByKeyWord(String name);

    List<Content> hostoryToday(String format);

    Integer getContentCount();

    Content getContent(Integer v);
}
