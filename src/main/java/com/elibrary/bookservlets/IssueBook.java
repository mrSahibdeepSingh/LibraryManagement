package com.elibrary.bookservlets;


import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elibrary.beans.IssueBookBean;
import com.elibrary.dao.BookService;
@WebServlet("/IssueBook")
public class IssueBook extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static BookService bookservice = new BookService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		

		String callno=request.getParameter("callno");
		String studentid=request.getParameter("studentid");
		String studentname=request.getParameter("studentname");
		String sstudentmobile=request.getParameter("studentmobile");
		long studentmobile=Long.parseLong(sstudentmobile);

		IssueBookBean issueBean=new IssueBookBean(callno,studentid,studentname,studentmobile);

		IssueBookBean issueBook = new IssueBookBean();
 
		java.sql.Date currentDate=new java.sql.Date(System.currentTimeMillis());
 
		String str = "No";
		issueBook.setIssuedDate(currentDate);
		issueBook.setReturnstatus(str);

		boolean issueBookStatus = bookservice.issueBook(issueBean);

		if(issueBookStatus){
			out.println("<h3>Book issued successfully</h3>");
			response.sendRedirect("librarian/IssuedBooks.jsp");
		}else{
			out.println("<h3>Sorry, unable to issue book.</h3><p>We may have sortage of books. Kindly visit later.</p>");
			response.sendRedirect("librarian/IssueBookForm.jsp");
		}
		out.println("</div>");
		
		
 		out.close();
	}

}
