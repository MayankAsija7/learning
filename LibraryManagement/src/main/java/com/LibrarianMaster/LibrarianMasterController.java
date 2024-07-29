package com.LibrarianMaster;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LibrarianMasterController
 */
public class LibrarianMasterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibrarianMasterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		int librarianId=Integer.parseInt(request.getParameter("libId"));
		System.out.println("librarianId"+librarianId);
		String name=request.getParameter("libName");
		String PhoneNo=request.getParameter("contNum");
		String joiningDate=request.getParameter("jDate");
		String Address=request.getParameter("address");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String actClicked=request.getParameter("BtnClick");
		System.out.println(actClicked);
		LibrarianMasterDao LbObj=new LibrarianMasterDaoImpl();
	ArrayList<Librarian> LbAl=new ArrayList<>();
		if(actClicked.equals("Add Librarian"))
	{

    LbObj.insertLibrarian(librarianId, name, PhoneNo, joiningDate, Address, email,password);
	response.sendRedirect("LibrarianMaster.jsp");
	}
	else if(actClicked.equals("Display Librarian"))
	{
	LbAl=LbObj.findLibrarian(librarianId);

		if(LbAl != null && !(LbAl.isEmpty()))
		{
			request.setAttribute("LibrarianData", LbAl);
			RequestDispatcher rdp=request.getRequestDispatcher("LibrarianMaster.jsp");
		rdp.forward(request, response);
		}
		else
		{
			request.setAttribute("LibrarianAvailable","No Record Found");
			response.sendRedirect("LibrarianMaster.jsp");
		}

	}else if(actClicked.equals("Update Librarian"))
	{
	LbObj.UpdateLibrarian(librarianId, name, PhoneNo, joiningDate, Address, email, password);
	response.sendRedirect("LibrarianMaster.jsp");
	}
	else if(actClicked.equals("Delete Librarian"))
	{
		if(LbAl != null || !(LbAl.isEmpty()))
		{
			LbObj.DeleteLibrarian(librarianId);
			response.sendRedirect("LibrarianMaster.jsp");
		}
		else
		{
			System.out.println("Deletion Not Performed");
			response.sendRedirect("LibrarianMaster.jsp");
		}

	}

	}

}
