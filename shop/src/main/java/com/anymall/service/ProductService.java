package com.anymall.service;

import java.sql.SQLException;

import com.anymall.dao.*;

public class ProductService {
    private ProductDao productDao;

    /**
     * 상품 정보 저장 메서드
     */
    public void save() throws SQLException {
        productDao.create();
    }

    /**
     * 상품 정보 변경 메서드
     */
    public void update() throws SQLException {
        
    }

    /**
     *  상품 저장 메서드
     */
    public void delete() throws SQLException {
        productDao.delete();
    }
}
