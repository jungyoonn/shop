package com.anymall.vo;

import java.sql.Date;

public class Category {
    /**
     * 분류 아이디
     */
    private int categoryId;
    /**
     * 분류명
     */
    private String categoryName;
    /**
     * 사용 여부
     */
    private boolean use;
    /**
     * 상위 분류
     */
    private int above;
    /**
     * 생성 날짜
     */
    private Date createdDate;
}
