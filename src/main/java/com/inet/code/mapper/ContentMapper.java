package com.inet.code.mapper;

import com.inet.code.entity.po.Content;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author drh
 * @since 2021-08-02
 */
public interface ContentMapper extends BaseMapper<Content> {
    public Integer getContentCount();
}
