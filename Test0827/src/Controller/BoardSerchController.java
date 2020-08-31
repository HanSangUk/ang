package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.BoardSerchService;
import dto.BoardDTO;

@WebServlet("/searchs")
public class BoardSerchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardSerchController() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	BoardSerchService serch = new BoardSerchService();
    	List<BoardDTO> serchlist = new ArrayList<BoardDTO>();
    	serchlist = serch.serchservice(request, response);
    	
    	request.setAttribute("serchlist", serchlist);
		RequestDispatcher dispatcher = request.getRequestDispatcher("SerchList.jsp");
		dispatcher.forward(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
