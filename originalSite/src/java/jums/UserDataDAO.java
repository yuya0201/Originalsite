/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import base.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する
 * DB接続系はDBManagerクラスに一任
 * 基本的にはやりたい1種類の動作に対して1メソッド
 * @author 
 */
public class UserDataDAO {
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
            /**
     * ユーザーデータの挿入処理を行う。
     * @param udd 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insert(UserDataDTO udd) throws SQLException{
            Connection con = null;
            PreparedStatement st = null;
    try{
            con = DBManager.getConnection();
            
            st =  con.prepareStatement("INSERT INTO user(name,password,address,mail) VALUES(?,?,?,?)");
            
            st.setString(1,udd.getName());
            st.setString(2,udd.getPassword());
            st.setString(3,udd.getMail());
            st.setString(4,udd.getAddres());
            st.executeUpdate();
            System.out.println("insert completed"); 
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
                /**
     * レビューデータの挿入処理を行う。
     * @param udd 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void  ReviewsInsert(SalonDataDTO sdd,UserDataDTO udd) throws SQLException{
            Connection con = null;
            PreparedStatement st = null;
    try{    
            con = DBManager.getConnection();
            
            st =  con.prepareStatement("INSERT INTO  reviews(reviews,evaluation,salonID,userID) VALUES(?,?,?,?)");
            
            
            st.setString(1,sdd.getReviews());
            st.setInt(2,sdd.getEvaluation());
            st.setInt(3,sdd.getSalonID());
            st.setInt(4,udd.getUserID());
            st.executeUpdate();
            System.out.println("insert completed"); 
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
         /**
     * APIのサロンデータの情報をデータベースに格納を行う。
     * @param sdd 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public void salonInsert(SalonDataDTO sdd) throws SQLException{
            Connection con = null;
            PreparedStatement st = null;
    try{
            con = DBManager.getConnection();
               
            st =  con.prepareStatement("INSERT INTO  salon(name,access,accessnavi,address,capacity,catch_copy,close,image,url) VALUES(?,?,?,?,?,?,?,?,?)");
            
            st.setString(1,sdd.getName());
            st.setString(2,sdd.getAccess());
            st.setString(3,sdd.getAccess_navi());
            st.setString(4,sdd.getAddres());
            st.setString(5,sdd.getCapacity());
            st.setString(6,sdd.getCatch_copy());
            st.setString(7,sdd.getClose());
            st.setString(8,sdd.getImage());
            st.setString(9,sdd.getUrl());
            st.executeUpdate();
            System.out.println("insert completed"); 
            
        
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
     /**
     * ログインデータの検索処理を行う。
     * @param udd 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
     public  UserDataDTO login(UserDataDTO udd) throws SQLException{
                   Connection con = null;
            PreparedStatement st = null;
    try{
            con = DBManager.getConnection();
            ResultSet result = null;
            
            st =  con.prepareStatement("SELECT*FROM user WHERE name=? AND password=?");
            st.setString(1,udd.getName());
            st.setString(2,udd.getPassword());
            
            result = st.executeQuery();
            
            if(result.next()){
                
                udd.setUserID(result.getInt("UserID"));
                udd.setName(result.getString("name"));
                udd.setPassword(result.getString("password"));
                udd.setMail(result.getString("mail"));
                udd.setAddres(result.getString("address"));
            }
            System.out.println("login completed"); 
            return udd;
            
                }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
     }
    /**
     * サロンIDによるレビューデータの検索処理を行う。
     * @param sdd 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public ArrayList<SalonDataDTO> searchsalonID(SalonDataDTO sdd) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
String sql = "select*from reviews WHERE salonID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1,sdd.getSalonID());
                    
            ResultSet rs = st.executeQuery();
            ArrayList<SalonDataDTO> ary = new ArrayList<SalonDataDTO>();
            while(rs.next()){
            SalonDataDTO resultrd = new SalonDataDTO();
            resultrd.setEvaluation(rs.getInt("evaluation"));
            resultrd.setReviews(rs.getString("reviews"));
            ary.add(resultrd);
            }
            return ary;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
        /**
     * サロンデータ重複防止の為にAPIで所得した名前による1件のデータの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public SalonDataDTO salonSearchID(SalonDataDTO sdd) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM salon WHERE name = ?";
            
            st =  con.prepareStatement(sql);
            st.setString(1,sdd.getName());
            
            ResultSet rs = st.executeQuery();
            
           
            
            SalonDataDTO searchsdd = new SalonDataDTO();
            
        if(rs.next()){
            searchsdd.setName(rs.getString("name"));
            searchsdd.setAccess(rs.getString("access"));
            searchsdd.setAccess_navi(rs.getString("accessnavi"));
            searchsdd.setAddres(rs.getString("address"));
            searchsdd.setCapacity(rs.getString("capacity"));
            searchsdd.setClose(rs.getString("close"));
            searchsdd.setImage(rs.getString("image"));
            searchsdd.setCatch_copy(rs.getString("catch_copy"));
            searchsdd.setSalonID(rs.getInt("salonID"));
            searchsdd.setUrl(rs.getString("url"));
        }    
            System.out.println("searchByID completed");
            return searchsdd;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    /**
     * サロンIDによるレビューデータの検索処理を行う。
     * @param udd対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public ArrayList<UserDataDTO> myDataSearchID(UserDataDTO udd) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
String sql = "select*from reviews WHERE userID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1,udd.getUserID());
                    
            ResultSet rs = st.executeQuery();
            ArrayList<UserDataDTO> ary = new ArrayList<UserDataDTO>();
            while(rs.next()){
            UserDataDTO resultrd = new UserDataDTO();
            resultrd.setEvaluation(rs.getInt("evaluation"));
            resultrd.setReviews(rs.getString("reviews"));
            ary.add(resultrd);
            }
            return ary;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    


}
