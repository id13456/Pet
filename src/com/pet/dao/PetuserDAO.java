package com.pet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pet.dto.PetuserVO;
import com.pet.util.DBManager;

public class PetuserDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private PetuserDAO() {
		
	}
	private static PetuserDAO instance = new PetuserDAO();
	public static PetuserDAO getInstance() {
		return instance;
	}
	
	public PetuserVO getPetuser(String userid){
		PetuserVO pvo = null;
		String sql = "select * from petuser where userid=?";     
	    try {
	      conn = DBManager.getConnection();
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, userid);
	      rs = pstmt.executeQuery();
	      if(rs.next()){
	        pvo = new PetuserVO();
	        pvo.setUserid(userid);
	        pvo.setUserpwd(rs.getString("userpwd"));
	        pvo.setUsername(rs.getString("username"));
	        pvo.setUserphone(rs.getString("userphone"));
	        pvo.setUseremail(rs.getString("useremail"));
	        pvo.setUser_zip_num(rs.getString("user_zip_num"));
	        pvo.setUser_address(rs.getString("user_address"));
	        pvo.setUser_pet1(rs.getInt("user_pet1"));
	        pvo.setUser_pet2(rs.getInt("user_pet2"));
	        pvo.setUser_img(rs.getString("user_img"));
	        pvo.setHelperid(rs.getString("helperid"));
	      } 
	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      DBManager.close(conn, pstmt, rs);
	    }
	    return pvo;
	}
	
	public void updateUser(PetuserVO pvo) {
		String sql = "update petuser set userpwd=?, userphone=?, useremail=?, user_zip_num=?, user_address=?, user_pet1=?, "
				+ "user_pet2=?, user_img=? where userid=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pvo.getUserpwd());
			pstmt.setString(2, pvo.getUserphone());
			pstmt.setString(3, pvo.getUseremail());
			pstmt.setString(4, pvo.getUser_zip_num());
			pstmt.setString(5, pvo.getUser_address());
			pstmt.setInt(6, pvo.getUser_pet1());
			pstmt.setInt(7, pvo.getUser_pet2());
			pstmt.setString(8, pvo.getUser_img());
			pstmt.setString(9, pvo.getUserid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	public ArrayList<PetuserVO> ListUser() {
		ArrayList<PetuserVO> list = new ArrayList<PetuserVO>();
		String sql = "select * from Petuser ";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			 while (rs.next()) {
				PetuserVO pvo = new PetuserVO();
				pvo.setUserid(rs.getString("userid"));
				pvo.setUsername(rs.getString("username"));
				pvo.setUserphone(rs.getString("userphone"));
				pvo.setUseremail(rs.getString("useremail"));
				pvo.setUser_zip_num(rs.getString("user_zip_num"));
				pvo.setUser_address(rs.getString("user_address"));
				pvo.setUser_pet1(rs.getInt("user_pet1"));
				pvo.setUser_pet2(rs.getInt("user_pet2"));
				pvo.setHelperid(rs.getString("helperid"));
				list.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}

	public void deleteCart(String userid) {
		String sql = "delete petuser where userid=?";  
	    try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, userid);
		    pstmt.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();
		} finally {DBManager.close(conn, pstmt);}
	}
	
	public PetuserVO getMemberByphone(String phone) {
		PetuserVO pvo = null;
		String sql = "select username from petuser where userphone=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phone);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pvo = new PetuserVO();
				pvo.setUsername(rs.getString("username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return pvo;
	}
	
	public int confirmID(String id) {
		int message = -1;
		String sql = "select * from petuser where userid=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				message = 1;
			} else
				message = -1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return message;
	}
	
	public void insertUser(PetuserVO pvo) {
		String sql = null;
		
		if(pvo.getUser_pet2() == null)
			sql = "insert into petuser(userid, userpwd, username, userphone, useremail, user_zip_num, "
					+ "user_address, user_pet1, user_img) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		else
			sql = "insert into petuser(userid, userpwd, username, userphone, useremail, user_zip_num, "
					+ "user_address, user_pet1, user_pet2, user_img) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pvo.getUserid());
			pstmt.setString(2, pvo.getUserpwd());
			pstmt.setString(3, pvo.getUsername());
			pstmt.setString(4, pvo.getUserphone());
			pstmt.setString(5, pvo.getUseremail());
			pstmt.setString(6, pvo.getUser_zip_num());
			pstmt.setString(7, pvo.getUser_address());
			pstmt.setInt(8, pvo.getUser_pet1());
			if(pvo.getUser_pet2() == null)
				pstmt.setString(9, pvo.getUser_img());
			else {
				pstmt.setInt(9, pvo.getUser_pet2());
				pstmt.setString(10, pvo.getUser_img());
			}
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void matchHelper(String helperid, String userid) {
		String sql = "update petuser set helperid=? where userid=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, helperid);
			pstmt.setString(2, userid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void removeHelper(String userid) {
		String sql = "update petuser set helperid=null where userid=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
}
