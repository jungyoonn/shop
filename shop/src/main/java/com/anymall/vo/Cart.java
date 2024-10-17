package com.anymall.vo;

import java.sql.Date;

public class Cart {
    /**
     * 상품 아이디
     */
    private int productId;
    /**
     * 회원 아이디
     */
    private String memberId;
    /**
     * 담긴 양
     */
    private int amount;
    /**
     * 체크 여부
     */
    private boolean check;
    /**
     * 담은 날짜
     */
    private Date createdDate;
}
