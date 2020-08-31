package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;
import DTO.MemberDTO;

public class DeleteProcessService {

	public int deleteP(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpassword = request.getParameter("mpassword");
		MemberDTO mDTO = new MemberDTO();
		mDTO.setMid(mid);
		mDTO.setMpassword(mpassword);
		
		MemberDAO mDAO = new MemberDAO();
		mDAO.dbConnection();
		int result = mDAO.deleteprecess(mDTO);
		mDAO.dbClose();
		
		return result;
	}

}
