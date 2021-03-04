package com.elibrary.librarianservlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elibrary.beans.LibrarianBean;
import com.elibrary.dao.LibrarianService;
@WebServlet("/EditLibrarian")
public class EditLibrarian extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private static LibrarianService service = new LibrarianService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id=Integer.parseInt(request.getParameter("id"));
 		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String smobile=request.getParameter("mobile");
		long mobile=Long.parseLong(smobile);
		
		LibrarianBean bean=new LibrarianBean(id,name, email, password, mobile);

		int update = service.update(bean);
		if(update == 1)
			response.sendRedirect("AdminDashboard.jsp");
		
	}

}
