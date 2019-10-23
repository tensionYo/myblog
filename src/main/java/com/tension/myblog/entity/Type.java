package com.tension.myblog.entity;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class Type {
    private Integer id;

    //后台检验
    @NotBlank(message = "分类名称不能为空")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private List<Blog> blogs = new ArrayList<>();

    public Type(){}

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", blogs=" + blogs +
                '}';
    }
}