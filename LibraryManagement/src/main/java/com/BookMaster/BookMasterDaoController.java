package com.BookMaster;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookMasterDaoController
 */
@WebServlet("/BookMasterDaoController")
public class BookMasterDaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookMasterDaoController() {
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
		int isbn=Integer.parseInt(request.getParameter("isbnNum"));
		String bkname=request.getParameter("bookName");
		String author=request.getParameter("bookAuthor");
		String description=request.getParameter("bookDescription");
		String genre=request.getParameter("bookGenre");
		String optionclk=request.getParameter("BtnClick");

		BookMasterDao bookob=new BookMasterDaoImpl();


		if(optionclk.equals("Add Book"))
		{
		 bookob.insertBook(isbn,bkname,author,description,genre);
			response.sendRedirect("BookMaster.jsp");

		}
		else
			if(optionclk.equals("Display Book"))
		{

		ArrayList<LibBook>BkAl=new ArrayList();

		BkAl=bookob.findBook(isbn);
		if(!BkAl.isEmpty())
		{
			BkAl.forEach((con)->System.out.println(con));
			System.out.println("Now going to diplay");
		request.setAttribute("BookData", BkAl);

		BkAl.forEach((std)->System.out.println(std));



		RequestDispatcher rd=request.getRequestDispatcher("BookMaster.jsp");
		rd.forward(request, response);
		}
		else
		{
			System.out.println("No Record Found");

			response.sendRedirect("BookMaster.jsp");
		}


		}
		else
			if(optionclk.equals("Update Book")){
				int up=bookob.updateBook(isbn,bkname,author,description,genre);
				if(up>0)
					{
					System.out.println("Updates Done in Rows of Table"+up);

					}
				else
				{
					System.out.println("Updation not Performed");
				}
				response.sendRedirect("BookMaster.jsp?error=updateFailed");

			}
			else if (optionclk.equals("Delete Book"))
			{
			    bookob.DeleteBook(isbn);
			    response.sendRedirect("BookMaster.jsp");
			}
	}

}
