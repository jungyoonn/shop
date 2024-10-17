package com.anymall.vo;

import java.sql.Date;

public class Cart {
    /**
     * 상품 아이디
     */
    int productId;
    /**
     * 회원 아이디
     */
    String memberId;
    /**
     * 담긴 양
     */
    int amount;
    /**
     * 체크 여부
     */
    boolean check;
    /**
     * 담은 날짜
     */
    Date createdDate;
}
