package com.inet.code.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @ClassName register
 * @Description
 * @Author drh
 * @Data 10:13 上午
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "注册实体类")
public class register {
    @ApiModelProperty("账号")
    private String username;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("年龄")
    private Integer age;
    @ApiModelProperty("当前位置")
    private String location;
    @ApiModelProperty("电话")
    private String phone;
    @ApiModelProperty("注册日期")
    private Date created;
    @ApiModelProperty("修改日期")
    private Date modified;

}
