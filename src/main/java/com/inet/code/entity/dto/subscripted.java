package com.inet.code.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @ClassName subscripted
 * @Description
 * @Author drh
 * @Data 10:01 上午
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "订阅用户实体类")
public class subscripted {
    @ApiModelProperty(value = "被订阅用户Id")
    private String S_Uid;
}
