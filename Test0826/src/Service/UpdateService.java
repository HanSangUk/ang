package Service;

import DAO.MemberDAO;
import DTO.MemberDTO;

public class UpdateService {

	public MemberDTO updateservice(String mid) {
		MemberDTO mDTO = new MemberDTO();

		MemberDAO mDAO = new MemberDAO();
		mDAO.dbConnection();
		mDTO = mDAO.update(mid);
		mDAO.dbClose();

		return mDTO;
	}

}
