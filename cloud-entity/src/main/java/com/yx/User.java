package com.yx;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author YX_Z
 * @version 1.00
 * @time 2022/10/4 15:35
 */
@Data
@ApiModel
public class User implements Serializable {

    @ApiModelProperty("用户id")
    private int id;

    @ApiModelProperty("用户姓名")
    private String name;

    @ApiModelProperty("用户年龄")
    private int age;

    public User(int i, String n, int i1) {
        id=i;
        name=n;
        age=i1;
    }
}
