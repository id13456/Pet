package com.pet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pet.dto.P_helperVO;
import com.pet.dto.PetuserVO;
import com.pet.dto.paging;
import com.pet.util.DBManager;

public class P_helperDAO {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	private P_helperDAO() {
		
	}
	private static P_helperDAO instance = new P_helperDAO();
	
	public static P_helperDAO getInstance() {
		return instance;
	}
	
	public ArrayList<P_helperVO> getHelperList(paging paging) {
		ArrayList<P_helperVO> list = new ArrayList<P_helperVO>();
		String sql = "select * from (select * from (select ROWNUM row_num, p_helper.* from p_helper) where row_num >= ?) "
				+ "where row_num <= ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, paging.getStartNum());
			pstmt.setInt(2, paging.getEndNum());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				P_helperVO pvo = new P_helperVO();
				pvo.setId(rs.getString("id"));
				pvo.setPwd(rs.getString("pwd")); 
				pvo.setName(rs.getString("name")); 
				pvo.setSex(rs.getInt("sex")); 
				pvo.setPhone(rs.getString("phone")); 
				pvo.setEmail(rs.getString("email")); 
				pvo.setHgroup(rs.getInt("hgroup"));
				pvo.setHos_name(rs.getString("hos_name"));
				pvo.setHos_address(rs.getString("hos_address")); 
				pvo.setHelper_img(rs.getString("helper_img"));
				pvo.setHelper_index(rs.getString("helper_index"));
				pvo.setHelper_kind1(rs.getString("helper_kind1"));
				pvo.setHelper_kind2(rs.getString("helper_kind2")); 
				pvo.setHelper_kind3(rs.getString("helper_kind3"));
				pvo.setHelper_kind4(rs.getString("helper_kind4"));
				pvo.setHelper_kind5(rs.getString("helper_kind5"));
				list.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public P_helperVO getHelper(String id) {
		P_helperVO pvo = null;
		String sql = "select * from p_helper where id=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				pvo = new P_helperVO();
				pvo.setId(rs.getString("id"));
				pvo.setPwd(rs.getString("pwd")); 
				pvo.setName(rs.getString("name")); 
				pvo.setSex(rs.getInt("sex")); 
				pvo.setPhone(rs.getString("phone")); 
				pvo.setEmail(rs.getString("email")); 
				pvo.setHgroup(rs.getInt("hgroup"));
				pvo.setHos_name(rs.getString("hos_name"));
				pvo.setHos_address(rs.getString("hos_address")); 
				pvo.setHelper_img(rs.getString("helper_img"));
				pvo.setHelper_index(rs.getString("helper_index"));
				pvo.setHelper_kind1(rs.getString("helper_kind1"));
				pvo.setHelper_kind2(rs.getString("helper_kind2")); 
				pvo.setHelper_kind3(rs.getString("helper_kind3"));
				pvo.setHelper_kind4(rs.getString("helper_kind4"));
				pvo.setHelper_kind5(rs.getString("helper_kind5"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return pvo;
	}
	
	public ArrayList<P_helperVO> getHelperSearchList(paging paging, String search) {
		ArrayList<P_helperVO> list = new ArrayList<P_helperVO>();
		String sql = "select * from (select * from (select ROWNUM row_num, p_helper.* from p_helper "
				+ "where hos_address like '%'||?||'%') where row_num >= ?) where row_num <= ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				P_helperVO pvo = new P_helperVO();
				pvo.setId(rs.getString("id"));
				pvo.setPwd(rs.getString("pwd")); 
				pvo.setName(rs.getString("name")); 
				pvo.setSex(rs.getInt("sex")); 
				pvo.setPhone(rs.getString("phone")); 
				pvo.setEmail(rs.getString("email")); 
				pvo.setHgroup(rs.getInt("hgroup"));
				pvo.setHos_name(rs.getString("hos_name"));
				pvo.setHos_address(rs.getString("hos_address")); 
				pvo.setHelper_img(rs.getString("helper_img"));
				pvo.setHelper_index(rs.getString("helper_index"));
				pvo.setHelper_kind1(rs.getString("helper_kind1"));
				pvo.setHelper_kind2(rs.getString("helper_kind2")); 
				pvo.setHelper_kind3(rs.getString("helper_kind3"));
				pvo.setHelper_kind4(rs.getString("helper_kind4"));
				pvo.setHelper_kind5(rs.getString("helper_kind5"));
				list.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public ArrayList<P_helperVO> getHelperSexList(paging paging, String sex) {
		ArrayList<P_helperVO> list = new ArrayList<P_helperVO>();
		String sql = "select * from (select * from (select ROWNUM row_num, p_helper.* from p_helper where sex=?) "
				+ "where row_num >= ?) where row_num <= ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(sex));
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				P_helperVO pvo = new P_helperVO();
				pvo.setId(rs.getString("id"));
				pvo.setPwd(rs.getString("pwd")); 
				pvo.setName(rs.getString("name")); 
				pvo.setSex(rs.getInt("sex")); 
				pvo.setPhone(rs.getString("phone")); 
				pvo.setEmail(rs.getString("email")); 
				pvo.setHgroup(rs.getInt("hgroup"));
				pvo.setHos_name(rs.getString("hos_name"));
				pvo.setHos_address(rs.getString("hos_address")); 
				pvo.setHelper_img(rs.getString("helper_img"));
				pvo.setHelper_index(rs.getString("helper_index"));
				pvo.setHelper_kind1(rs.getString("helper_kind1"));
				pvo.setHelper_kind2(rs.getString("helper_kind2")); 
				pvo.setHelper_kind3(rs.getString("helper_kind3"));
				pvo.setHelper_kind4(rs.getString("helper_kind4"));
				pvo.setHelper_kind5(rs.getString("helper_kind5"));
				list.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public ArrayList<P_helperVO> getHelperGroupList(paging paging, String group) {
		ArrayList<P_helperVO> list = new ArrayList<P_helperVO>();
		String sql = "select * from (select * from (select ROWNUM row_num, p_helper.* from p_helper where hgroup=?) "
				+ "where row_num >= ?) where row_num <= ?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(group));
			pstmt.setInt(2, paging.getStartNum());
			pstmt.setInt(3, paging.getEndNum());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				P_helperVO pvo = new P_helperVO();
				pvo.setId(rs.getString("id"));
				pvo.setPwd(rs.getString("pwd")); 
				pvo.setName(rs.getString("name")); 
				pvo.setSex(rs.getInt("sex")); 
				pvo.setPhone(rs.getString("phone")); 
				pvo.setEmail(rs.getString("email")); 
				pvo.setHgroup(rs.getInt("hgroup"));
				pvo.setHos_name(rs.getString("hos_name"));
				pvo.setHos_address(rs.getString("hos_address")); 
				pvo.setHelper_img(rs.getString("helper_img"));
				pvo.setHelper_index(rs.getString("helper_index"));
				pvo.setHelper_kind1(rs.getString("helper_kind1"));
				pvo.setHelper_kind2(rs.getString("helper_kind2")); 
				pvo.setHelper_kind3(rs.getString("helper_kind3"));
				pvo.setHelper_kind4(rs.getString("helper_kind4"));
				pvo.setHelper_kind5(rs.getString("helper_kind5"));
				list.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public void deleteHelper(String id) {
		String sql = "delete from p_helper where id=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	public void insertHelper(P_helperVO pvo) {
		String sql = "insert into p_helper values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pvo.getId()); 
			pstmt.setString(2, pvo.getPwd());
			pstmt.setString(3, pvo.getName());
			pstmt.setInt(4, pvo.getSex());
			pstmt.setString(5, pvo.getPhone()); 
			pstmt.setString(6, pvo.getEmail());
			pstmt.setInt(7, pvo.getHgroup());
			pstmt.setString(8, pvo.getHos_name());
			pstmt.setString(9, pvo.getHos_address());
			pstmt.setString(10, pvo.getHelper_img());
			pstmt.setString(11, pvo.getHelper_index()); 
			pstmt.setString(12, pvo.getHelper_kind1());
			pstmt.setString(13, pvo.getHelper_kind2());
			pstmt.setString(14, pvo.getHelper_kind3());
			pstmt.setString(15, pvo.getHelper_kind4());
			pstmt.setString(16, pvo.getHelper_kind5());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void updateHelper(P_helperVO pvo) {
		String sql = "update p_helper set pwd=?, phone=?, email=?, hos_name=?, hos_address=?, helper_kind1=?, "
				+ "helper_kind2=?, helper_kind3=?, helper_kind4=?, helper_kind5=?, helper_index=?, helper_img=? "
				+ "where id=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pvo.getPwd());
			pstmt.setString(2, pvo.getPhone()); 
			pstmt.setString(3, pvo.getEmail());
			pstmt.setString(4, pvo.getHos_name());
			pstmt.setString(5, pvo.getHos_address());			
			pstmt.setString(6, pvo.getHelper_kind1());
			pstmt.setString(7, pvo.getHelper_kind2());
			pstmt.setString(8, pvo.getHelper_kind3());
			pstmt.setString(9, pvo.getHelper_kind4());
			pstmt.setString(10, pvo.getHelper_kind5());
			pstmt.setString(11, pvo.getHelper_index()); 
			pstmt.setString(12, pvo.getHelper_img());
			pstmt.setString(13, pvo.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public P_helperVO getP_helper(String id) {
		P_helperVO hvo = null;
		String sql = "select * from p_helper where id=?";     
	    try {
	      conn = DBManager.getConnection();
	      pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, id);
	      rs = pstmt.executeQuery();
	      if(rs.next()){
	        hvo = new P_helperVO();
	        hvo.setId(id);
	        hvo.setPwd(rs.getString("pwd"));
	        hvo.setName(rs.getString("name"));
	        hvo.setSex(rs.getInt("sex"));
	        hvo.setPhone(rs.getString("phone"));
	        hvo.setEmail(rs.getString("email"));
	        hvo.setHgroup(rs.getInt("hgroup"));
	        hvo.setHos_name(rs.getString("hos_name"));
	        hvo.setHos_address(rs.getString("hos_address"));
	        hvo.setHelper_img(rs.getString("helper_img"));
	        hvo.setHelper_index(rs.getString("helper_index"));
	        hvo.setHelper_kind1(rs.getString("helper_kind1"));
	        hvo.setHelper_kind2(rs.getString("helper_kind2"));
	        hvo.setHelper_kind3(rs.getString("helper_kind3"));
	        hvo.setHelper_kind4(rs.getString("helper_kind4"));
	        hvo.setHelper_kind5(rs.getString("helper_kind5"));
	      } 

	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      DBManager.close(conn, pstmt, rs);
	    }
	    return hvo;
	}
	
	public int getAllCount() {
		int count = 0;
		String sql = "select count(*) from p_helper";
		
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
	
	public int getAllCountSearch(String area_search) {
		int count = 0;
		String sql = "select count(*) from p_helper where hos_address like '%'||?||'%'";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, area_search);
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
	
	public int getAllCountSex(String sex) {
		int count = 0;
		String sql = "select count(*) from p_helper where sex=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sex);
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
	
	public int getAllCountGroup(String group) {
		int count = 0;
		String sql = "select count(*) from p_helper where hgroup=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, group);
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
	
	public ArrayList<PetuserVO> getMatchuserList(String id) {
		ArrayList<PetuserVO> list = new ArrayList<PetuserVO>();
		String sql = "select * from petuser where helperid=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
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
				System.out.println(pvo.getUserid());
				list.add(pvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return list;
	}
}
