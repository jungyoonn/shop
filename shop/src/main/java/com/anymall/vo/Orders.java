package com.anymall.vo;

import java.sql.Date;

public class Orders {
    /**
     * 주문번호
     */
    private String orderNum;
    /**
     * 회원 아이디
     */
    private String memberId;
    /**
     * 상품 아이디
     */
    private int productId;
    /**
     * 총액
     */
    private String total;
    /**
     * 주문 날짜
     */
    private Date orderDate;
    /**
     * 배송 상태
     */
    private String state;
    /**
     * 결제 수단
     */
    private String payment;
}
