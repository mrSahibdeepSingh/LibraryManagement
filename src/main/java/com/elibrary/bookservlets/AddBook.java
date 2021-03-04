package com.elibrary.bookservlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elibrary.beans.BookBean;
import com.elibrary.dao.BookService;
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private static BookService bookservice = new BookService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String callno = request.getParameter("callno");
		String name	= request.getParameter("name");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		String squantity = request.getParameter("quantity");
		
		int quantity = Integer.parseInt(squantity);
		
		BookBean book=new BookBean(callno,name,author,publisher,quantity);
		boolean status = bookservice.save(book);

		if(status){
			response.sendRedirect("librarian/BooksDashboard.jsp");
		}else
		{
			out.println("<Div>");
			out.println("<h3>Book saved successfully</h3>");
			out.println("</Div>");
			response.sendRedirect("librarian/BookError.html");
		}
 
		
		
		out.close();
	}

}
