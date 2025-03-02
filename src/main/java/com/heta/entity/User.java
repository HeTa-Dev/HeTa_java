package com.heta.entity;

import lombok.Data;

@Data
public class User {
    private String username;
    private int id;
    private String passwd;
    private long phoneNum;
    private String avatarPath;
    private int age;
    private String address;//TODO：未来如果需求更复杂可以另创一个Address类
    private String personalSlogan;
    private String type;
    private Boolean isBanned;
}
