package com.RequestMaster;

import java.io.IOException;
import java.util.ArrayList;

import com.BookMaster.BookMasterDao;
import com.BookMaster.BookMasterDaoImpl;
import com.BookMaster.LibBook;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestController
 */
public class RequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
		
		
		
		
		int requestId=Integer.parseInt(request.getParameter("requestId"));
		int studentId=Integer.parseInt(request.getParameter("studentId"));
		String requestStatus=request.getParameter("requestStatus");
		String requestDate=request.getParameter("requestDate");
		String requestRemark=request.getParameter("requestRemark");
		String bookReturnDate=request.getParameter("bookReturnDate");
		String btnclk=request.getParameter("BtnClick");
		ArrayList<Requests> RqAl=new ArrayList<>();
		RequestDao RqDaoObj=new RequestDaoImpl();

		RqDaoObj.getMaxId();

			if(btnclk.equals("Request Book"))
			{
				System.out.println("Here Request Book is Called");
RqDaoObj.createRequest(requestId, studentId, requestStatus, requestDate, requestRemark, bookReturnDate);
			response.sendRedirect("RequestMaster.jsp");
			}
			else if(btnclk.equals("Display Request"))
			{
				System.out.println("In Diplay");
				RqAl=RqDaoObj.findRequest(requestId);
				request.setAttribute("RequestData", RqAl);
				RequestDispatcher rdp=request.getRequestDispatcher("RequestMaster.jsp");
				rdp.forward(request, response);
			}
			else if(btnclk.equals("Update Request"))
			{
				int updatedRows=RqDaoObj.updateRequest(requestId, studentId, requestStatus, requestDate, requestRemark, bookReturnDate);
				System.out.println(updatedRows);
				response.sendRedirect("RequestMaster.jsp");
			}
			else if(btnclk.equals("Delete Request"))
			{
				RqDaoObj.deleteRequest(requestId);
				response.sendRedirect("RequestMaster.jsp");
			}

		}
	}

