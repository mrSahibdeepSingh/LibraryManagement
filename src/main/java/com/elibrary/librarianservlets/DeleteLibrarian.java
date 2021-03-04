package com.elibrary.librarianservlets;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elibrary.dao.LibrarianService;

@WebServlet("/DeleteLibrarian")
public class DeleteLibrarian extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static LibrarianService bean = new LibrarianService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);

		bean.deleteLibrarian(id);
		
		response.sendRedirect("AdminDashboard.jsp");
	}
}
