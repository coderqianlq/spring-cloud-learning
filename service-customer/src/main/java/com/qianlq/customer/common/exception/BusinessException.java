package com.qianlq.customer.common.exception;

import com.qianlq.customer.common.constant.Code;

/**
 * @author CoderQian
 * @date 2018-09-28 下午9:09
 * @concat <a href="mailto:qianlq0824@gmail.com">qianlq0824@gmail.com</a>
 * <p>
 * 业务异常类
 */

public final class BusinessException extends BaseException {

    private static final long serialVersionUID = -6962189687050481038L;

    public BusinessException() {
        this(Code.FAILED);
    }

    public BusinessException(Code code) {
        super(code.getCode(), code.getMsg());
    }

    public BusinessException(String msg) {
        super(msg);
    }
}
