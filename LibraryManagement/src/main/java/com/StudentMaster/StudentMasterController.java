package com.StudentMaster;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StdentMasterController
 */
@WebServlet("/StdentMasterController")
public class StudentMasterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentMasterController() {
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
//String signBtn=;
		if(request.getParameter("SignupBtn") != null)
		{
			StudentDaoImp StObj=new StudentDaoImp();
			int id=StObj.fetchMax();
			String name=request.getParameter("name");
			String contNum=request.getParameter("contactNo");
			String Adrs=request.getParameter("address");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			int status=StObj.insertUser(id, name, contNum, Adrs, email, password);
			if(status==-1)
			{
			response.sendRedirect("Register.jsp?error=user_already_registered");	
			
			}
			else
			{
			response.sendRedirect("Login.jsp");
			}
			
			
		}
		else
		{
		
		int id=Integer.parseInt(request.getParameter("studentId"));
		System.out.println("Here Parsing Done");
		String name=request.getParameter("studentNm");
		String contNum=request.getParameter("contNum");
		String Adrs=request.getParameter("address");
		String email=request.getParameter("email");
		String pass=request.getParameter("password");
		String optionclk=request.getParameter("BtnClick");

		StudentDao StudentOb=new StudentDaoImp();


		if(optionclk.equals("Add Student"))
		{
			StudentOb.insertUser(id, name, contNum, Adrs, email, pass);
			response.sendRedirect("StudentMaster.jsp");

		}
		else
			if(optionclk.equals("Display Student"))
		{

		ArrayList<Student>StAl=new ArrayList();

		StAl=StudentOb.findUser(id);
		if(!StAl.isEmpty())
		{
			System.out.println("Now going to diplay");
		request.setAttribute("StudentData", StAl);

		StAl.forEach((std)->System.out.println(std));


		//response.sendRedirect("StudentMaster.jsp");
		RequestDispatcher rd=request.getRequestDispatcher("StudentMaster.jsp");
		rd.forward(request, response);
		}
		else
		{
			System.out.println("No Record Found");

			response.sendRedirect("StudentMaster.jsp");
		}


		}
		else
			if(optionclk.equals("Update Student")){
				int up=StudentOb.updateUser(id, name,contNum,Adrs,email,pass);
				if(up>0)
					{
					System.out.println("Updates Done in Rows of Table"+up);

					}
				else
				{
					System.out.println("Updation not Performed");
				}
				response.sendRedirect("StudentMaster.jsp");

			}
			else if ("Delete Student".equals(optionclk)) {
			    StudentOb.DeleteUser(id);
			    response.sendRedirect("StudentMaster.jsp");
			}
			else
			{
				response.sendRedirect("StudentMaster.jsp?errorcode=DeletionFailled!!!!");
			}

	}

}
}