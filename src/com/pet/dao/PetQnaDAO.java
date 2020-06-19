package com.pet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pet.dto.PetQnaVO;
import com.pet.dto.paging;
import com.pet.util.DBManager;

public class PetQnaDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private PetQnaDAO() {
		
	}
	private static PetQnaDAO instance = new PetQnaDAO();
	
	public static PetQnaDAO getInstance() {
		return instance;
	}
	public ArrayList<PetQnaVO> listPetQna(paging paging, String userid, String rep) {
		ArrayList<PetQnaVO> list = new ArrayList<PetQnaVO>();
		
		String sql = "select * from (select * from (select ROWNUM row_num, petqna.* from petqna "
				+ "where qid=? ";
		if(rep.equals("n"))
			sql += "and qrep like 'y' order by qseq desc) where row_num >= ? ) where row_num <= ?";
		else
			sql += "order by qseq desc) where row_num >= ? ) where row_num <= ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1, userid);
		    pstmt.setInt(2, paging.getStartNum());
		    pstmt.setInt(3, paging.getEndNum());
		    rs = pstmt.executeQuery();
		    while(rs.next()) {
		    	PetQnaVO qvo = new PetQnaVO();
		    	qvo.setQseq(rs.getInt("qseq"));
		    	qvo.setQgroup(rs.getInt("qgroup"));
		    	qvo.setQtitle(rs.getString("qtitle"));
		    	qvo.setQindate(rs.getTimestamp("qindate"));
		    	qvo.setQid(rs.getString("qid"));
		    	qvo.setQrep(rs.getString("qrep"));
		    	list.add(qvo);
		    }
		} catch (Exception e) {
		     e.printStackTrace();
		} finally {
		     DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public PetQnaVO getPetQna(int qseq) {
		PetQnaVO qvo = new PetQnaVO();
		String sql = "select * from petqna where qseq=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qseq);
		    rs = pstmt.executeQuery();
		    if(rs.next()) {
		    	qvo.setQseq(rs.getInt("qseq"));
		    	qvo.setQtitle(rs.getString("qtitle"));
		    	qvo.setQgroup(rs.getInt("qgroup"));
		    	qvo.setQcontent(rs.getString("qcontent"));
		    	qvo.setQindate(rs.getTimestamp("qindate"));
		    	qvo.setQid(rs.getString("qid"));
		    	qvo.setQrep(rs.getString("qrep"));
		    	qvo.setQreply(rs.getString("qreply"));
		    	qvo.setQreid(rs.getString("qreid"));
		    }
		} catch (SQLException e) {
		     e.printStackTrace();
		} finally {
		     DBManager.close(conn, pstmt, rs);
		}
		return qvo;
	}
	
	public void inertQna(PetQnaVO qvo) {
		String sql = "insert into petqna (qseq, qtitle, qgroup, qcontent, qrep, qid) values(q_seq.nextval, ?, ?, ?, ?, ?)";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qvo.getQtitle());
		    pstmt.setInt(2, qvo.getQgroup());
		    pstmt.setString(3, qvo.getQcontent());
		    pstmt.setString(4, qvo.getQrep());
		    pstmt.setString(5, qvo.getQid());
		    pstmt.executeUpdate();  
		} catch (SQLException e) {
	     e.printStackTrace();
		} finally {
	     DBManager.close(conn, pstmt, rs);
		}
	}
	
	public PetQnaVO getUpdate(String qseq) {
		String sql = "select * from petqna where qseq=?";
		PetQnaVO qvo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qseq);
			rs = pstmt.executeQuery();
			if( rs.next() ) {
				qvo = new PetQnaVO();
				qvo.setQseq(rs.getInt("qseq"));
		    	qvo.setQtitle(rs.getString("qtitle"));
		    	qvo.setQgroup(rs.getInt("qgroup"));
		    	qvo.setQcontent(rs.getString("qcontent"));
		    	qvo.setQindate(rs.getTimestamp("qindate"));
		    	qvo.setQid(rs.getString("qid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return qvo;
	}
	
	public void updateQna(PetQnaVO qvo) {
		String sql = "update petqna set qgroup=?, qtitle=?, qcontent=?, qid=? where qseq=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, qvo.getQgroup());
			pstmt.setString(2, qvo.getQtitle());
			pstmt.setString(3, qvo.getQcontent());
			pstmt.setString(4, qvo.getQid());
			pstmt.setInt(5, qvo.getQseq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void deleteQna(String qseq){
		String sql = "delete from petqna where qseq=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(qseq));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	public ArrayList<PetQnaVO> p_helperlistPetQna(paging paging, String id, String my, String rep) {
		ArrayList<PetQnaVO> list = new ArrayList<PetQnaVO>();
		String sql = "select * from (select * from (select ROWNUM row_num, petqna.* from petqna ";
		
		if(my.equals("1"))
			sql += "where qid=? order by qseq desc) where row_num >= ?) where row_num <= ?";
		else if(rep.equals("n"))
			sql += "where qgroup=1 and qrep like 'n' order by qseq desc) where row_num >= ?) "
					+ "where row_num <= ?";
		else 
			sql += "where qgroup=1 or qid=? order by qseq desc) where row_num >= ?) where row_num <= ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			if(my.equals("1")) {
				pstmt.setString(1, id);
				pstmt.setInt(2, paging.getStartNum());
				pstmt.setInt(3, paging.getEndNum());
			} else if(rep.equals("n")) {
				pstmt.setInt(1, paging.getStartNum());
				pstmt.setInt(2, paging.getEndNum());
			} else {
				pstmt.setString(1, id);
				pstmt.setInt(2, paging.getStartNum());
				pstmt.setInt(3, paging.getEndNum());
			}
		    rs = pstmt.executeQuery();
		    while(rs.next()) {
		    	PetQnaVO qvo = new PetQnaVO();
		    	qvo.setQseq(rs.getInt("qseq"));
		    	qvo.setQgroup(rs.getInt("qgroup"));
		    	qvo.setQtitle(rs.getString("qtitle"));
		    	qvo.setQindate(rs.getTimestamp("qindate"));
		    	qvo.setQid(rs.getString("qid"));
		    	qvo.setQrep(rs.getString("qrep"));
		    	list.add(qvo);
		    }
		} catch (SQLException e) {
		     e.printStackTrace();
		} finally {
		     DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public ArrayList<PetQnaVO> AdminlistPetQna(paging paging, String rep) {
		ArrayList<PetQnaVO> list = new ArrayList<PetQnaVO>();
		String sql = "select * from (select * from (select ROWNUM row_num, petqna.* from petqna "
				+ "where qgroup=2 ";
		if(rep.equals("n"))
			sql += "and qrep like 'n' order by qseq desc) where row_num >= ?) where row_num <= ?";
		else 
			sql += "order by qseq desc) where row_num >= ?) where row_num <= ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paging.getStartNum());
			pstmt.setInt(2, paging.getEndNum());
		    rs = pstmt.executeQuery();
		    while(rs.next()) {
		    	PetQnaVO qvo = new PetQnaVO();
		    	qvo.setQseq(rs.getInt("qseq"));
		    	qvo.setQgroup(rs.getInt("qgroup"));
		    	qvo.setQtitle(rs.getString("qtitle"));
		    	qvo.setQindate(rs.getTimestamp("qindate"));
		    	qvo.setQid(rs.getString("qid"));
		    	qvo.setQrep(rs.getString("qrep"));
		    	list.add(qvo);
		    }
		} catch (SQLException e) {
		     e.printStackTrace();
		} finally {
		     DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public PetQnaVO getHelperUpdate(String qseq) {
		String sql = "select * from petqna where qseq=?";
		PetQnaVO qvo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qseq);
			rs = pstmt.executeQuery();
			
			if( rs.next() ) {
				qvo = new PetQnaVO();
				qvo.setQseq(rs.getInt("qseq"));
		    	qvo.setQtitle(rs.getString("qtitle"));
		    	qvo.setQgroup(rs.getInt("qgroup"));
		    	qvo.setQcontent(rs.getString("qcontent"));
		    	qvo.setQindate(rs.getTimestamp("qindate"));
		    	qvo.setQid(rs.getString("qid"));
		    	qvo.setQreply(rs.getString("qreply"));
		    	qvo.setQreid(rs.getString("reid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return qvo;
	}
	
	public void qreplyQna(PetQnaVO qvo) {
		String sql = "update petqna set qreply=?, qrep='y', qreid=? where qseq=?";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, qvo.getQreply());
			pstmt.setString(2, qvo.getQreid());
			pstmt.setInt(3, qvo.getQseq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public int getAllCountUser(String id) {
		int count = 0;
		String sql = "select count(*) from petqna where qid=? order by qseq desc";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
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
	
	public int getAllCountHelper() {
		int count = 0;
		String sql = "select count(*) from petqna where qgroup=1 order by qseq desc";
		
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
	
	public int getAllCountAdmin() {
		int count = 0;
		String sql = "select count(*) from petqna where qgroup=2 order by qseq desc";
		
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
}