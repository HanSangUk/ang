package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.BoardWriteFileService;

@WebServlet("/boardwritefile")
public class BoardWriteFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardWriteFileController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	BoardWriteFileService fileservice = new BoardWriteFileService();
    	int result = fileservice.boardfile(request, response);
    	if(result>0) {
    		response.sendRedirect("BoardWriteFile.jsp");
    	} else {
    		response.sendRedirect("BoardFail.jsp");
    	}
    
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
