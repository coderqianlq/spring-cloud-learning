package com.qianlq.customer.common;

import com.qianlq.customer.common.constant.Code;

public final class BaseResult<T> {

    private int code;
    private String message;
    private T data;



    public BaseResult(T data) {
        this(Code.SUCCESS, data);
    }

    public BaseResult(Code code) {
        this(code, (T) new Object());
    }

    public BaseResult(Code code, T data) {
        this.code = code.getCode();
        this.message = code.getMsg();
        this.data = data;
    }

    public BaseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
