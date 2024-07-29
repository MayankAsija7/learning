package com.myserP;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class ser
 */
@WebServlet("/authentication")
public class authenticationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * String name="Mayank"; String pass="123"; String adminName="Admin"; String
	 * adminPass="111"; String librarian="lib"; String librarianPass="152";
	 */
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authenticationController() {
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
		System.out.println("Hello I am in get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response) ;
		/*
		 * try { Class.forName("com.mysql.jdbc.Driver"); String
		 * url="jdbc:mysql://localhost:3309/LibraryDB"; String cname="testusr"; String
		 * cpassword ="123"; String
		 * query="select username,usertype from userType where username="+name;
		 * Connection con=DriverManager.getConnection(url,name,cpassword);
		 * PreparedStatement smt=con.prepareStatement(query); ResultSet rs=
		 * smt.executeQuery();
		 *
		 *
		 *
		 *
		 *
		 *
		 *
		 *
		 *
		 * } catch(Exception ex) {
		 *
		 * }
		 *
		 */


		String dnm=request.getParameter("nm");
		String dps=request.getParameter("pass");



		authenticationDao AuthObj=new authenticationDaoImpl();
        String valStatus=AuthObj.validateUser(dnm);
        if(valStatus.equals("true"))
        {
        	response.sendRedirect("Login.jsp?Error=suspended");
        }
        else
        {
        System.out.println("Value Received By Authentication : "+valStatus);

        if(valStatus != "Empty"&&valStatus != "Exception")
		{
        	HttpSession sessionObj=request.getSession();
			sessionObj.setAttribute("mailInSession",dnm);
			sessionObj.setAttribute("sessionPassword", dps);
			String mail=(String)sessionObj.getAttribute("mailInSession");
			String pas=(String)sessionObj.getAttribute("sessionPassword");
			//String authStatus=AuthObj.login(mail,pas,valStatus);
			ArrayList userInfoFetched=AuthObj.login(mail,pas,valStatus);
			System.out.println("Here Valus Received from Login"+userInfoFetched);




			////////////////////////////////////////////////////////////


			//if(!authStatus.equals("null"))
			if(!userInfoFetched.isEmpty())
			{
				sessionObj.setAttribute("username", userInfoFetched.get(0));


				if(valStatus.equals("student"))
				{

					//if(authStatus.equals("false"))
					if(userInfoFetched.isEmpty())
					{
						response.sendRedirect("Login.jsp?error=2");

					}
					else
					{
						sessionObj.setAttribute("sessionStudentId",userInfoFetched.get(1));
					System.out.println("**************************"+sessionObj.getAttribute("sessionStudentId")+"**********");
						response.sendRedirect("StudentHome.jsp");
					
					}

				}
				else
					if(valStatus.equals("librarian"))
					{
					
						
						if(userInfoFetched.isEmpty())
						{
							response.sendRedirect("Login.jsp?error=2");

						}
						else
						{
							
							System.out.println("Printing Control before Assign Session username ");
							sessionObj.setAttribute("SessionUserName",userInfoFetched.get(1));

							response.sendRedirect("LibrarianHome.jsp");
							
						}
						
						
						
						
					
					
					
					
					
					}
					else if(valStatus.equals("admin"))
					{
						//if(authStatus.equals("false"))
						if(userInfoFetched.isEmpty())
						{
							response.sendRedirect("Login.jsp?error=2");

						}
						else
						{

						response.sendRedirect("AdminHome.jsp");
						}
						}



			}else if(valStatus.equals("false"))
			{
				System.out.println("Invalid Password");
				response.sendRedirect("Login.jsp?Error=2");
			}
			else if(valStatus != "Empty")
			{
				System.out.println(valStatus);
				System.out.println("Invalid User Id");
				response.sendRedirect("Login.jsp?Error=EmptyResult");
			}
			else
			{
				System.out.println("Exception Occourd");
				response.sendRedirect("Login.jsp?Error=Exception");

			}




			}
			else
			{
				//System.out.println("Failed To Login");
				response.sendRedirect("Login.jsp?Error=invalidusernm");
			}






		//System.out.println(dnm+" = "+name+" : "+dps+" : "+pass);
        System.out.println("Name Enter In JSP : "+dnm+" Password Entered In JSP : "+dps);
		/*
		 * HttpSession scn=request.getSession(); if(dnm.equals(name)&&dps.equals(pass))
		 * {
		 *
		 *
		 * scn.setAttribute("SessionUserName",dnm);
		 * response.sendRedirect("StudentHome.jsp"); }else if(dnm.equals(adminName)&&
		 * dps.equals(adminPass)){
		 *
		 * scn.setAttribute("SessionUserName",dnm);
		 * response.sendRedirect("AdminHome.jsp"); } else if(dnm.equals(librarian)&&
		 * dps.equals(librarianPass)) { scn.setAttribute("SessionUserName",dnm);
		 * response.sendRedirect("LibrarianHome.jsp"); } else {
		 * response.sendRedirect("Login.jsp?error=1"); }
		 */


	}
	}

}
