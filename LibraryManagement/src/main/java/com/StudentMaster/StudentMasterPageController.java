package com.StudentMaster;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class StudentMasterPageController
 */
public class StudentMasterPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentMasterPageController() {
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
			doGet(request, response);
	
			System.out.println("In Servlet");
			String optionclk=request.getParameter("btn");
			
			System.out.println("Option Clicked "+optionclk);
			
			StudentDaoImp StudentOb=new StudentDaoImp();
	if(optionclk.equals("Update Student"))
	{
		int id=Integer.parseInt(request.getParameter("StudentId"));
		System.out.println("Here Parsing Done");
		String name=request.getParameter("StudentName");
		String contNum=request.getParameter("StudentConNum");
		String Adrs=request.getParameter("StudentAddress");
		String email=request.getParameter("StudentEmail");
		String pass=request.getParameter("password");
		
		
		
		
	System.out.println("update Clicked");
		int up=StudentOb.updateUser(id, name,contNum, Adrs, email, pass);
		if(up>0)
			{
			System.out.println("Updates Done in Rows of Table"+up);

			}
		else
		{
			System.out.println("Updation not Performed");
		}
		response.sendRedirect("StudentMasterPage.jsp");	
	}else if(optionclk.equals("Delete"))
			{
		System.out.println("Inside Delete");
		System.out.println(request.getParameter("StudentId"));
		int id=Integer.parseInt(request.getParameter("studentId"));
		System.out.println(id+" Received id");
		int status=StudentOb.DeleteStudent(id);
			if(status>0)
			{
				System.out.println("Student Deleted");
			}
			else if(status == -1)
			{
				System.out.println("Item Not Present");
				
			}
			else
			{
				System.out.println("Eroor Occured");
			}
			response.sendRedirect("StudentMasterPage.jsp");
			}
	
	
	
	}

}
