package com.anymall.dao;

import java.sql.SQLException;

import com.anymall.common.*;
import com.anymall.repository.*;

public class ProductDao {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    /**
     * 상품 추가
     */
    public void create() throws SQLException {
        DbCon.connectDatabase();

        int id = Utils.next("추가할 상품의 아이디를 입력해 주세요", Integer.class, i -> {
            try {
                return productRepository.findById(i) != null;
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
                return categoryRepository.findByName(s) != null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }, "존재하지 않는 코드입니다");
        int categoryId = categoryRepository.findByName(categoryName).getCategoryId();

        DbCon.queryUpdate("INSERT INTO PRODUCT VALUES (" + id  + ", '" + name  + "', '" + price  + "', '" + manufacturer  + "', " + categoryId + ", 1, SYSDATE)");
    
        DbCon.closeDatabase();
    }

    /**
     * 상품 정보 수정
     */
    public void update() throws SQLException {
        DbCon.connectDatabase();

        

        DbCon.closeDatabase();
    }

    /**
     * 상품 삭제
     */
    public void delete() throws SQLException {
        DbCon.connectDatabase();

        String name = Utils.next("삭제할 상품의 이름을 입력해 주세요", String.class
                            , s -> {
                                try {
                                    return productRepository.findByName(s) != null;
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                return false;
                            }, "올바른 이름을 입력해 주세요");
        
        System.out.println(name + " 상품을 정말 삭제하시겠습니까?");
        int del = Utils.next("(1. 예  2. 아니오)", Integer.class, i -> i < 3 && i > 0, "1과 2만 입력해 주세요");
        if(del == 2) {
            System.out.println("삭제를 취소하셨습니다");
            DbCon.closeDatabase();
            return;
        }
        DbCon.queryUpdate("DELETE FROM PRODUCT WHERE NAME = '" + name + "'");
        DbCon.closeDatabase();
    }
}