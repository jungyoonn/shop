package com.anymall.vo;

import java.sql.Date;

public class Orders {
    /**
     * 주문번호
     */
    String orderNum;
    /**
     * 회원 아이디
     */
    String memberId;
    /**
     * 상품 아이디
     */
    int productId;
    /**
     * 총액
     */
    String total;
    /**
     * 주문 날짜
     */
    Date orderDate;
    /**
     * 배송 상태
     */
    String state;
    /**
     * 결제 수단
     */
    String payment;
}
