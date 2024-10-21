package com.anymall.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.anymall.common.*;
import com.anymall.vo.Member;
import java.sql.Date;

public class MemberService {
    Member member = new Member();

    /**
     * Member 추가 메서드
     * 
     * @throws SQLException
     */
    public void AddMember() throws SQLException {
        String nID = Utils.next("NEW ID", String.class, s -> true, " ");
        String nPW = Utils.next("NEW PW", String.class, s -> true, " ");
        String nName = Utils.next("NEW NAME", String.class, s -> true, " ");
        String nDate = Utils.next("NEW BIRTH", String.class, s -> true, " ");
        Boolean nGender = Utils.next("NEW GENDER_(Male:true, Female:false)", Boolean.class, s -> true, " ");
        String nAdress = Utils.next("NEW ADRESS", String.class, s -> true, " ");
        System.out.println("회원가입 메세지");
        DbCon.connectDatabase();
        DbCon.queryUpdate("INSERT INTO MEMBER VALUES(" + nID + "," + nPW + "," + nName + "," + nDate + "," + nGender
                + "," + nAdress + "," + "SYSDATE" + "," + "NULL" + ")");
        DbCon.closeDatabase();
    }



    public void findById() throws SQLException {
        DbCon.connectDatabase();
        String target = Utils.next("QueryID", String.class, s -> true, " ");
        System.out.println(DbCon.query("SELECT * FROM MEMBER WHERE " + target));
        DbCon.closeDatabase();
    }

    public void findAll() throws SQLException {
        DbCon.connectDatabase();
        DbCon.query("SELECT * FROM MEMBER");
        DbCon.closeDatabase();
    }

    public void alter() throws SQLException {
        DbCon.connectDatabase();
        String target = Utils.next("QueryID", String.class, s -> true, " ");
        System.out.println(DbCon.query("SELECT * FROM MEMBER WHERE " + target));
        DbCon.closeDatabase(); 
    }

    /**
     * ID 검색어를 기준으로 고객의 정보를 멤버 객체에 담아서 반환합니다.
     * @param String
     * @return memeber
     * @throws SQLException
     */
    public Member saveTmp(String target) throws SQLException {
        DbCon.connectDatabase();
        String query = "SELECT ID, PW, NAME, BIRTH, GENDER, ADRESS, SIGN_DATE, GRADE FROM MEMBER WHERE ID = '" + target
                + "'";
        ResultSet rs = DbCon.query(query);
        if (rs.next()) {
            member.setId(rs.getString("ID"));
            member.setPassword(rs.getString("PW"));
            member.setName(rs.getString("NAME"));
            Date sqlBirthDate = rs.getDate("BIRTH");
            if (sqlBirthDate != null) {
                // java.util.Date utilBirthDate = new java.util.Date(sqlBirthDate.getTime()); 
                member.setBirth(sqlBirthDate);
            }
            member.setGender(rs.getBoolean("GENDER"));
            member.setAddress(rs.getString("ADRESS"));
            Date sqlSignDate = rs.getDate("SIGN_DATE");
            if (sqlSignDate != null) {
                // java.util.Date utilSignDate = new java.util.Date(sqlSignDate.getTime());
                member.setBirth(sqlSignDate);
            }
            member.setGrade(rs.getString("GRADE"));
        }
        DbCon.closeDatabase();
        return member;
    }

    public void useTmp(Member member){
        
    }

}
