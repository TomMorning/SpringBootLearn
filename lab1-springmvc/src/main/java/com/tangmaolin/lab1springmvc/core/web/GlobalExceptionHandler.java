package com.tangmaolin.lab1springmvc.core.web;

import com.tangmaolin.lab1springmvc.constants.ServiceExceptionEnum;
import com.tangmaolin.lab1springmvc.core.exception.ServiceException;
import com.tangmaolin.lab1springmvc.vo.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(basePackages = "com.tangmaolin.lab1springmvc.controller")
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 处理 ServiceException异常
     */
    @ResponseBody
    @ExceptionHandler(value = ServiceException.class)
    public CommonResult serviceExceptionHandler(HttpServletRequest request, ServiceException serviceException) {
        logger.debug("[serviceExceptionHandler]", serviceException);
        return CommonResult.error(serviceException.getCode(), serviceException.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public CommonResult MissingServletRequestParameterExceptionHandler(HttpServletRequest request, MissingServletRequestParameterException exception) {
        logger.debug("[MissingServletRequestParameterExceptionHandler]", exception);
        return CommonResult.error(ServiceExceptionEnum.MISSING_REQUEST_PARAM_ERROR.getCode(),
                ServiceExceptionEnum.MISSING_REQUEST_PARAM_ERROR.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public CommonResult exceptionHandler(HttpServletRequest request, Exception exception) {
        logger.debug("[ExceptionHandler]", exception);
        return CommonResult.error(ServiceExceptionEnum.MISSING_REQUEST_PARAM_ERROR.getCode(),
                ServiceExceptionEnum.SYS_ERROR.getMessage());
    }
}
