package com.tangmaolin.lab1springmvc.vo;

import lombok.Data;

/**
 * 用户 View Object
 */
public class UserVO {

    private Integer id;

    private String username;

    public Integer getId() {
        return id;
    }

    public UserVO setId(Integer id) {
        this.id = id;
        return this;
    }

    public UserVO setUsername(String username) {
        this.username = username;
        return this;
    }
}
