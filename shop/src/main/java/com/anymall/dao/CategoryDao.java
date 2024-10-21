package com.anymall.dao;

import java.sql.SQLException;

import com.anymall.common.*;
import com.anymall.repository.*;

public class CategoryDao {
    private CategoryRepository categoryRepository;

    public void create() throws SQLException {
        DbCon.connectDatabase();



        DbCon.closeDatabase();
    }

    public void update() throws SQLException {
        DbCon.connectDatabase();



        DbCon.closeDatabase();
    }

    public void delete() throws SQLException {
        DbCon.connectDatabase();



        DbCon.closeDatabase();
    }
}