package com.anymall.vo;

import java.sql.Date;

public class Category {
    /**
     * 분류 아이디
     */
    int categoryId;
    /**
     * 분류명
     */
    String categoryName;
    /**
     * 사용 여부
     */
    boolean use;
    /**
     * 상위 분류
     */
    int above;
    /**
     * 생성 날짜
     */
    Date createdDate;
}
