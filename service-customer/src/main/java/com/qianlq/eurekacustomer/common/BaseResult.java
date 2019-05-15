package com.qianlq.eurekacustomer.common;

import com.qianlq.eurekacustomer.common.constant.Code;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author qianliqing
 * @date 2018-09-28 下午9:05
 * mail: qianlq0824@gmail.com
 * <p>
 * 统一的返回类型
 */

@SuppressWarnings("unchecked")
@Data
@AllArgsConstructor
public final class BaseResult<T> {

    private int code;
    private String message;
    private T data = (T) new Object();

    public BaseResult() {
        this.data = (T) new Object();
    }

    public BaseResult(String msg) {
        this();
        this.code = 200;
        this.message = msg;
    }

    public BaseResult(Code code) {
        this.code = code.getCode();
        this.message = code.getMsg();
    }

    public BaseResult(Code code, T data) {
        this.code = code.getCode();
        this.message = code.getMsg();
        this.data = data;
    }

    public BaseResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "BaseResult{" + "code=" + code + ", message='" + message + ", data=" + data + '}';
    }
}
