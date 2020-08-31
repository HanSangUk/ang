package Conttroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.UpdateProcessService;

@WebServlet("/updateprocess")
public class UpdateProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateProcessController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	UpdateProcessService updateprocess = new UpdateProcessService();
    	int UpdateProcess = updateprocess.updateP(request, response); 
    	if(UpdateProcess>0) {
    		response.sendRedirect("Main.jsp");
    	} else {
    		response.sendRedirect("Update.jsp");
    	}
    } 
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
