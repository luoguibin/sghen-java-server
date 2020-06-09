package com.example.springdemo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestfulApiExceptionHandler {
 
    // 这里处理MissingServletRequestParameterException的异常
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    // 返回JSON数据
    @ResponseBody
    // 特别注意第二个参数为要处理的异常
    public Map<String, Object> requestExceptionHandler(HttpServletRequest request, MissingServletRequestParameterException exception) {
        Map<String, Object> error = new HashMap<>();
        error.put("status", 500);
        // 在这里可以定义返回的异常提示信息
        error.put("message", "参数" + exception.getParameterName() + "错误");
        return error;
    }
 
    // 这里处理没有被上一个方法处理的异常，通常在最后的方法处理最大的Exception，保证兜底
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String, Object> exceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
        Map<String, Object> error = new HashMap<>();
        error.put("status", 1001);
        error.put("message", "请求错误");
        System.out.println(exception);
        return error;
    }
 
}