package com.liuchen.util;

import lombok.Data;

/**
 * Package: com.liuchen.util
 * Description:
 *
 * @Author: Liu-Chen-CS
 * @Create: 4/1/2024 - 1:59 PM
 * @Version: v1.0
 */

@Data
public class Result<T>{
    private Integer code;
    private Boolean success;
    private String message;
    private T data;

    public static <T> Result<T> ok(T data) {
        Result<T> r = new Result<>();
        r.setCode(200);
        r.setMessage("Operation succeed");
        r.setSuccess(true);
        r.setData(data);
        return r;
    }

    public static <T> Result<T> ok(String message) {
        Result<T> r = new Result<>();
        r.setCode(200);
        r.setSuccess(true);
        r.setMessage(message);
        return r;
    }

    public static <T> Result<T> ok(String message, T data) {
        Result<T> r = new Result<>();
        r.setCode(200);
        r.setMessage(message);
        r.setSuccess(true);
        r.setData(data);
        return r;
    }

    public static <T> Result<T> error() {
        Result<T> r = new Result<>();
        r.setCode(500);
        r.setSuccess(false);
        r.setMessage("Operation failed");
        return r;
    }

}
