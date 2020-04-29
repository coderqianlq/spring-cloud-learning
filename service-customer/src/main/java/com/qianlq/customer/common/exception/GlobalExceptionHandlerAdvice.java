package com.qianlq.customer.common.exception;

import com.qianlq.customer.common.BaseResult;
import com.qianlq.customer.common.constant.Code;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author CoderQian
 * @date 2018-09-28 下午9:03
 * @concat <a href="mailto:qianlq0824@gmail.com">qianlq0824@gmail.com</a>
 * <p>
 * 全局异常捕获
 */

@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

    private static Logger logger = LogManager.getLogger(GlobalExceptionHandlerAdvice.class);

    @ExceptionHandler(BusinessException.class)
    public BaseResult handleBusinessException(BusinessException e) {
        logger.error(e);
        return new BaseResult<>(Code.FAILED, e.getMsg());
    }
}
