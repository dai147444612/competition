package com.inet.code.service.impl;

import com.inet.code.entity.po.Video;
import com.inet.code.mapper.VideoMapper;
import com.inet.code.service.IVideoService;
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
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements IVideoService {
    @Resource
    private VideoMapper videoMapper;
    @Override
    public Integer getVideoCout() {
        return videoMapper.getVideo();
    }

    @Override
    public Video getVideo(int i) {
        return videoMapper.selectById(i);
    }
}
