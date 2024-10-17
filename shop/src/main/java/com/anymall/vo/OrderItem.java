package com.anymall.vo;

import java.sql.Date;

public class OrderItem {
    /**
     * 주문서 아이디
     */
    String id;
    /**
     * 상품 아이디
     */
    int productId;
    /**
     * 주문 수량
     */
    int amount;
    /**
     * 상품 가격
     */
    String price;
    /**
     * 주문번호
     */
    String orderNum;
    /**
     * 배송 상태
     */
    String state;
    /**
     * 주문 날짜
     */
    Date createdDate;
}
