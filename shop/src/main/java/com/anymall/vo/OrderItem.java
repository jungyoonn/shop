package com.anymall.vo;

import java.sql.Date;

public class OrderItem {
    /**
     * 주문서 아이디
     */
    private String id;
    /**
     * 상품 아이디
     */
    private int productId;
    /**
     * 주문 수량
     */
    private int amount;
    /**
     * 상품 가격
     */
    private String price;
    /**
     * 주문번호
     */
    private String orderNum;
    /**
     * 배송 상태
     */
    private String state;
    /**
     * 주문 날짜
     */
    private Date createdDate;
}
