package com.elibrary.librarianservlets;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elibrary.dao.LibrarianService;
@WebServlet("/LibrarianLogin")
public class LibrarianLogin extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	private LibrarianService service = new LibrarianService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
 
		
		String username=request.getParameter("email");
		String password=request.getParameter("password");
		
		int status = service.authenticate(username, password);

		if(status > 0){
			HttpSession session=request.getSession();
			session.setAttribute("user",username);

			response.sendRedirect("librarian/LibrarianDashboard.jsp");
		}else{
//			request.getRequestDispatcher("navhome.html").include(request, response);
//			out.println("<div class='container'>");
//			out.println("<h3>Username or password error</h3>");
//			request.getRequestDispatcher("librarian/LibrarianLogin.html").include(request, response);
//			out.println("</div>");
			response.sendRedirect("librarian/LibrarianLogin.html");
		}
		
		
//		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
