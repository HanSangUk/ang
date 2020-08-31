package Service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardWriteFileService {

	public int boardfile(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 파일이 저장될 위치를 savePath 변수에 저장
		String savePath = "D:\\source\\servlet\\Test0827\\WebContent\\UploadFile";
		
		MultipartRequest mulit = new MultipartRequest(
				request, savePath, 10*1024*1024, "UTF-8", 
				new DefaultFileRenamePolicy());
		
		BoardDTO bDTO = new BoardDTO();
		String bwriter = mulit.getParameter("bwriter");
		String btitle = mulit.getParameter("btitle");
		String bcontents = mulit.getParameter("bcontents");
		String bfilename = mulit.getOriginalFileName((String)mulit.getFileNames().nextElement());
		bDTO.setBtitle(btitle);
		bDTO.setBwriter(bwriter);
		bDTO.setBcontents(bcontents);
		bDTO.setBfilename(bfilename);
		
		BoardDAO bDAO = new BoardDAO();
		
		bDAO.dbConnection();
		int result = bDAO.boardWriteFile(bDTO);
		bDAO.dbClose();
		
		
		return result;
	}

}
