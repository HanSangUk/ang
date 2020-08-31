package Service;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;

public class BoardWriteService {

	public int writeservice(HttpServletRequest request, HttpServletResponse response) {
		
		BoardDAO bDAO = new BoardDAO();
		
		
		bDAO.dbConnection();
		
		int result = bDAO.write(request);
		
		bDAO.dbClose();
		
		return result;
	}
	
}
