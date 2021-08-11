package com.inet.code.entity.vo;

import lombok.*;
import lombok.experimental.Accessors;

import javax.websocket.Session;

/**
 * @ClassName SocketUserInfo
 * @Description
 * @Author drh
 * @Data 11:34 下午
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SocketUserInfo {
    private String userId;

    private Session session;

    private String  targetUserId;
}
