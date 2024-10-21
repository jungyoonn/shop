package com.anymall.service;

import java.sql.SQLException;

import com.anymall.dao.*;

public class ProductService {
    private ProductDao productDao;

    public void save() throws SQLException {
        productDao.create();
    }

    public void update() throws SQLException {
        productDao.update();
    }
}
