package com.inet.code.service;

import com.inet.code.entity.po.Video;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author drh
 * @since 2021-08-02
 */
public interface IVideoService extends IService<Video> {

    Integer getVideoCout();

    Video getVideo(int i);
}
