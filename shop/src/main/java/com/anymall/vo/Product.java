package com.anymall.vo;

import java.sql.Date;

public class Product {
    /**
     * 상품 아이디
     */
    int id;
    /**
     * 상품 이름
     */
    String name;
    /**
     * 상품 가격
     */
    String price;
    /**
     * 제조사
     */
    String manufacturer;
    /**
     * 분류 아이디
     */
    int categoryId;
    /**
     * 사용 여부
     */
    boolean use;
    /**
     * 생성 날짜
     */
    Date createdDate;
}
