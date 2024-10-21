package com.anymall.vo;

// import java.util.Date;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    /**
     * 회원 아이디
    */
    private String id;
    /**
     * 회원 비밀번호
     */
    private String password;
    /**
     * 회원 이름
     */
    private String name;
    /** 
     * 회원 생년월일
     */
    private Date birth;
    /**
     * 회원 성별
     */
    private boolean gender;
    /**
     * 회원 주소
     */
    private String address;
    /**
     * 회원 가입 날짜
     */
    private Date signDate;
    /**
     * 회원 등급
     */
    private String grade;
}