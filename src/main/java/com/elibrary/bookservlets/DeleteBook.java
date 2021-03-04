package com.elibrary.bookservlets;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elibrary.dao.BookService;

@WebServlet("/DeleteBook")
public class DeleteBook extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static BookService service = new BookService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String callNo = request.getParameter("id");
 
		service.delete(callNo);
		
		response.sendRedirect("librarian/BooksDashboard.jsp");
	}
}
