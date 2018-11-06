package com.coderqian.eurekacustomer.common.exception;

import com.coderqian.eurekacustomer.common.BaseResult;

/**
 * @author qianliqing
 * @date 2018-09-28 下午9:14
 * mail: qianlq0824@gmail.com
 * <p>
 * 基本异常类
 */

public abstract class BaseException extends RuntimeException {

    private int code;
    private String msg;
    private BaseResult baseResult;

    BaseException() {
        super();
    }

    BaseException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
        this.baseResult = new BaseResult(code, msg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BaseResult getBaseResult() {
        return baseResult;
    }

    public void setBaseResult(BaseResult baseResult) {
        this.baseResult = baseResult;
    }
}
