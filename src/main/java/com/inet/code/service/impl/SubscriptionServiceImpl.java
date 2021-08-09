package com.inet.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.inet.code.entity.po.Subscription;
import com.inet.code.mapper.SubscriptionMapper;
import com.inet.code.service.ISubscriptionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
public class SubscriptionServiceImpl extends ServiceImpl<SubscriptionMapper, Subscription> implements ISubscriptionService {
    @Resource
    private SubscriptionMapper subscriptionMapper;
    @Override
    public void subscripted(String s_uid, String userId) {
        subscriptionMapper.insert(new Subscription().setU_id(userId)
                                                    .setS_Uid(s_uid)
                                                    .setCreated(new Date())
                                                    .setModified(new Date()));
    }

    @Override
    public List<Subscription> getSub(String userId) {
        QueryWrapper q=new QueryWrapper();
        q.eq("U_id",userId);
        return subscriptionMapper.selectList(q);
    }
}
