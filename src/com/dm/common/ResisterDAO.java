package com.dm.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResisterDAO {
	
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
 	
	final String USER_INSERT="insert into membertbl values(?, ?, ?, ?);";
	final String USER_LIST="select * from membertbl;";

	public void insertMember(ResisterDTO mem) throws SQLException {
		conn=JDBCutil.getConnection();
		pstmt=conn.prepareStatement(USER_INSERT);//쿼리를 실행할 statement 객체 생성
		pstmt.setString(1, mem.getMemberid());
		pstmt.setString(2, mem.getPassword());
		pstmt.setString(3, mem.getName());
		pstmt.setString(4, mem.getEmail());
		pstmt.executeUpdate();
		JDBCutil.close(pstmt, conn);
		
	}
	
	public ArrayList<ResisterDTO> selectMemberList() throws SQLException {
		conn=JDBCutil.getConnection();
		pstmt=conn.prepareStatement(USER_LIST);//쿼리를 실행할 statement 객체 생성
		rs=pstmt.executeQuery();
		ArrayList<ResisterDTO> aList = new ArrayList<ResisterDTO>();
		while(rs.next()){
			ResisterDTO rd=new ResisterDTO();			
			rd.setMemberid(rs.getString("memberid"));
			rd.setPassword(rs.getString("password"));
			rd.setName(rs.getString("name"));
			rd.setEmail(rs.getString("email"));
			aList.add(rd);
		}
		JDBCutil.close(pstmt, conn);
		return aList;
		
	}
	
}
