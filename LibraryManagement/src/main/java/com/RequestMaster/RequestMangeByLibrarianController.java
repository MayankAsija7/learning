package com.RequestMaster;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class RequestMangeByLibrarianController
 */
public class RequestMangeByLibrarianController extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestMangeByLibrarianController() {
        super();
        // TODO Auto-generated constructor stub
    }

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub

	
	
	
}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
	
	
	
	
	
	
	
	
	
	
	
	String action = request.getParameter("btn");
    int requestId = Integer.parseInt(request.getParameter("reqid"));
    String name=request.getParameter("studentName");
System.out.println("inside DoPost");
    if ("Accept".equals(action)) {
        System.out.println("Accept Clicked");
    	RequestDao requestObject=new RequestDaoImpl();
    	requestObject.accept(requestId);
    	System.out.println("Request Accepted Successfully");
    	
    	System.out.println(requestId);
    	System.out.println(name+"******************************\n");
    	
    	response.sendRedirect("LibrarianManageRequest.jsp");
    } else if ("deny".equals(action)) {
        
    	
    	System.out.println("Deny Clicked");
    	RequestDao requestObject=new RequestDaoImpl();
    	requestObject.deny(requestId);
    	System.out.println("Request Denied Successfully");
    	
    	response.sendRedirect("LibrarianManageRequest.jsp");
    }
    else if(action.equals("Accept Return"))
    {
    	System.out.println("Return Accept Clicked");
    	RequestDao requestObject=new RequestDaoImpl();
    	requestObject.acceptBookReturn(requestId);
    	System.out.println("Book Returned SuccessFully");
    	response.sendRedirect("LibrarianManageReturnRequest.jsp");
    }

    
   

    
}
}