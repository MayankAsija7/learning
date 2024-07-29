package com.LibrarianMaster;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.RequestMaster.Requests;
import com.RequestMaster.fetchOne;

/**
 * Servlet implementation class LibrarianMasterPageCOntroller
 */




@WebServlet("/Controller")
public class LibrarianMasterPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public LibrarianMasterPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		System.out.println("inside Librarian Controller");
		
		String optionclk=request.getParameter("btn");
		
		System.out.println("Option Clicked "+optionclk);
		
		LibrarianMasterDao librarianObj=new LibrarianMasterDaoImpl();
		
		if(optionclk.equals("Update Librarian"))
		{
			System.out.println("in update");
		   int librarianId=Integer.parseInt(request.getParameter("librarianId"));
			String librarianname=request.getParameter("librarianName");
			String contactNumber=request.getParameter("librarianConNum");
			String joiningdate=request.getParameter("joiningDate");
			String address=request.getParameter("librarianAddress");
			String email=request.getParameter("librarianEmail");
			String pass=request.getParameter("password");
			System.out.println(librarianId+librarianname +contactNumber+joiningdate+address+email+pass);
		int status=librarianObj.UpdateLibrarian(librarianId, librarianname, contactNumber, joiningdate, address, email, pass);
		response.sendRedirect("LibrarianMasterPage.jsp");
		
		}else
			if(optionclk.equals("Delete"))
			{
				System.out.println("In Delete Librarian");
				 int librarianId=Integer.parseInt(request.getParameter("librarianId"));
				 librarianObj.DelLibrarian(librarianId);
					response.sendRedirect("LibrarianMasterPage.jsp");	
				 
				 /*
					 * if(LbAl != null || !(LbAl.isEmpty())) {
					 * librarianObj.DeleteLibrarian(librarianId);
					 * response.sendRedirect("LibrarianMaster.jsp"); } else {
					 * System.out.println("Deletion Not Performed");
					 * response.sendRedirect("LibrarianMaster.jsp"); }
					 */
				
			}else
				if(optionclk.equals("Add Librarian"))
				{
					System.out.print("in Add Librarian");
					
					int librarianId=Integer.parseInt(request.getParameter("libId"));
					String librarianname=request.getParameter("libName");
					String contactNumber=request.getParameter("contNum");
					String joiningdate=request.getParameter("jDate");
					String address=request.getParameter("address");
					String email=request.getParameter("email");
					String pass=request.getParameter("password");
					System.out.println(librarianId+librarianname +contactNumber+joiningdate+address+email+pass);
					
					
					System.out.println("Add Libraian Clicked");
					int status=librarianObj.insertLibrarian(librarianId,librarianname ,contactNumber,joiningdate,address,email,pass);
					if(status==-1)
					{
						
					response.sendRedirect("LibrarianRegistration.jsp?error=librarian_already_exist");
					}
					else
					{
					response.sendRedirect("LibrarianMasterPage.jsp");
					}
					
				}
				else
					if(optionclk.equals("Apply Filter"))
					{
						
				 System.out.println("Clicked on Apply Filter");
				 String fromdate=request.getParameter("fromDate");
				 String todate=request.getParameter("toDate");
				 System.out.println("Value Received for From Date : "+fromdate+"Value Received for To Date : "+todate);
				 fetchOne fetchRecordObj=new fetchOne();
				 ArrayList<Requests> requestsArrayList=new ArrayList<>();
				 requestsArrayList=fetchRecordObj.dispRequestByDate(fromdate, todate);
				 System.out.println("Sorted ArrayList : "+requestsArrayList);
				 request.setAttribute("sortByDate", requestsArrayList);
				 RequestDispatcher rdp=request.getRequestDispatcher("AllRequestHistoryForLibrarian.jsp");
				 rdp.forward(request, response);
				 
				 
				 
				 //response.sendRedirect("AllRequestHistoryForLibrarian.jsp");
						
					}
		
		
		
		
	}

}
