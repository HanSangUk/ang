package Service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardSerchService {

	public List<BoardDTO> serchservice(HttpServletRequest request, HttpServletResponse response) {
		String btitle = request.getParameter("btitle");
		
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		BoardDAO bDAO = new BoardDAO();
		
		bDAO.dbConnection();
		
		list = bDAO.serch(btitle);
		
		bDAO.dbClose();
		
		return list;
	}

}
