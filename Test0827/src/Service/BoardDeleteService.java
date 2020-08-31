package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;

public class BoardDeleteService {

	public int deleteService(HttpServletRequest request, HttpServletResponse response) {
		int bnumber = Integer.parseInt(request.getParameter("bnumber"));
		
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		int result = bDAO.Delete(bnumber);
		bDAO.dbClose();
		
		return result;
	}

}
