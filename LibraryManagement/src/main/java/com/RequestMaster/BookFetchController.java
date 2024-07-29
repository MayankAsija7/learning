package com.RequestMaster;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.BookMaster.BookMasterDao;
import com.BookMaster.BookMasterDaoImpl;
import com.BookMaster.LibBook;

/**
 * Servlet implementation class BookFetchController
 */
public class BookFetchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookFetchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		

		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession sessionObj=request.getSession();
		
		
		
		
		/*
		 * String fetchClick=null; fetchClick=request.getParameter("btn");
		 * 
		 * if(fetchClick != null && fetchClick.equals("Fetch Data")) { String prevUrl =
		 * request.getHeader("referer");
		 * 
		 * 
		 * System.out.println(prevUrl); if(prevUrl.equals(
		 * "http://localhost:8080/LibraryManagementEror/requestGen.jsp")) {
		 * BookMasterDao bkObj=new BookMasterDaoImpl();
		 * 
		 * ArrayList<LibBook> BkAl=bkObj.findAllBook();
		 * System.out.println("In Do Get Method"); System.out.println(BkAl.isEmpty());
		 * request.setAttribute("bookData",BkAl); fetchClick=null; RequestDispatcher
		 * rdp=request.getRequestDispatcher("requestGen.jsp?page=Reloded");
		 * rdp.forward(request, response); } } String rm=(String)
		 * request.getAttribute("remark"); if(fetchClick != null &&
		 * fetchClick.equals("Submit Request")) {
		 * System.out.println("Hello This Is Remark");
		 * 
		 * }
		 */
		
		
		
		
		
		String returnbookbtnclk="";
		if(request.getParameter("btn2") !=null )
		{
		returnbookbtnclk=request.getParameter("btn2");
		}
		if(returnbookbtnclk.equals("Return Book"))
		{
			Integer reqId=Integer.parseInt(request.getParameter("RequestId"));
			
			try
			{
				String url="jdbc:postgresql://10.1.1.53:5432/TRAINING";
	String name="postgres";
	String password="MOb1cule!";
				Class.forName("org.postgresql.Driver");
			System.out.println("Inside UpdateRequest ");
			String query="update \"I1291\".requests set request_status=? Where request_id="+reqId;
			System.out.println("Query Received : "+query);
			Connection con=DriverManager.getConnection(url,name,password);
			System.out.println("Connection String : "+con);
		    PreparedStatement pts=con.prepareStatement(query);
			pts.setString(1,"request pending to approve return book");
		
			System.out.println("Printing Preparedstatement object"+pts);
			int op=pts.executeUpdate();
			System.out.println("Here Rows Updated : "+op);
			if(op>0)
			{
				response.sendRedirect("StudentReturnBookList.jsp");
			}
			}
			catch(Exception ex)
			{
				ex.getStackTrace();
			}
						
			
			
			
			
			
		}
		else
		{
		
		
		
		
		
		String fetchClick=null; fetchClick=request.getParameter("btn");
		BookMasterDao bkObj=new BookMasterDaoImpl();
		if(fetchClick != null && fetchClick.equals("Fetch Data"))
		{
			
			ArrayList<LibBook> BkAl=bkObj.findAllBook();
 System.out.println("In Do Post Method"); 
 System.out.println(BkAl.isEmpty());
 request.setAttribute("bookData",BkAl); 
 fetchClick=null;
 RequestDispatcher rdp=request.getRequestDispatcher("requestGen.jsp");
 rdp.forward(request, response); 
 } 
	else if(fetchClick.equals("Submit Request"))
{
		String url="jdbc:postgresql://10.1.1.53:5432/TRAINING";
		String name="postgres";
		String password="MOb1cule!";
		System.out.println("Submiting Request");
		 int requestId=Integer.parseInt(request.getParameter("requestId"));
			//String studentName=request.getParameter("");
			int isbn=Integer.parseInt(request.getParameter("isbn"));
			String requestDate=request.getParameter("requestDate");
			String remark=request.getParameter("remark");
			//Integer studentId=Integer.parseInt((String)sessionObj.getAttribute("sessionStudentId"));
			
			Integer studentId=Integer.parseInt((String)sessionObj.getAttribute("sessionStudentId"));
			try
			{
		    System.out.println("Driver Loading");
		    Class.forName("org.postgresql.Driver");
			System.out.println("Driver Loaded");
			
			System.out.println("Connection Loading");
			Connection con=DriverManager.getConnection(url,name,password);
			System.out.println("Connection Loaded");
			
			System.out.println("Connection  "+con);
			String query="insert into \"I1291\".requests(request_id,isbn,request_date,request_remark,student_id) values(?,?,?,?,?)";
		System.out.println("Controll After Executing Query");
			System.out.println(query);
			PreparedStatement pts=con.prepareStatement(query);
			pts.setInt(1, requestId);
			pts.setInt(2,isbn);
			pts.setString(3,requestDate);
			pts.setString(4,remark);
			pts.setInt(5,studentId);
			System.out.println("Value Of Prepared Statement"+pts);
			System.out.println("Going To Execute Query!!!!!!!!");
			
			
			int countUpdateRows=pts.executeUpdate();
			
			System.out.println("Number Of Rows Effected"+countUpdateRows);
			
			response.sendRedirect("requestGen.jsp?reqId="+requestId);
			
			}
			catch(Exception ex)
			{
				ex.getStackTrace();
			}
			
		
		
		
		System.out.println("Request Id : "+requestId+" ISBN : "+isbn+" Request Date : "+requestDate+" Remark : "+remark);	
}else if(fetchClick.equals("All Requests"))
{
	response.sendRedirect("allrequests.jsp");
}

		
		
		
		
	}
	}

}