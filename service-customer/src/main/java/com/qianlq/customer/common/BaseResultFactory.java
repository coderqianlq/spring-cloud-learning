package com.qianlq.customer.common;

import com.qianlq.customer.common.constant.Code;

/**
 * @author CoderQian
 * @date 2018-10-02 下午2:52
 * mail: qianlq0824@gmail.com
 */

public class BaseResultFactory {

    /**
     * 构建成功并返回的数据
     *
     * @param data 返回数据
     * @return BaseResult
     */
    @SuppressWarnings("unchecked")
    public static <T> BaseResult<T> createSuccessResult(Object data) {
        return new BaseResult(Code.SUCCESS, data);
    }

    /**
     * 成功但不返回的数据T
     *
     * @return BaseResult
     */
    public static <T> BaseResult<T> createEmptyResult() {
        return new BaseResult<>(Code.SUCCESS);
    }
}
