package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;
import DTO.MemberDTO;

public class ViewService {

	public MemberDTO view(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		MemberDAO mDAO = new MemberDAO();
		mDAO.dbConnection();
		MemberDTO mDTO = mDAO.view(mid);
		mDAO.dbClose();
		return mDTO;
	}
	
}
