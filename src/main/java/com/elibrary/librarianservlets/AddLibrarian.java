package com.elibrary.librarianservlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elibrary.beans.LibrarianBean;
import com.elibrary.dao.LibrarianService;

@WebServlet("/AddLibrarian")
public class AddLibrarian extends HttpServlet {
	 
	private static final long serialVersionUID = 1L;

	private static LibrarianService service = new LibrarianService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String smobile=request.getParameter("mobile");
		
		long mobile=Long.parseLong(smobile);
		LibrarianBean bean=new LibrarianBean(name, email, password, mobile);
		service.save(bean);
		
//		out.print("<h4>Librarian added successfully</h4>");
//		request.getRequestDispatcher("addlibrarianform.html").include(request, response);
//		request.getRequestDispatcher("ViewLibrarian").forward(request, response);
		response.sendRedirect("AdminDashboard.jsp");
		
		
//		out.println("</div>");
//		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
