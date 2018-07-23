package com.bimface.demo.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="user对象",description="用户对象user")
public class User {

    @ApiModelProperty(value="id",name="id",example="21")
    private long id;
    @ApiModelProperty(value = "用户名", name = "username", example = "xingguo")
    protected String name;
    @ApiModelProperty(value="年龄",name="age",example="21")
    private int age;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
