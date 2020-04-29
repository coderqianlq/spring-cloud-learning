package com.qianlq.customer.common.exception;

import com.qianlq.customer.common.constant.Code;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author CoderQian
 * @date 2018-09-28 下午9:14
 * @concat <a href="mailto:qianlq0824@gmail.com">qianlq0824@gmail.com</a>
 * <p>
 * 基本异常类
 */

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BaseException extends RuntimeException {

    private int code;
    private String msg;

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
}
