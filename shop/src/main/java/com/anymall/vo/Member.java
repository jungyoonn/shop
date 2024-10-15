package com.anymall.vo;

import java.util.Date;

import lombok.Data;

@Data
public class Member {
    String id;
    String password;
    String name;
    Date birth;
    boolean gender;
    String address;
    Date signDate;
    String grade;
}