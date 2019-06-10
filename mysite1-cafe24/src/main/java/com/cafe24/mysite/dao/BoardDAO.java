package com.cafe24.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.mysite.vo.BoardVO;
import com.cafe24.mysite.vo.UserVO;

public class BoardDAO {
	
	
	public List<BoardVO> getList(){
		List<BoardVO> result = new ArrayList<BoardVO>();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			
			connection = getConnection();
			
			String sql = "select a.no, a.title, a.contents, a.count, a.reg_date, b.no, b.name from board a, user b where a.witer_no = b.no";
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				String contents = rs.getString(3);
				Integer count = rs.getInt(4);
				String regDate = rs.getString(5);
				Long writerNo = rs.getLong(6);
				String writer = rs.getString(7);
				
				BoardVO vo = new BoardVO();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContents(contents);
				vo.setCount(count);
				vo.setRegDate(regDate);
				vo.setWriterNo(writerNo);
				vo.setWriter(writer);
				
				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error: " + e);

		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public Boolean insert(BoardVO vo) {
		Boolean result = false;
		
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = getConnection();
			
			String sql = "insert into user values(null, ?, ?, ?, ?, now())";
			pstmt = connection.prepareStatement(sql);
			
//			pstmt.setString(1, vo.getName());
//			pstmt.setString(2, vo.getEmail());
//			pstmt.setString(3, vo.getPassword());
//			pstmt.setString(4, vo.getGender());
			
			int count = pstmt.executeUpdate();
			result = (count == 1);

		} catch (SQLException e) {
			System.out.println("error: " + e);

		} finally {
			try {
				
				if(pstmt != null) {
					pstmt.close();
				}
				
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	private Connection getConnection() throws SQLException {
		Connection connection = null;
		
		try {
			
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.1.138:3307/webdb";
			connection = DriverManager.getConnection(url, "webdb", "webdb");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}
		
		return connection;
	}
}
