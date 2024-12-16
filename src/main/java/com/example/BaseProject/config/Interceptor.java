package com.example.BaseProject.config;

import com.google.gson.Gson;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Type;
import java.util.UUID;

@Component
@ControllerAdvice
public class Interceptor extends RequestBodyAdviceAdapter implements HandlerInterceptor {

    private final Gson gson = new Gson();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ThreadContext.put("UUID", UUID.randomUUID().toString());
        ThreadContext.put("START_TIME", String.valueOf(System.currentTimeMillis()));
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadContext.remove("UUID");
        ThreadContext.remove("REQUEST_BODY");
        ThreadContext.remove("START_TIME");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    // Hàm chỉ hoạt động khi có đối tượng @RequestBody truyền vào
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        ThreadContext.put("REQUEST_BODY", gson.toJson(body));
        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
    }
}
