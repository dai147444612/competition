package com.inet.code.custom;

import com.inet.code.entity.po.Permissions;

import java.util.List;

public interface ShiroCustom {
    public Integer getRoleid(String Uid);
    public String getRole(Integer Rid);

    public List<Integer> getpermissionId(Integer Rid);

    public Permissions getPermission(Integer Pid);
}
