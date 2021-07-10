package com.qianlq.customer.common.exception;

import com.qianlq.customer.common.constant.Code;

public final class BusinessException extends BaseException {

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
