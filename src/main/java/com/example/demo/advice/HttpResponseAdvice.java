package com.example.demo.advice;

import com.example.demo.entity.HttpReturn;
import com.example.demo.enums.HttpCodeEnum;
import com.example.demo.exception.DataHandlingException;
import com.example.demo.exception.RequestArgumentsException;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


@RestControllerAdvice("com.surfilter.finance.controller")
public class HttpResponseAdvice implements ResponseBodyAdvice {

    /*
     * 判断哪些需要拦截
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class converterType) {

//        String name = methodParameter.getExecutable().getName();
        String name = methodParameter.getMethod().getDeclaringClass().getName();

        if("xxx.xxx.xxxx".equals(name)){//不拦截

            return false;

        }else{//拦截

            return true;

        }

    }

    @Override
    public Object beforeBodyWrite(Object object, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {


        if( object instanceof HttpReturn) {

            return object;

        }else {

            return new HttpReturn(object, HttpCodeEnum.OK);

        }

    }

    /*
    * 需要自定义异常，根据不同异常在本方法选择不同Response信息，严禁在service层定义返回值对像（需要在service中主动抛出相关异常）
    * */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public HttpReturn errorHandler(Exception ex){

        ex.printStackTrace();

        HttpCodeEnum httpCodeEnum = null;

        if(ex instanceof DataHandlingException){

            httpCodeEnum = HttpCodeEnum.UN_KNOW_ERROR;

        }else if(ex instanceof RequestArgumentsException){

            httpCodeEnum = HttpCodeEnum.INVALID_REQUEST;

        }else {

            httpCodeEnum = HttpCodeEnum.FAIL;

        }

        return new HttpReturn(httpCodeEnum);

    }

}
