package Service;

import java.util.*;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardListService {

	public List<BoardDTO> listS() {
		BoardDAO bDAO = new BoardDAO();
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		bDAO.dbConnection();
		list = bDAO.daolist();
		bDAO.dbClose();
		
		return list;
	}

}
