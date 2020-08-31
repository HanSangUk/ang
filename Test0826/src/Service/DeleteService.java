package Service;

import DAO.MemberDAO;
import DTO.MemberDTO;

public class DeleteService {

	public MemberDTO Deleteservice(String mid) {
		MemberDTO mDTO = new MemberDTO();

		MemberDAO mDAO = new MemberDAO();
		mDAO.dbConnection();
		mDTO = mDAO.delete(mid);
		mDAO.dbClose();

		return mDTO;
	}

}
