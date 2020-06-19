package com.pet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pet.dto.ContestVO;
import com.pet.dto.paging;
import com.pet.util.DBManager;

public class ContestDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private ContestDAO() {
			
	}
	private static ContestDAO instance = new ContestDAO();
		
	public static ContestDAO getInstance() {
		return instance;
	}
	
	public ArrayList<ContestVO> getContestList(paging paging, String search) {
		ArrayList<ContestVO> list = new ArrayList<ContestVO>();
		String sql = "select * from (select * from (select ROWNUM row_num, contest.* from contest ";
		if(search.equals("0"))
			sql += "order by conseq desc) where row_num >= ?) where row_num <= ?";
		else
			sql += "where conanikind=? order by conseq desc) where row_num >= ?) where row_num <= ?";
		
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
				ContestVO cvo = new ContestVO();
				cvo.setConseq(rs.getInt("conseq"));
				cvo.setConindate(rs.getTimestamp("conindate"));
				cvo.setConid(rs.getString("conid"));
				cvo.setContitle(rs.getString("contitle"));
				cvo.setConcontent(rs.getString("concontent"));
				cvo.setConimg(rs.getString("conimg"));
				cvo.setConlike(rs.getInt("conlike"));
				cvo.setConview(rs.getInt("conview"));
				cvo.setConanikind(rs.getInt("conanikind"));
				list.add(cvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public int getAllCount(String search) {
		int count = 0;
		String sql = "select count(*) from contest";
		if(!search.equals("0"))
			sql += " where conanikind=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			if(!search.equals("0"))
				pstmt.setInt(1, Integer.parseInt(search));
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("count(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return count;
	}
	
	public ArrayList<ContestVO> getContestLikeList(paging paging) {
		ArrayList<ContestVO> list = new ArrayList<ContestVO>();
		String sql = "select * from (select * from (select ROWNUM row_num, contest.* from contest order by conlike desc) "
				+ "where row_num >= ?) where row_num <= ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paging.getStartNum());
			pstmt.setInt(2, paging.getEndNum());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ContestVO cvo = new ContestVO();
				cvo.setConseq(rs.getInt("conseq"));
				cvo.setConindate(rs.getTimestamp("conindate"));
				cvo.setConid(rs.getString("conid"));
				cvo.setContitle(rs.getString("contitle"));
				cvo.setConcontent(rs.getString("concontent"));
				cvo.setConimg(rs.getString("conimg"));
				cvo.setConlike(rs.getInt("conlike"));
				cvo.setConview(rs.getInt("conview"));
				cvo.setConanikind(rs.getInt("conanikind"));
				list.add(cvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public ContestVO getContest(String conseq) {
		ContestVO cvo = null;
		String sql = "select * from contest where conseq=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(conseq));
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cvo = new ContestVO();
				cvo.setConseq(rs.getInt("conseq"));
				cvo.setConindate(rs.getTimestamp("conindate"));
				cvo.setConid(rs.getString("conid"));
				cvo.setContitle(rs.getString("contitle"));
				cvo.setConcontent(rs.getString("concontent"));
				cvo.setConimg(rs.getString("conimg"));
				cvo.setConlike(rs.getInt("conlike"));
				cvo.setConview(rs.getInt("conview"));
				cvo.setConanikind(rs.getInt("conanikind"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return cvo;
	}
	
	public void setConview(String conseq) {
		String sql = "update contest set conview=(conview+1) where conseq=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(conseq));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	public void setConlike(String conseq) {
		String sql = "update contest set conlike=(conlike+1) where conseq=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(conseq));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	public void insertContest(ContestVO cvo) {
		String sql = "insert into contest values(con_seq.nextval, sysdate, ?, ?, ?, 0, ?, 0, ?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cvo.getContitle());
			pstmt.setString(2, cvo.getConcontent());
			pstmt.setString(3, cvo.getConimg());
			pstmt.setString(4, cvo.getConid());
			pstmt.setInt(5, cvo.getConanikind());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	public void deleteContest(String conseq) {
		String sql = "delete from contest where conseq=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(conseq));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void updateContest(ContestVO cvo) {
		String sql = "update contest set contitle=?, concontent=?, conimg=?, conid=?, conanikind=? where conseq=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cvo.getContitle());
			pstmt.setString(2, cvo.getConcontent());
			pstmt.setString(3, cvo.getConimg());
			pstmt.setString(4, cvo.getConid());
			pstmt.setInt(5, cvo.getConanikind());
			pstmt.setInt(6, cvo.getConseq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
}
