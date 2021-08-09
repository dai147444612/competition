package com.inet.code.custom;

import com.inet.code.entity.dto.*;
import com.inet.code.result.Result;

public interface userCustom {
    Result register(register register, String path);

    Result login(UserLogin login, String path);

    Result changePassword(changePassword changePassword,String token,String path);

    Result searchByKeyWord(String name, String token, String path);

    Result hostoryToday(String token, String path);

    Result getRan(String token, String path);

    Result getVideo(String token, String path);

    Result release(userContent userContent, String token, String path);

    Result searchLocal(String token, String path);

    Result subscripted(subscripted subscripted, String token, String path);

    Result getSub(String token, String getSub);
}
