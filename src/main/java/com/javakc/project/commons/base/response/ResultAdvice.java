package com.javakc.project.commons.base.response;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @program: spring-boot-project
 * @description: 统一封装接口返回数据
 * @author: zhou hong gang
 * @create: 2020-12-09 11:51
 */
@RestControllerAdvice(basePackages = "com.javakc.project.modules")
public class ResultAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return ResultMessage.success(o);
    }

    @ExceptionHandler(value = Exception.class)
    public Object exception(Exception exception) {
        return ResultMessage.failure(ResultCode.INTERFACE_INNER_INVOKE_ERROR);
    }

}
