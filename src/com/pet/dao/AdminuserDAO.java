package com.pet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pet.dto.AdminuserVO;
import com.pet.util.DBManager;

public class AdminuserDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private AdminuserDAO() {
	}
	private static AdminuserDAO instance = new AdminuserDAO();
	public static AdminuserDAO getInstance() {
	    	return instance;
	}
	
	public AdminuserVO adminCheck(String adminId) {
		AdminuserVO avo = null;
		String sql = "select * from adminuser where adminid=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				avo = new AdminuserVO();
				avo.setAdminid(rs.getString("adminid"));
				avo.setAdminpwd(rs.getString("adminpwd"));
				avo.setAdminemail(rs.getString("adminemail"));
				avo.setAdminname(rs.getString("adminname"));
				avo.setAdminphone(rs.getString("adminphone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return avo;
	}

}
