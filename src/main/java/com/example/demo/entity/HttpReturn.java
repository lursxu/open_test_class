package com.example.demo.entity;

import com.example.demo.enums.HttpCodeEnum;
import lombok.Data;

/**
 * Describe: 返回的 数据模型
 */

@Data
public class HttpReturn {

    private Integer code;

    private String message;

    private Object data;

    public HttpReturn(Object dataObject, HttpCodeEnum httpCodeEnum) {

        this.data = dataObject;
        this.code = httpCodeEnum.getCode();
        this.message = httpCodeEnum.getMessage();

    }
    public HttpReturn(HttpCodeEnum httpCodeEnum) {

        this.code = httpCodeEnum.getCode();
        this.message = httpCodeEnum.getMessage();

    }

    public HttpReturn() {

    }


}

