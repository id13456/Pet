package com.pet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pet.dto.BorderVO;
import com.pet.dto.paging;
import com.pet.util.DBManager;

public class BorderDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private BorderDAO() {
		
	}
	private static BorderDAO instance = new BorderDAO();
		
	public static BorderDAO getInstance() {
		return instance;
	}
	public ArrayList<BorderVO> listPetBoard(paging paging, String search) {
		String sql = null;
		
		if(search.equals("0"))
			sql = "select * from (select * from (select ROWNUM row_num, border.* from border "
					+ "order by bseq desc) where row_num>=?) where row_num <= ?";
		else 
			sql = "select * from (select * from (select ROWNUM row_num, border.* from border where bgroup=? "
					+ "order by bseq desc) where row_num>=?) where row_num <= ?";
		
		ArrayList<BorderVO> list = new ArrayList<BorderVO>();
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
		    	BorderVO bvo = new BorderVO();
		    	bvo.setBseq(rs.getInt("bseq"));
		    	bvo.setBgroup(rs.getInt("bgroup"));
		    	bvo.setBtitle(rs.getString("btitle"));
		    	bvo.setBindate(rs.getTimestamp("bindate"));
		    	bvo.setBid(rs.getString("bid"));
		    	list.add(bvo);
		    }
		} catch (SQLException e) {
		     e.printStackTrace();
		} finally {
		     DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public void inertBoard(BorderVO bvo, String userid) {
		String sql = "insert into border (bseq, btitle, bgroup, bcontent, bid) values(b_seq.nextval, ?, ?, ?, ?)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getBtitle());
		    pstmt.setInt(2, bvo.getBgroup());
		    pstmt.setString(3, bvo.getBcontent());
		    pstmt.setString(4, userid);
		    pstmt.executeUpdate();  
		} catch (SQLException e) {
	     e.printStackTrace();
		} finally {
	     DBManager.close(conn, pstmt, rs);
		}
	}
	
	public BorderVO getBoard(String bseq) {
		String sql = "select * from border where bseq=?";
		
		BorderVO bvo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bseq);
		    rs = pstmt.executeQuery();
		    if(rs.next()) {
		    	bvo = new BorderVO();
		    	bvo.setBseq(rs.getInt("bseq"));
		    	bvo.setBtitle(rs.getString("btitle"));
		    	bvo.setBgroup(rs.getInt("bgroup"));
		    	bvo.setBcontent(rs.getString("bcontent"));
		    	bvo.setBindate(rs.getTimestamp("bindate"));
		    	bvo.setBid(rs.getString("bid"));
		    }
		} catch (SQLException e) {
		     e.printStackTrace();
		} finally {
		     DBManager.close(conn, pstmt, rs);
		}
		return bvo;
	}
	
	public void deleteBoard(String bseq){
		String sql = "delete from border where bseq=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(bseq));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public BorderVO getUpdate(String bseq) {
		String sql = "select * from border where bseq=?";
		BorderVO bvo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bseq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bvo = new BorderVO();
				bvo.setBseq(rs.getInt("bseq"));
		    	bvo.setBtitle(rs.getString("btitle"));
		    	bvo.setBgroup(rs.getInt("bgroup"));
		    	bvo.setBcontent(rs.getString("bcontent"));
		    	bvo.setBindate(rs.getTimestamp("bindate"));
		    	bvo.setBid(rs.getString("bid"));
			}
		} catch (SQLException e) {
		     e.printStackTrace();
		} finally {
		     DBManager.close(conn, pstmt, rs);
		}
		return bvo;
	}
	
	public void updateBoard(BorderVO bvo) {
		String sql = "update border set bgroup=?, btitle=?, bcontent=?, bid=? where bseq=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bvo.getBgroup());
			pstmt.setString(2, bvo.getBtitle());
			pstmt.setString(3, bvo.getBcontent());
			pstmt.setString(4, bvo.getBid());
			pstmt.setInt(5, bvo.getBseq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void inertP_helperBoard(BorderVO bvo, String id) {
		String sql = "insert into border (bseq, btitle, bgroup, bcontent, bid) values(b_seq.nextval, ?, ?, ?, ?)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getBtitle());
		    pstmt.setInt(2, bvo.getBgroup());
		    pstmt.setString(3, bvo.getBcontent());
		    pstmt.setString(4, id);
		    pstmt.executeUpdate();  
		} catch (SQLException e) {
	     e.printStackTrace();
		} finally {
	     DBManager.close(conn, pstmt, rs);
		}
	}
	
	public void updateP_helper_Board(BorderVO bvo) {
		String sql = "Update border set btitle=?, bgroup=?, bcontent=? where bseq=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bvo.getBtitle());
			pstmt.setInt(2, bvo.getBgroup());
			pstmt.setString(3, bvo.getBcontent());
			pstmt.setInt(4, bvo.getBseq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public int getAllCountSearch(String search) {
		int count = 0;
		String sql = "select count(*) from border";
		if(!search.equals("0"))
			sql += " where bgroup=?";
		
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