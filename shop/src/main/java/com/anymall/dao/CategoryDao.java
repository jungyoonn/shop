package com.anymall.dao;

import java.sql.SQLException;

import com.anymall.common.*;
import com.anymall.repository.*;

public class CategoryDao {
    private CategoryRepository categoryRepository;

    /**
     * 카테고리 추가
     */
    public void create() throws SQLException {
        DbCon.connectDatabase();



        DbCon.closeDatabase();
    }

    /**
     * 카테고리 정보 수정
     */
    public void update() throws SQLException {
        DbCon.connectDatabase();



        DbCon.closeDatabase();
    }

    /**
     * 카테고리 삭제
     */
    public void delete() throws SQLException {
        DbCon.connectDatabase();



        DbCon.closeDatabase();
    }
}