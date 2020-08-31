package Conttroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.DeleteProcessService;

@WebServlet("/Deleteprocess")
public class DeleteProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteProcessController() {
        super();
    }
    
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	DeleteProcessService deleteprocess = new DeleteProcessService();
    	int DeleteProcess = deleteprocess.deleteP(request, response); 
    	if(DeleteProcess > 0) {
    		response.sendRedirect("Login.jsp");
    	} else {
    		response.sendRedirect("Delete.jsp");
    	}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
