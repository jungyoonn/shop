package com.anymall.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.anymall.vo.*;
import com.anymall.common.*;

public class ProductRepository {
    private ResultSet rs = null;

    /**
     * id를 받아서 Product에서 검색
     * @param id 상품 아이디
     * @return Product
     * @throws SQLException
     */
    public Product findById(int id) throws SQLException {
        DbCon.connectDatabase();

        rs = DbCon.query("SELECT ID FROM PRODUCT WHERE ID = " + id);
        Product product = Product.builder().id(rs.getInt("id")).build();

        rs.close();
        DbCon.closeDatabase();

        return product;
    }

    /**
     * name을 받아서 Product에서 검색
     * @param name 상품 이름
     * @return Product
     * @throws SQLException
     */
    public Product findByName(String name) throws SQLException {
        DbCon.connectDatabase();

        rs = DbCon.query("SELECT NAME FROM PRODUCT WHERE NAME = '" + name + "'");
        Product product = product.builder().name(rs.getString("name")).build();

        rs.close();
        Dbcon.closeDatabase();

        return product;
    }
}
