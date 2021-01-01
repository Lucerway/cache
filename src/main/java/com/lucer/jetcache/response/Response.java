package com.lucer.jetcache.response;

import java.io.Serializable;

/**
 * @author: liuchuan
 */
public class Response<T> implements Serializable {
    private static final long serialVersionUID = -6349118950524483854L;
    private String code;
    private String msg;
    private boolean success;
    private T result;


    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }


    public static <T> Response<T> success(T data) {
        return generateResponse(true, "8000", "", data);
    }


    public static <T> Response<T> fail() {
        return generateResponse(false, "9000", "服务异常", null);
    }


    private static <T> Response<T> generateResponse(boolean success, String code, String msg, T data) {
        Response<T> response = new Response<>();
        response.code = code;
        response.msg = msg;
        response.success = success;
        response.result = data;
        return response;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", success=" + success +
                ", result=" + result +
                '}';
    }
}

