package Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardUpdateProcessService {

	public int updatrpro(HttpServletRequest request, HttpServletResponse response) {
		int bnumber = Integer.parseInt(request.getParameter("bnumber"));
		String bwriter = request.getParameter("bwriter");
		String btitle = request.getParameter("btitle");
		String bcontents = request.getParameter("bcontents");
		
		BoardDTO bDTO = new BoardDTO();
		
		bDTO.setBnumber(bnumber);
		bDTO.setBwriter(bwriter);
		bDTO.setBtitle(btitle);
		bDTO.setBcontents(bcontents);
		
		BoardDAO bDAO = new BoardDAO();
		bDAO.dbConnection();
		int result = bDAO.UpdateProcess(bDTO);
//		if(result>0) {
//			bDTO = bDAO.boardView(bnumber);
//		}
		bDAO.dbClose();
		
		return result;
	}

}
