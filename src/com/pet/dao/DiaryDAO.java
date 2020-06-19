package com.pet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.pet.dto.DiaryVO;
import com.pet.util.DBManager;

public class DiaryDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private DiaryDAO(){
		
	}
	private static DiaryDAO instance = new DiaryDAO();

	public static DiaryDAO getInstance() {
		return instance;
	}
	
	public List<DiaryVO> getSchedule(int year, int month, String id) {
		Calendar date = Calendar.getInstance();
		List<DiaryVO> list = new ArrayList<DiaryVO>();
		String s1 = year + "-" + month + "-01 00:00:00.0";
		date.set(year, month+1, 1);
		date.add(Calendar.DATE, -1);
		String s2 = year + "-" + month + "-" + date.get(Calendar.DATE) + " "+"23:59:00.0";
		
		Timestamp t1 = Timestamp.valueOf(s1);
		Timestamp t2 = Timestamp.valueOf(s2);
		
		String sql = "select * from Diary where dindate >= ? and dindate <= ? and did=? order by dindate";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setTimestamp(1, t1);
			pstmt.setTimestamp(2, t2);
			pstmt.setString(3, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				DiaryVO dvo = new DiaryVO();
				dvo.setDcontent(rs.getString("dcontent"));
				dvo.setDid(rs.getString("did"));
				dvo.setDindate(rs.getTimestamp("dindate"));
				dvo.setDseq(rs.getInt("dseq"));
				dvo.setDtitle(rs.getString("dtitle"));
				list.add(dvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public DiaryVO getScheduleView(String dseq) {
		DiaryVO dvo = null;
		String sql = "select * from diary where dseq=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(dseq));
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dvo = new DiaryVO();
				dvo.setDseq(Integer.parseInt(dseq));
				dvo.setDid(rs.getString("did"));
				dvo.setDindate(rs.getTimestamp("dindate"));
				dvo.setDtitle(rs.getString("dtitle"));
				dvo.setDcontent(rs.getString("dcontent"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return dvo;
	}
	
	public void deleteSchedule(String dseq) {
		String sql = "delete from diary where dseq=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(dseq));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void insertDiary(DiaryVO dvo) {
		String sql = "insert into diary values(d_seq.nextval, ?, ?, ?, ?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dvo.getDid());
			pstmt.setTimestamp(2, dvo.getDindate());
			pstmt.setString(3, dvo.getDtitle());
			pstmt.setString(4, dvo.getDcontent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	public void updateDiary(DiaryVO dvo) {
		String sql = "update diary set dindate=?, dtitle=?, dcontent=? where dseq=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setTimestamp(1, dvo.getDindate());
			pstmt.setString(2, dvo.getDtitle());
			pstmt.setString(3, dvo.getDcontent());
			pstmt.setInt(4, dvo.getDseq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
}
