package com.tangmaolin.lab1springmvc.dto;

public class UserAddDTO {

    private String username;    // 账号
    private String password;    // 密码

    public String getUsername() {
        return username;
    }

    public UserAddDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserAddDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
