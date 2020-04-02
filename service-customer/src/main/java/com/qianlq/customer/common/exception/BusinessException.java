package com.qianlq.customer.common.exception;

import com.qianlq.customer.common.BaseResult;
import com.qianlq.customer.common.constant.Code;
import lombok.NoArgsConstructor;

/**
 * @author CoderQian
 * @date 2018-09-28 下午9:09
 * mail: qianlq0824@gmail.com
 * <p>
 * 业务异常类
 */

@NoArgsConstructor
public final class BusinessException extends BaseException {

    private static final long serialVersionUID = -6962189687050481038L;

    public BusinessException(Code code) {
        super(code.getCode(), code.getMsg());
    }

    public BusinessException(int codeInt, String errorMsg) {
        super(codeInt, errorMsg);
    }

    public BusinessException(BaseResult baseResult) {
        super();
        this.setBaseResult(baseResult);
    }
}
