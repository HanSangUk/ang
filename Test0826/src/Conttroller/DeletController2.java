package Conttroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.DeleteService2;

@WebServlet("/delete2")
public class DeletController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeletController2() {
        super();
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	DeleteService2 mDS = new DeleteService2();
    	int deleteResult = mDS.memberDelete(request, response);
    	if(deleteResult > 0) {
    		// jsp 파일로 redirect를 하는 것이 아니라
    		// memberlist 주소를 redirect 하는 방법
    		// 이렇게 하면 MemberListController가 바로 호출되면서 최종 결과는 MemberList.jsp가 출력됨
    		response.sendRedirect("list");
    		
    	} else {
    		response.sendRedirect("Main.jsp");
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
