package com.qianlq.customer.common.exception;

import com.qianlq.customer.common.constant.Code;

public abstract class BaseException extends RuntimeException {

    private final int code;

    private final String msg;

    BaseException() {
        this(Code.FAILED);
    }

    BaseException(String msg) {
        this(Code.FAILED.getCode(), msg);
    }

    BaseException(Code code) {
        this(code.getCode(), code.getMsg());
    }

    BaseException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
