package com.anymall.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.anymall.vo.*;
import com.anymall.common.*;

public class ProductService {
   
    private ResultSet rs = null;

    /**
     * 상품 추가
     */
    public void create() throws SQLException {
        DbCon.connectDatabase();

        int id = Utils.next("추가할 상품의 아이디를 입력해 주세요", Integer.class, i -> {
            try {
                return findByProductId(i) != null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        } , "올바른 아이디를 입력해 주세요");
        String name = Utils.next("상품의 이름을 입력해 주세요", String.class
                            , s -> s.matches("^[가-힣a-zA-Z!@#$%-]{0,15}"), "올바른 이름을 입력해 주세요");
        String price = Utils.next("가격을 입력해 주세요", String.class
                            , s -> Integer.parseInt(s) < 1000000, "100만 원 이하의 가격을 입력해 주세요");
        String manufacturer = Utils.next("제조사를 입력해 주세요", String.class
                            , s -> s.matches("^[가-힣a-zA-Z!@#$%-]{0,15}"), "올바른 이름을 입력해 주세요");
        String categoryName = Utils.next("분류 코드를 입력해 주세요", String.class, (s) -> {
            try {
                return findByCodeName(s) != null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }, "존재하지 않는 코드입니다");
        int categoryId = findByCodeId(categoryName);

        DbCon.queryUpdate("INSERT INTO PRODUCT VALUES (" + id  + "," + name  + "," + price  + "," + manufacturer  + "," + categoryId + ", 1, SYSDATE");
    }

    /**
     * 
     * @param name 분류명
     * @return 분류명
     * @throws SQLException
     */
    public String findByCodeName(String name) throws SQLException {
        DbCon.connectDatabase();

        rs = DbCon.query("SELECT NAME FROM CATEGORY WHERE NAME = '" + name + "'");
        Category category = Category.builder().categoryName(rs.getString("name")).build();

        rs.close();
        DbCon.closeDatabase();

        return category.getCategoryName();
    }

    /**
     * 분류명으로 데이터를 찾아서 id를 리턴
     * @param name 분류명
     * @return 분류 코드 id
     * @throws SQLException
     */
    public int findByCodeId(String name) throws SQLException {
        DbCon.connectDatabase();

        rs = DbCon.query("SELECT NAME FROM CATEGORY WHERE NAME = '" + name + "'");
        Category category = Category.builder().categoryName(rs.getString("name")).build();

        rs.close();
        DbCon.closeDatabase();

        return category.getCategoryId();
    }

    /**
     * id를 받아서 Product에서 검색
     * @param id 상품 아이디
     * @return Product
     * @throws SQLException
     */
    public Product findByProductId (int id) throws SQLException {
        DbCon.connectDatabase();

        rs = DbCon.query("SELECT ID FROM PRODUCT WHERE ID = " + id);
        Product product = Product.builder().id(rs.getInt("id")).build();

        rs.close();
        DbCon.closeDatabase();

        return product;
    }
}
