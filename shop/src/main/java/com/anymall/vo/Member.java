package com.anymall.vo;

import java.util.Date;

import lombok.Data;

@Data
public class Member {
    /**
     * 회원 아이디
    */
    String id;
    /**
     * 회원 비밀번호
     */
    String password;
    /**
     * 회원 이름
     */
    String name;
    /** 
     * 회원 생년월일
     */
    Date birth;
    /**
     * 회원 성별
     */
    boolean gender;
    /**
     * 회원 주소
     */
    String address;
    /**
     * 회원 가입 날짜
     */
    Date signDate;
    /**
     * 회원 등급
     */
    String grade;
}