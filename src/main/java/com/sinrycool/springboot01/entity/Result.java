package com.sinrycool.springboot01.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Http请求返回处理类
 *
 * @author ：Sinry
 * @date ：Created in 2019-03-04 17:07
 */
public class Result<T> {

    private Integer code;
    private String message;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time = new Date();
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return new Date();
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
