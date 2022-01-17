package kr.co.study.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import kr.co.study.vo.boardVO;

@Repository
public class boardDAO {
	 private Connection conn = null;
	   private PreparedStatement pstmt = null;
	   private ResultSet rs = null;

	   public static Connection getConnection() {
	      Connection conn = null;
	      String driver = "com.mysql.cj.jdbc.Driver";
	      String url = "jdbc:mysql://localhost/fstudy";
	      String user = "root";
	      String password = "root";

	      try {
	         Class.forName(driver);
	         conn = DriverManager.getConnection(url, user, password);
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return conn;

	   }

	   public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
	      try {
	         if (rs != null) {
	            rs.close();
	         }
	         if (pstmt != null) {
	            pstmt.close();
	         }
	         if (conn != null) {
	            conn.close();
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         rs = null;
	         pstmt = null;
	         conn = null;
	      }
	   }
	   
	   public String boardSearch = "Select * from board ";
	   
	   public ArrayList<boardVO> boardList() {
		   ArrayList<boardVO>List = new ArrayList<boardVO>();
		   
		   try {
			conn = getConnection();
			pstmt = conn.prepareStatement(boardSearch);
			rs = pstmt.executeQuery();
			while(rs.next()) {
	            List.add(new boardVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6)));
	         }
		} catch (Exception e) {
			e.printStackTrace();
		}
		   return List;
	   }
	   
}
