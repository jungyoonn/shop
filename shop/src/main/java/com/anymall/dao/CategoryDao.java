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

        int id = Utils.next("추가할 카테고리의 아이디를 입력해 주세요", Integer.class, i -> {
            try {
                return categoryRepository.findById(i) != null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }, "올바른 아이디를 입력해 주세요");
        String name = Utils.next("카테고리 이름을 입력해 주세요", String.class
                    , s -> s.matches("^[가-힣a-zA-Z!@#$%-]{0,15}") , "올바른 이름을 입력해 주세요");
        
        int use = Utils.next("사용 여부를 입력해 주세요 (0. 미사용  1. 사용)", Integer.class
                    , i -> i == 0 || i == 1, "0 혹은 1만 입력해 주세요");
        int above = Utils.next("상위 분류를 입력하세요 (없을 경우 0 입력)", Integer.class
                    , i -> {
                        try {
                            return i == 0 || categoryRepository.findById(i) != null;
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        return false;
                    }, "존재하지 않는 카테고리입니다");

        DbCon.queryUpdate("INSERT INTO CATEGORY VALUES (" + id + ", '" + name + "', " + use + ", " + (above == 0 ? "NULL" : above) + ", SYSDATE");

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