package com.example.BaseProject.config;

import com.example.BaseProject.base.log.SystemLog;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class BaseResponseAdapter implements ResponseBodyAdvice<Object> {

    @Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    SystemLog systemLog;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        systemLog.log("request", String.valueOf(httpServletRequest.getRequestURL()), ThreadContext.get("REQUEST_BODY"));
        systemLog.log("response", String.valueOf(httpServletRequest.getRequestURL()), body);
        return body;
    }
}
