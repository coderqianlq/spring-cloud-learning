package com.qianlq.customer.common.exception;

import com.qianlq.customer.common.BaseResult;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author CoderQian
 * @date 2018-09-28 下午9:14
 * mail: qianlq0824@gmail.com
 * <p>
 * 基本异常类
 */

@Data
@AllArgsConstructor
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
}
