package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import db.DBConnection;
import dto.BoardDTO;

public class BoardDAO {
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

	public int write(HttpServletRequest request) {
		String sql = "INSERT INTO BOARD(BNUMBER, BWRITER, BTITLE, BCONTENTS, BDATE, BHITS) VALUES(BOARD_SEQ.nextval,?,?,?,SYSDATE,0)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("bwriter"));
			pstmt.setString(2, request.getParameter("btitle"));
			pstmt.setString(3, request.getParameter("bcontents"));
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			
			pstmtClose();
		}
		return result;
	}

	public List<BoardDTO> daolist() {
		String sql = "SELECT * FROM BOARD ORDER BY BNUMBER DESC";
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		BoardDTO bDTO = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bDTO = new BoardDTO();
				bDTO.setBnumber(rs.getInt("BNUMBER"));
				bDTO.setBtitle(rs.getString("BTITLE"));
				bDTO.setBhits(rs.getInt("BHITS"));
				list.add(bDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return list;
	}

	public BoardDTO boardView(int bnumber) {
		String sql = "SELECT * FROM BOARD WHERE BNUMBER=?";
		BoardDTO bDTO = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bnumber);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bDTO = new BoardDTO();
				bDTO.setBnumber(rs.getInt("BNUMBER"));
				bDTO.setBwriter(rs.getString("BWRITER"));
				bDTO.setBtitle(rs.getString("BTITLE"));
				bDTO.setBcontents(rs.getString("BCONTENTS"));
				bDTO.setBdate(rs.getDate("BDATE"));
				bDTO.setBhits(rs.getInt("BHITS"));
				bDTO.setBfilename(rs.getString("BFILENAME"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return bDTO;
	}

	public void hitsup(int to) {
		String sql = "UPDATE BOARD SET BHITS=BHITS+1 WHERE BNUMBER=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, to);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		
	}

	public BoardDTO Update(int bnumber) {
		String sql = "SELECT * FROM BOARD WHERE BNUMBER=?";
		BoardDTO bDTO = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bnumber);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bDTO = new BoardDTO();
				bDTO.setBnumber(rs.getInt("BNUMBER"));
				bDTO.setBwriter(rs.getString("BWRITER"));
				bDTO.setBtitle(rs.getString("BTITLE"));
				bDTO.setBcontents(rs.getString("BCONTENTS"));
				bDTO.setBdate(rs.getDate("BDATE"));
				bDTO.setBhits(rs.getInt("BHITS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return bDTO;
	}

	public int UpdateProcess(BoardDTO bDTO) {
		String sql = "UPDATE BOARD SET BWRITER=?, BTITLE=?, BCONTENTS=? WHERE BNUMBER=?";
		int result = 0;
		int bnumber = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bDTO.getBwriter());
			pstmt.setString(2, bDTO.getBtitle());
			pstmt.setString(3, bDTO.getBcontents());
			pstmt.setInt(4, bDTO.getBnumber());
			result = pstmt.executeUpdate();
			if(result>0) {
				bnumber = bDTO.getBnumber();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return bnumber;
	}

	public int Delete(int bnumber) {
		String sql = "DELETE FROM BOARD WHERE BNUMBER=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bnumber);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return result;
	}

	public List<BoardDTO> serch(String btitle) {
		String sql = "SELECT * FROM BOARD WHERE BTITLE LIKE ?";
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		BoardDTO bDTO = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+btitle+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bDTO = new BoardDTO();
				bDTO.setBnumber(rs.getInt("BNUMBER"));
				bDTO.setBtitle(rs.getString("BTITLE"));
				bDTO.setBhits(rs.getInt("BHITS"));
				list.add(bDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return list;
	}

	public int boardWriteFile(BoardDTO bDTO) {
		String sql = "INSERT INTO BOARD(BNUMBER, BWRITER, BTITLE, BCONTENTS, BDATE, BHITS, BFILENAME) VALUES(BOARD_SEQ.nextval,?,?,?,SYSDATE,0,?)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bDTO.getBwriter());
			pstmt.setString(2, bDTO.getBtitle());
			pstmt.setString(3, bDTO.getBcontents());
			pstmt.setString(4, bDTO.getBfilename());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			pstmtClose();
		}
		return result;
	}
	
	// 페이지 번호와 관련된 정보 등을 결정하기 위한 메소드 호출
	public int listCount() {
		String sql = "SELECT COUNT(BNUMBER) FROM BOARDLIST";
		int listCount = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				listCount = rs.getInt(1);
				// 처음 조회(SELECT)된 값
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return listCount;
	}
	
	// 클릭한 페이지에 필요한 글만 가져오기 위한 메소드 호출
	public List<BoardDTO> boardListPaging(int startRow, int endRow) {
		String sql = "SELECT * FROM BOARDLIST WHERE RN BETWEEN ? AND ?";
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();
		BoardDTO board = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board = new BoardDTO();
				board.setBnumber(rs.getInt("BNUMBER"));
				board.setBwriter(rs.getString("BWRITER"));
				board.setBtitle(rs.getString("BTITLE"));
				board.setBcontents(rs.getString("BCONTENTS"));
				board.setBdate(rs.getDate("BDATE"));;
				board.setBhits(rs.getInt("BHITS"));
				boardList.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return boardList;
	}
}
