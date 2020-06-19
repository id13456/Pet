package com.pet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pet.dto.P_outVO;
import com.pet.dto.paging;
import com.pet.util.DBManager;

public class P_outDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private P_outDAO() {
	}
	
	private static P_outDAO instance = new P_outDAO();
	
	public static P_outDAO getInstance() {
	    	return instance;
	}
	
	public ArrayList<P_outVO> getAdoptList(paging paging, String search) {
		ArrayList<P_outVO> list = new ArrayList<P_outVO>();
		String sql = "select * from (select * from (select ROWNUM row_num, p_out.* from p_out ";
		
		if(search.equals("0"))
			sql += "order by outseq desc) where row_num >= ?) where row_num <= ?";
		else
			sql += "where outkind=? order by outseq desc) where row_num >= ?) where row_num <= ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			if(search.equals("0")) {
				pstmt.setInt(1, paging.getStartNum());
				pstmt.setInt(2, paging.getEndNum());
			} else {
				pstmt.setInt(1, Integer.parseInt(search));
				pstmt.setInt(2, paging.getStartNum());
				pstmt.setInt(3, paging.getEndNum());
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				P_outVO pvo = new P_outVO();
				pvo.setOutid(rs.getString("outid"));
				pvo.setOutseq(rs.getInt("outseq"));
				pvo.setOutkind(rs.getInt("outkind"));
				pvo.setOutage(rs.getInt("outage"));
				pvo.setOutgroup(rs.getInt("outgroup"));
				pvo.setOutimg(rs.getString("outimg"));
				pvo.setOutindex(rs.getString("outindex"));
				pvo.setOutmatch(rs.getInt("outmatch"));
				pvo.setOutsex(rs.getInt("outsex"));
				pvo.setOutview(rs.getInt("outview"));
				pvo.setOutarea(rs.getString("outarea"));
				pvo.setOuttitle(rs.getString("outtitle"));
				list.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public P_outVO getAdopt(String outseq) {
		P_outVO pvo = null;
		String sql = "select * from p_out where outseq=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(outseq));
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pvo = new P_outVO();
				pvo.setOutid(rs.getString("outid"));
				pvo.setOutseq(rs.getInt("outseq"));
				pvo.setOutkind(rs.getInt("outkind"));
				pvo.setOutage(rs.getInt("outage"));
				pvo.setOutgroup(rs.getInt("outgroup"));
				pvo.setOutimg(rs.getString("outimg"));
				pvo.setOutindex(rs.getString("outindex"));
				pvo.setOutmatch(rs.getInt("outmatch"));
				pvo.setOutsex(rs.getInt("outsex"));
				pvo.setOutview(rs.getInt("outview"));
				pvo.setOutarea(rs.getString("outarea"));
				pvo.setOuttitle(rs.getString("outtitle"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return pvo;
	}
	
	public ArrayList<P_outVO> getAdoptListMatch(paging paging) {
		ArrayList<P_outVO> list = new ArrayList<P_outVO>();
		String sql = "select * from (select * from (select ROWNUM row_num, p_out.* from p_out where outmatch=1 "
				+ "order by outseq desc) where row_num >= ?) where row_num <= ?";
				
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paging.getStartNum());
			pstmt.setInt(2, paging.getEndNum());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				P_outVO pvo = new P_outVO();
				pvo.setOutid(rs.getString("outid"));
				pvo.setOutseq(rs.getInt("outseq"));
				pvo.setOutkind(rs.getInt("outkind"));
				pvo.setOutage(rs.getInt("outage"));
				pvo.setOutgroup(rs.getInt("outgroup"));
				pvo.setOutimg(rs.getString("outimg"));
				pvo.setOutindex(rs.getString("outindex"));
				pvo.setOutmatch(rs.getInt("outmatch"));
				pvo.setOutsex(rs.getInt("outsex"));
				pvo.setOutview(rs.getInt("outview"));
				pvo.setOutarea(rs.getString("outarea"));
				pvo.setOuttitle(rs.getString("outtitle"));
				list.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public void updateOutview(String outseq) {
		String sql = "update p_out set outview=(outview+1) where outseq=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(outseq));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void insertAdopt(P_outVO pvo) {
		String sql = "insert into p_out(outseq, outgroup, outimg, outkind, 	outage, outsex, outindex, outid, outmatch, 	outview, "
				+ "outarea, outtitle) values(out_seq.nextval, ?, ?, ?, ?, ?, ?, ?, 1, 0, ?, ?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pvo.getOutgroup());
			pstmt.setString(2, pvo.getOutimg());
			pstmt.setInt(3, pvo.getOutkind());
			pstmt.setInt(4, pvo.getOutage());
			pstmt.setInt(5, pvo.getOutsex());
			pstmt.setString(6, pvo.getOutindex());
			pstmt.setString(7, pvo.getOutid());
			pstmt.setString(8, pvo.getOutarea());
			pstmt.setString(9, pvo.getOuttitle());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void updateMatch(String outmatch, String outseq) {
		String sql = "update p_out set outmatch=? where outseq=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(outmatch));
			pstmt.setInt(2, Integer.parseInt(outseq));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	public void deleteAdopt(String outseq) {
		String sql = "delete from p_out where outseq=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(outseq));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	public void updateAdopt(P_outVO pvo) {
		String sql = "update p_out set outgroup=?, outimg=?, outkind=?, outage=?, outsex=?, outindex=?, outarea=?, outtitle=? "
				+ "where outseq=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pvo.getOutgroup());
			pstmt.setString(2, pvo.getOutimg());
			pstmt.setInt(3, pvo.getOutkind());
			pstmt.setInt(4, pvo.getOutage());
			pstmt.setInt(5, pvo.getOutsex());
			pstmt.setString(6, pvo.getOutindex());
			pstmt.setString(7, pvo.getOutarea());
			pstmt.setString(8, pvo.getOuttitle());
			pstmt.setInt(9, pvo.getOutseq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public ArrayList<P_outVO> getAdoptListGroup(paging paging, String group) {
		ArrayList<P_outVO> list = new ArrayList<P_outVO>();
		String sql = "select * from (select * from (select ROWNUM row_num, p_out.* from p_out where outgroup=?"
				+ " order by outseq desc) where row_num >= ?) where row_num <= ?";
				
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(group));
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				P_outVO pvo = new P_outVO();
				pvo.setOutid(rs.getString("outid"));
				pvo.setOutseq(rs.getInt("outseq"));
				pvo.setOutkind(rs.getInt("outkind"));
				pvo.setOutage(rs.getInt("outage"));
				pvo.setOutgroup(rs.getInt("outgroup"));
				pvo.setOutimg(rs.getString("outimg"));
				pvo.setOutindex(rs.getString("outindex"));
				pvo.setOutmatch(rs.getInt("outmatch"));
				pvo.setOutsex(rs.getInt("outsex"));
				pvo.setOutview(rs.getInt("outview"));
				pvo.setOutarea(rs.getString("outarea"));
				pvo.setOuttitle(rs.getString("outtitle"));
				list.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public int getAllCount() {
		int count = 0;
		String sql = "select count(*) from p_out";
		
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
	
	public int getAllCount(String group) {
		int count = 0;
		String sql = "select count(*) from p_out where outgroup=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(group));
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
	
	public int getAllCountSearch(String search) {
		int count = 0;
		String sql = "select count(*) from p_out";
		if(!search.equals("0"))
			sql += " where outkind=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			if(!search.equals("0"))
				pstmt.setInt(1, Integer.parseInt(search));
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
}
