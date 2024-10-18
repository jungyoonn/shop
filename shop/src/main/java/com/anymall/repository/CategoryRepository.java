package com.anymall.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.anymall.vo.*;
import com.anymall.common.*;

public class CategoryRepository {
    private ResultSet rs = null;

    /**
     * 
     * @param name 분류명
     * @return 분류명
     * @throws SQLException
     */
    public Category findByName(String name) throws SQLException {
        DbCon.connectDatabase();

        rs = DbCon.query("SELECT NAME FROM CATEGORY WHERE NAME = '" + name + "'");
        Category category = Category.builder().categoryName(rs.getString("name")).build();

        rs.close();
        DbCon.closeDatabase();

        return category;
    }

    /**
     * 분류명으로 데이터를 찾아서 id를 리턴
     * @param name 분류명
     * @return 분류 코드 id
     * @throws SQLException
     */
    public Category findById(int id) throws SQLException {
        DbCon.connectDatabase();

        rs = DbCon.query("SELECT CATEGORYID FROM CATEGORY WHERE CATEGORYID = " + id);
        Category category = Category.builder().categoryId(rs.getInt("categoryId")).build();

        rs.close();
        DbCon.closeDatabase();

        return category;
    }
}
