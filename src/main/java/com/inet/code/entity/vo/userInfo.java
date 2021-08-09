package com.inet.code.entity.vo;

import com.inet.code.entity.po.Permissions;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @ClassName userInfo
 * @Description
 * @Author drh
 * @Data 10:18 上午
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class userInfo {

    private String role;

    private List<Permissions> permission;

}
