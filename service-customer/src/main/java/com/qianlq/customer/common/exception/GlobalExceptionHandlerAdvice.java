package com.qianlq.customer.common.exception;

import com.qianlq.customer.common.BaseResult;
import com.qianlq.customer.common.constant.Code;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常捕获
 */
@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

    private final Logger LOGGER = LogManager.getLogger(GlobalExceptionHandlerAdvice.class);

    @ExceptionHandler(BusinessException.class)
    public BaseResult<Object> handleBusinessException(BusinessException e) {
        LOGGER.error(e);
        return new BaseResult<>(Code.FAILED, e.getMsg());
    }
}
