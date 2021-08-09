package com.inet.code.service;

import com.inet.code.entity.po.U_content;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author drh
 * @since 2021-08-02
 */
public interface IU_contentService extends IService<U_content> {

    void release(U_content content);
}
