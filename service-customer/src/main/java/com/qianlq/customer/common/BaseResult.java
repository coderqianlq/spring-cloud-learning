package com.qianlq.customer.common;

import com.qianlq.customer.common.constant.Code;
import lombok.Data;

/**
 * @author CoderQian
 * @date 2018-09-28 下午9:05
 * mail: qianlq0824@gmail.com
 * <p>
 * 统一的返回类型
 */

@Data
public final class BaseResult<T> {

    private int code;
    private String message;
    private T data;

    public BaseResult(T data) {
        this(Code.SUCCESS, data);
    }

    @SuppressWarnings(value = "unchecked")
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

    @Override
    public String toString() {
        return "BaseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
