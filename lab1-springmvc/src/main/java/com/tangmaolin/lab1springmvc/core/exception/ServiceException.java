package com.tangmaolin.lab1springmvc.core.exception;

import com.tangmaolin.lab1springmvc.constants.ServiceExceptionEnum;

public class ServiceException extends RuntimeException{

    private final Integer code; // 状态码

    public ServiceException(ServiceExceptionEnum serviceExceptionEnum) {
        super(serviceExceptionEnum.getMessage());
        this.code = serviceExceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
