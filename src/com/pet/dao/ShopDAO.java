package com.pet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pet.dto.MatchVO;
import com.pet.dto.ShopVO;
import com.pet.dto.paging;
import com.pet.util.DBManager;

public class ShopDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private ShopDAO() {
	}
	private static ShopDAO instance = new ShopDAO();
	public static ShopDAO getInstance() {
	    	return instance;
	}
	
	public ArrayList<ShopVO> getShopList(paging paging, String s_select, String search) {
		ArrayList<ShopVO> list = new ArrayList<ShopVO>();
		String sql = "select * from (select * from (select ROWNUM row_num, shop.* from shop ";
		int startNum = paging.getStartNum();
		int endNum = paging.getEndNum();
		if(s_select.equals("area"))
			sql += "where exarea like '%'||?||'%' order by exseq) where row_num >= ?) where row_num <= ?";
		else if(s_select.equals("product"))
			sql += "where extitle like '%'||?||'%' order by exseq) where row_num >= ?) where row_num <= ?";
		else
			sql += "order by exseq) where row_num >= ?) where row_num <= ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			if(s_select.equals("area") || s_select.equals("product")) {
				pstmt.setString(1, search);
				pstmt.setInt(2, startNum);
				pstmt.setInt(3, endNum);
			} else {
				pstmt.setInt(1, startNum);
				pstmt.setInt(2, endNum);
			}
			rs = pstmt.executeQuery();

			while(rs.next()) {
				ShopVO svo = new ShopVO();
				svo.setExseq(rs.getInt("exseq"));
				svo.setExid(rs.getString("exid"));
				svo.setExindate(rs.getTimestamp("exindate"));
				svo.setExtitle(rs.getString("extitle"));
				svo.setExcontent(rs.getString("excontent"));
				svo.setEximg(rs.getString("eximg"));
				svo.setExmatch(rs.getInt("exmatch"));
				svo.setExview(rs.getInt("exview"));
				svo.setExarea(rs.getString("exarea"));
				list.add(svo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public void insertShop(ShopVO svo) {
		String sql = "insert into shop(exseq, exid, extitle, excontent, eximg, exarea, exview) values(ex_seq.nextval, ?, ?, ?, ?, ?, 0)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, svo.getExid());
			pstmt.setString(2, svo.getExtitle());
			pstmt.setString(3, svo.getExcontent());
			pstmt.setString(4, svo.getEximg());
			pstmt.setString(5, svo.getExarea());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	public ShopVO getProduct(String exseq) {
		ShopVO svo = null;
		String sql = "select * from shop where exseq=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(exseq));
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				svo = new ShopVO();
				svo.setExseq(Integer.parseInt(exseq));
				svo.setExid(rs.getString("exid"));
				svo.setExarea(rs.getString("exarea"));
				svo.setExindate(rs.getTimestamp("exindate"));
				svo.setExtitle(rs.getString("extitle"));
				svo.setExcontent(rs.getString("excontent"));
				svo.setEximg(rs.getString("eximg"));
				svo.setExmatch(rs.getInt("exmatch"));
				svo.setExview(rs.getInt("exview"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return svo;
	}
	
	public void updateExview(String exseq) {
		String sql = "update shop set exview=(exview+1) where exseq=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(exseq));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	public void updateExmatch(String exmatch, String exseq, String id) {
		String sql = "update shop set exmatch=?, exmatchid=? where exseq=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(exmatch));
			pstmt.setString(2, id);
			pstmt.setInt(3, Integer.parseInt(exseq));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	public ArrayList<ShopVO> getShopListMatch(paging paging) {
		ArrayList<ShopVO> list = new ArrayList<ShopVO>();
		String sql = "select * from (select * from (select ROWNUM row_num, shop.* from shop where exmatch = 1 "
						+ "order by exseq desc) where row_num >= ?) where row_num <= ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paging.getStartNum());
			pstmt.setInt(2, paging.getEndNum());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ShopVO svo = new ShopVO();
				svo.setExseq(rs.getInt("exseq"));
				svo.setExid(rs.getString("exid"));
				svo.setExindate(rs.getTimestamp("exindate"));
				svo.setExtitle(rs.getString("extitle"));
				svo.setExcontent(rs.getString("excontent"));
				svo.setEximg(rs.getString("eximg"));
				svo.setExmatch(rs.getInt("exmatch"));
				svo.setExview(rs.getInt("exview"));
				svo.setExarea(rs.getString("exarea"));
				list.add(svo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public void deleteShop(String exseq) {
		String sql = "delete from shop where exseq=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(exseq));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	public void updateProduct(ShopVO svo) {
		String sql = "update shop set extitle=?, excontent=?, eximg=?, exarea=? where exseq=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, svo.getExtitle());
			pstmt.setString(2, svo.getExcontent());
			pstmt.setString(3, svo.getEximg());
			pstmt.setString(4, svo.getExarea());
			pstmt.setInt(5, svo.getExseq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	public int getAllCount(String s_select, String search) {
		int count = 0;
		String sql = "select count(*) from shop";
		if(s_select.equals("area"))
			sql += "where exarea like '%'||?||'%'";
		else if(s_select.equals("product"))
			sql += "where extitle like '%'||?||'%'";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			if(s_select.equals("area") || s_select.equals("product")) 
				pstmt.setString(1, search);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return count;
	}
	
	public int getAllCount() {
		int count = 0;
		String sql = "select count(*) from shop";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return count;
	}
	
	public ArrayList<MatchVO> getMatchList(String id) {
		ArrayList<MatchVO> list = new ArrayList<MatchVO>();
		String sql = "select s.exseq as exseq, s.extitle as extitle, p.userid as exmatchid,"
				+ " p.userphone as userphone, p.useremail as useremail from shop s, petuser p " 
				+ "where s.exmatchid = p.userid and exmatch=2 and s.exid=? ";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MatchVO mvo = new MatchVO();
				mvo.setExseq(rs.getInt("exseq"));
				mvo.setExtitle(rs.getString("extitle"));
				mvo.setExmatchid(rs.getString("exmatchid"));
				mvo.setUserphone(rs.getString("userphone"));
				mvo.setUseremail(rs.getString("useremail"));
				list.add(mvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public void matchCancle(String exseq) {
		String sql = "update shop set exmatch=1 where exseq=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(exseq));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
}
