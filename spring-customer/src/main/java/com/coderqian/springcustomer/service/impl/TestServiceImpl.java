package com.coderqian.springcustomer.service.impl;

import com.coderqian.springcustomer.common.constant.Code;
import com.coderqian.springcustomer.common.exception.BusinessException;
import com.coderqian.springcustomer.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author qianliqing
 * @date 2018-09-28 下午2:39
 * mail: qianlq0824@gmail.com
 */

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String test(String text) {
        return text;
    }

    @Override
    public void testException(String text) throws BusinessException {
        throw new BusinessException(Code.UNDEFINED);
    }
}
