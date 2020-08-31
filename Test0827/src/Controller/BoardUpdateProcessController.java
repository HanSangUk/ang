package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.BoardUpdateProcessService;

@WebServlet("/updateprocess")
public class BoardUpdateProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardUpdateProcessController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	BoardUpdateProcessService updatepro = new BoardUpdateProcessService();
//    	int UpdateProcess = updatepro.updatrpro(request, response);
//    	BoardDTO UpdateProcess = updatepro.updatrpro(request, response);
    	int UpdateProcess = updatepro.updatrpro(request, response);
    	response.sendRedirect("boardview?bnumber=" + UpdateProcess);
//    	if(UpdateProcess != null) {
//    		request.setAttribute("UpdateProcess", UpdateProcess);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("boardview");
//            dispatcher.forward(request, response);
//    	} else {
//    		response.sendRedirect("BoardUpdate.jsp");
//    	}
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
