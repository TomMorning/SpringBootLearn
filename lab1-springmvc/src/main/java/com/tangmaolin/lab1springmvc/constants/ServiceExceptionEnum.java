package com.tangmaolin.lab1springmvc.constants;

public enum ServiceExceptionEnum {
    // 系统级别
    SUCCESS(0, "成功"),
    SYS_ERROR(1, "服务端发生异常"),
    MISSING_REQUEST_PARAM_ERROR(2, "参数缺失"),

    // 用户模块
    USER_NOT_FOUND(3, "用户不存在"),
    ;


    private int code;   // 错误返回码

    private String message;     // 错误提示
    ServiceExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
