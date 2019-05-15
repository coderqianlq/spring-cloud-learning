package com.qianlq.eurekacustomer.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author qianliqing
 * @date 2019/1/17 3:50 PM
 * email: qianlq0824@gmail.com
 */

@Data
@NoArgsConstructor
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = -3510647608252836375L;
}
