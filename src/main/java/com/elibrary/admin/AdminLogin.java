package com.elibrary.admin;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/AdminLogin")

public class AdminLogin extends HttpServlet {
	 
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.println("<head>");
		out.println("<title>Admin Section</title>");
		out.println("<link rel='stylesheet' href='cssfiles/bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
//		String email	= request.getParameter("email");
//		String password	= request.getParameter("password");
		
//		if(email.trim().equals("Admin") && password.trim().equals("admin123"))
//		{
			HttpSession session=request.getSession();
			session.setAttribute("admin","true");
			
			
// 			request.getRequestDispatcher("ViewLibrarian").forward(request, response);
//			request.getRequestDispatcher("AdminDashboard.jsp").forward(request, response);
			response.sendRedirect("AdminDashboard.jsp");
			
//		}else{
//			request.getRequestDispatcher("navhome.html").include(request, response);
//			out.println("<div class='container'>");
//			out.println("<h3>Username or password error !!</h3>");
//			request.getRequestDispatcher("index.html").include(request, response);
//			out.println("</div>");
//			response.sendRedirect("index.html");
//		}
		
		
//		request.getRequestDispatcher("html/footer.html").include(request, response);
		out.close();
	}

}
