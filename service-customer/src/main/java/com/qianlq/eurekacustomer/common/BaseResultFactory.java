package com.qianlq.eurekacustomer.common;

import com.qianlq.eurekacustomer.common.constant.Code;

/**
 * @author qianliqing
 * @date 2018-10-02 下午2:52
 * mail: qianlq0824@gmail.com
 */

@SuppressWarnings("unchecked")
public class BaseResultFactory {

    /**
     * 构建成功并返回的数据
     *
     * @param data 返回数据
     * @return BaseResult<T>
     */
    public static <T> BaseResult<T> createSuccessResult(Object data) {
        return new BaseResult(Code.SUCCESS, data);
    }

    /**
     * 成功但不返回的数据
     *
     * @return BaseResult<T>
     */
    public static <T> BaseResult<T> createEmptyResult() {
        return new BaseResult<>(Code.SUCCESS);
    }
}
