package com.qianlq.customer.model.entity;

public class UserEntity extends BaseEntity {

    private String id;

    private String name;

    private String birth;

    public UserEntity(String id, String name, String birth) {
        this.id = id;
        this.name = name;
        this.birth = birth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
