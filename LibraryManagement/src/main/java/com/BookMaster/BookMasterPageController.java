package com.BookMaster;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class BookMasterPageController
 */
public class BookMasterPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookMasterPageController() {
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
		System.out.println("In Servlet");
		String optionclk=request.getParameter("btn");
		System.out.println("Option Clicked "+optionclk);
		
		BookMasterDao bookob=new BookMasterDaoImpl();
		if(optionclk.equals("Update Book"))
		{
			System.out.println("in update");
			int isbn=Integer.parseInt(request.getParameter("BookIsbn"));
			String bookname=request.getParameter("BookName");
			String bookauthor=request.getParameter("bookAuthor");
			String bookdescription=request.getParameter("bookDescription");
			String bookgenre=request.getParameter("bookGenre");
			String bookstatus=request.getParameter("bookStatus");
			System.out.println(isbn+bookname+bookauthor+bookdescription+bookgenre+bookstatus);
			bookob.updateBook(isbn,bookname,bookauthor,bookdescription,bookgenre);
			response.sendRedirect("BookMasterPage.jsp");
		
		}
		else
			if(optionclk.equals("Delete Book"))
			{
				System.out.println("In Delete Book");
				int isbn=Integer.parseInt(request.getParameter("isbn"));
				bookob.DelBook(isbn);
				response.sendRedirect("BookMasterPage.jsp");
				
			}
			else if(optionclk.equals("Add Book"))
			{
				System.out.println("Add Book Clicked");
				int isbn=Integer.parseInt(request.getParameter("isbnNum"));
				System.out.println("Isbn Updates");
				String bookname=request.getParameter("bookName");
				String bookauthor=request.getParameter("bookAuthor");
				String bookdescription=request.getParameter("bookDescription");
				String bookgenre=request.getParameter("bookGenre");
				String bookstatus=request.getParameter("bookStatus");
				 bookob.insertBook(isbn,bookname,bookauthor,bookdescription,bookgenre);
					response.sendRedirect("BookMasterPage.jsp");
				
				
			}
		
		
		
		
		
		
		
	}

}
