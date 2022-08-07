package com.tangmaolin.lab1springmvc.dto;

public class UserUpdateDTO {
    private Integer id; // 用户id
    private String username;    // 账号
    private String password;    // 密码

    public Integer getId() {
        return id;
    }

    public UserUpdateDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserUpdateDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserUpdateDTO setPassword(String password) {
        this.password = password;
        return this;
    }

}
