package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;
import DTO.MemberDTO;

public class UpdateProcessService {

	public int updateP(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mname = request.getParameter("mname");
		String mphone = request.getParameter("mphone");
		String memail = request.getParameter("memail");
		MemberDTO mDTO = new MemberDTO();
		mDTO.setMid(mid);
		mDTO.setMname(mname);
		mDTO.setMphone(mphone);
		mDTO.setMemail(memail);
		
		MemberDAO mDAO = new MemberDAO();
		mDAO.dbConnection();
		int result = mDAO.updateprecess(mDTO);
		mDAO.dbClose();
		
		return result;
	}

}
