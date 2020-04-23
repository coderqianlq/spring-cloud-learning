package com.qianlq.customer.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author CoderQian
 * @date 2018-10-02 下午2:33
 * mail: qianlq0824@gmail.com
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private String birth;
}
