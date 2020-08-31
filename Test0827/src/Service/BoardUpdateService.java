package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardUpdateService {

	public BoardDTO update(HttpServletRequest request, HttpServletResponse response) {
		int bnumber = Integer.parseInt(request.getParameter("bnumber"));
		BoardDAO bDAO = new BoardDAO();
		
		bDAO.dbConnection();

		BoardDTO bDTO = bDAO.Update(bnumber);
		
		bDAO.dbClose();
		return bDTO;
	}

}
