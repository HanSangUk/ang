package DAO;

import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import DB.DBConnection;
import DTO.MemberDTO;

public class MemberDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public void dbConnection() {
		con = DBConnection.getConnection();
	}

	public void dbClose() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void pstmtClose() {
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void rsClose() {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int Join(MemberDTO mDTO) {
		String sql = "INSERT INTO MEMBERS VALUES(?,?,?,?,?,?,?)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mDTO.getMid());
			pstmt.setString(2, mDTO.getMpassword());
			pstmt.setString(3, mDTO.getMname());
			pstmt.setString(4, mDTO.getMgender());
			pstmt.setString(5, mDTO.getMphone());
			pstmt.setString(6, mDTO.getMaddress());
			pstmt.setString(7, mDTO.getMemail());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return result;
	}

	public boolean Login(MemberDTO mDTO) {
		String sql = "SELECT * FROM MEMBERS WHERE MID=? AND MPASSWORD=?";
		boolean boo = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mDTO.getMid());
			pstmt.setString(2, mDTO.getMpassword());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				boo = true;
			} else {
				boo = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return boo;
	}

	public List<MemberDTO> list() {
		String sql = "SELECT * FROM MEMBERS";
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		MemberDTO mDTO = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mDTO = new MemberDTO();
				mDTO.setMid(rs.getString("MID"));
				mDTO.setMpassword(rs.getString("MPASSWORD"));
				mDTO.setMname(rs.getString("MNAME"));
				mDTO.setMgender(rs.getString("MGENDER"));
				mDTO.setMphone(rs.getString("MPHONE"));
				mDTO.setMemail(rs.getString("MEMAIL"));
				list.add(mDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return list;
	}

	public MemberDTO view(String mid) {
		String sql = "SELECT * FROM MEMBERS WHERE MID=?";
		MemberDTO mDTO = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mDTO = new MemberDTO();
				mDTO.setMid(rs.getString("MID"));
				mDTO.setMpassword(rs.getString("MPASSWORD"));
				mDTO.setMname(rs.getString("MNAME"));
				mDTO.setMgender(rs.getString("MGENDER"));
				mDTO.setMphone(rs.getString("MPHONE"));
				mDTO.setMemail(rs.getString("MEMAIL"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return mDTO;
	}

	public MemberDTO update(String mid) {
		String sql = "SELECT * FROM MEMBERS WHERE MID=?";
		MemberDTO mDTO = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mDTO = new MemberDTO();
				mDTO.setMid(rs.getString("MID"));
				mDTO.setMpassword(rs.getString("MPASSWORD"));
				mDTO.setMname(rs.getString("MNAME"));
				mDTO.setMgender(rs.getString("MGENDER"));
				mDTO.setMphone(rs.getString("MPHONE"));
				mDTO.setMemail(rs.getString("MEMAIL"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return mDTO;
	}

	public int updateprecess(MemberDTO mDTO) {
		String sql = "UPDATE MEMBERS SET MNAME=?, MPHONE=?, MEMAIL=? WHERE MID=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mDTO.getMname());
			pstmt.setString(2, mDTO.getMphone());
			pstmt.setString(3, mDTO.getMemail());
			pstmt.setString(4, mDTO.getMid());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return result;
	}

	public MemberDTO delete(String mid) {
		String sql = "SELECT * FROM MEMBERS WHERE MID=?";
		MemberDTO mDTO = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mDTO = new MemberDTO();
				mDTO.setMid(rs.getString("MID"));
				mDTO.setMpassword(rs.getString("MPASSWORD"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return mDTO;
	}

	public int deleteprecess(MemberDTO mDTO) {
		String sql = "DELETE FROM MEMBERS WHERE MID=? and MPASSWORD=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mDTO.getMid());
			pstmt.setString(2, mDTO.getMpassword());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return result;
	}

	public int Delete2(String mid) {
		String sql = "DELETE FROM MEMBERS WHERE MID=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return result;
	}
	
	
	
}
