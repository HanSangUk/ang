package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;


public class DeleteService2 {

	public int memberDelete(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		
		MemberDAO mDAO = new MemberDAO();
		mDAO.dbConnection();
		int deleteResult = mDAO.Delete2(mid);
		mDAO.dbClose();
		
		return deleteResult;
	}

}
