package com.anymall.vo;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Product {
    /**
     * 상품 아이디
     */
    private int id;
    /**
     * 상품 이름
     */
    private String name;
    /**
     * 상품 가격
     */
     private String price;
    /**
     * 제조사
     */
     private String manufacturer;
    /**
     * 분류 아이디
     */
    private int categoryId;
    /**
     * 사용 여부
     */
    private boolean use;
    /**
     * 생성 날짜
     */
    private Date createdDate;
}
