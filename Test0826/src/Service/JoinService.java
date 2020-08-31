package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemberDAO;
import DTO.MemberDTO;

public class JoinService {

	public int joinService(HttpServletRequest request, HttpServletResponse response) {
		MemberDTO mDTO = null;
		String mid = request.getParameter("mid");
		String mpassword = request.getParameter("mpassword");
		String mname = request.getParameter("mname");
		String mgender = request.getParameter("mgender");
		String mphone = request.getParameter("mphone");
		String maddress1 = request.getParameter("maddress1");
		String maddress2 = request.getParameter("maddress2");
		String maddress3 = request.getParameter("maddress3");
		String maddress4 = request.getParameter("maddress4");
		String memail = request.getParameter("memail");
		
		String maddress = maddress1 + maddress2 + maddress3 + maddress4;
		mDTO = new MemberDTO();
		mDTO.setMid(mid);
		mDTO.setMpassword(mpassword);
		mDTO.setMname(mname);
		mDTO.setMgender(mgender);
		mDTO.setMphone(mphone);
		mDTO.setMaddress(maddress);
		mDTO.setMemail(memail);
		
		MemberDAO mDAO = new MemberDAO();
		mDAO.dbConnection();
		int result = mDAO.Join(mDTO);
		mDAO.dbClose();
		return result;
	}

}
