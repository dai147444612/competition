package com.inet.code.mapper;

import com.inet.code.entity.po.Title;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author drh
 * @since 2021-08-02
 */
public interface TitleMapper extends BaseMapper<Title> {
 public List<Title>  getTitle();
}
