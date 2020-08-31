package Service;

import java.util.ArrayList;
import java.util.List;

import DAO.MemberDAO;
import DTO.MemberDTO;

public class ListService {

	public List<MemberDTO> list() {
		MemberDAO mDAO = new MemberDAO();
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		mDAO.dbConnection();
		list = mDAO.list();
		mDAO.dbClose();
		return list;
	}

}
