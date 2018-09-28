package com.coderqian.springcustomer.common.exception;

import com.coderqian.springcustomer.common.BaseResult;

/**
 * @author qianliqing
 * @date 2018-09-28 下午9:14
 * mail: qianlq0824@gmail.com
 * <p>
 * 基本异常类
 */

public abstract class BaseException extends RuntimeException {

    private int codeInt;
    private String msg;
    private BaseResult baseResult;

    BaseException() {
        super();
    }

    BaseException(int codeInt, String msg) {
        super(msg);
        this.codeInt = codeInt;
        this.msg = msg;
        this.baseResult = new BaseResult(codeInt, msg);
    }

    public int getCodeInt() {
        return codeInt;
    }

    public void setCodeInt(int codeInt) {
        this.codeInt = codeInt;
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
