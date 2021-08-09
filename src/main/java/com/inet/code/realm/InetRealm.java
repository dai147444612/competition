package com.inet.code.realm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


import com.inet.code.custom.ShiroCustom;
import com.inet.code.entity.po.Login;
import com.inet.code.entity.po.Permissions;
import com.inet.code.entity.token.JwtToken;
import com.inet.code.entity.vo.userInfo;
import com.inet.code.mapper.User_roleMapper;
import com.inet.code.service.ILoginService;
import com.inet.code.service.IUser_roleService;
import com.inet.code.util.JwtUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * INetRealm
 * @since 2021/3/5 下午12:56
 */
@Service
public class InetRealm extends AuthorizingRealm {

    private static final Logger LOGGER = LogManager.getLogger(com.inet.code.realm.InetRealm.class);

//    @Resource
//    public IUserService setUserService(IUserService userService) {
//        return this.userService = userService;
//    }
      @Resource
      private ILoginService loginService;
      @Resource
      private ShiroCustom shiroCustom;
      @Resource
      private RedisTemplate redisTemplate;

    /**
     * 一定需要创建,不然出错
     *
     * @param token token令牌
     * @return 布尔值
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 权限认证
     *
     * @param principalCollection token类
     * @return AuthorizationInfo用户数据
     * @author HCY
     * @since 2020-10-11
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取
        String userId = JwtUtils.getString(principalCollection.toString(), "Uid");

        userInfo userInfo =new userInfo();
        Integer roleid = shiroCustom.getRoleid(userId);
        userInfo.setRole(shiroCustom.getRole(roleid));
        List<Integer> integers = shiroCustom.getpermissionId(roleid);
        List<Permissions> permissions=new ArrayList<>();
        for (int i=0;i<integers.size();i++){
         permissions.add(shiroCustom.getPermission(integers.get(i)));
        }
        userInfo.setPermission(permissions);

        //创建 simpleAuthorizationInfo 对象
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //添加 role 权限
        simpleAuthorizationInfo.addRole(userInfo.getRole());
        //数据的转换
        Set<String> permission = new HashSet<>();
        //循环插入
        for (Permissions resource : userInfo.getPermission()) {
            permission.add(resource.getPermission());
        }
        //添加资源
        simpleAuthorizationInfo.addStringPermissions(permission);
        return simpleAuthorizationInfo;
    }

    /**
     * 身份验证
     *
     * @param authenticationToken token
     * @return AuthenticationInfo 用户信息
     * @throws AuthenticationException
     * @author HCY
     * @since 2020-10-11
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = authenticationToken.getCredentials().toString();
        //通过解密获得账号和密码
        String userId = JwtUtils.getString(token, "userId");
        System.out.println(userId);
        Object o = redisTemplate.opsForValue().get(token);
        //进行查询

        Login login = loginService.checkLogin(userId);
        if (o == null) {
            throw new AuthenticationException("用户未登陆");
        }
        if (login == null) {
            throw new AuthenticationException("用户不存在");
        }
        if (!JwtUtils.verify(token)) {
            throw new AuthenticationException("token出现错误");
        }
        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}
