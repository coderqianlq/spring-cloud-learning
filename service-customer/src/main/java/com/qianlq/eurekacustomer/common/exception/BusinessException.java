package com.qianlq.eurekacustomer.common.exception;

import com.qianlq.eurekacustomer.common.BaseResult;
import com.qianlq.eurekacustomer.common.constant.Code;
import lombok.NoArgsConstructor;

/**
 * @author qianliqing
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
