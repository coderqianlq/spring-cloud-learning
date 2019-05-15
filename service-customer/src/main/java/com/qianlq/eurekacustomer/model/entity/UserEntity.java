package com.qianlq.eurekacustomer.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author qianliqing
 * @date 2018-10-02 下午2:33
 * mail: qianlq0824@gmail.com
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String birth;
}
