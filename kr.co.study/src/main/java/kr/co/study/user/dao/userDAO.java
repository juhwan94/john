package kr.co.study.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.mysql.cj.protocol.Resultset;

import kr.co.study.user.vo.userVO;

@Repository
public class userDAO {
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
	 public ArrayList<userVO> userList() {
		 ArrayList<userVO> userList = new ArrayList<userVO>();
		 
		 try {
			 conn =getConnection();
			 pstmt = conn.prepareStatement("select * from user");
			 rs = pstmt.executeQuery();
			 while (rs.next()) {
				 userList.add(new userVO(rs.getString(1), rs.getString(2)));
			 }
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		 return userList;
	 }
	 
}
