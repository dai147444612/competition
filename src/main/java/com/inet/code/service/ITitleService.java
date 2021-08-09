package com.inet.code.service;

import com.inet.code.entity.po.Title;
import com.baomidou.mybatisplus.extension.service.IService;
import com.inet.code.result.Result;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author drh
 * @since 2021-08-02
 */
public interface ITitleService extends IService<Title> {

    List<Title> getTitle();

}
