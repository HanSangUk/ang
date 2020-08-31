package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardViewService {

	public BoardDTO view(HttpServletRequest request, HttpServletResponse response) {
		int bnumber = Integer.parseInt(request.getParameter("bnumber"));

		BoardDAO bDAO = new BoardDAO();
		
		bDAO.dbConnection();
		bDAO.hitsup(bnumber);
		BoardDTO mDTO = bDAO.boardView(bnumber);
		
		bDAO.dbClose();
		
		return mDTO;
	}

}
