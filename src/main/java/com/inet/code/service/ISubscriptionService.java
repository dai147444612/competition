package com.inet.code.service;

import com.inet.code.entity.po.Subscription;
import com.baomidou.mybatisplus.extension.service.IService;
import com.inet.code.entity.po.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author drh
 * @since 2021-08-02
 */
public interface ISubscriptionService extends IService<Subscription> {

    void subscripted(String s_uid, String userId);

    List<Subscription> getSub(String userId);

}
