<%@page import="com.elibrary.beans.BookBean"%>
<%@page import="java.util.List"%>
<%@page import="com.elibrary.dao.BookService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library Books</title>
<link rel="stylesheet" href="../cssfiles/bootstrap.min.css"/>
<link rel="stylesheet" href="../cssfiles/Global.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">

</head>
<body style="background-image: url('../images/photo-1481.jpg'); background-repeat: no-repeat; background-size: cover;">

<%
    	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");

		if(session.getAttribute("user")==null)
		{
			response.sendRedirect("LibrarianLogin.html");
		} 

		String s = (String)session.getAttribute("admin"); 
		BookService service = new BookService();
		List<BookBean> books = service.viewBooks();

 
	%>
		<div class="navbar navbar-inverse">
  <div class="container">
     <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" style="color: white">eLibrary</a>
    </div>

     <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      	  <li><a href="LibrarianDashboard.jsp">Home</a></li>
      	  <li><a href="addbookform.jsp">Add Book</a></li>
           <li><a href="IssueBookForm.jsp">Issue Book</a></li>
           <li><a href="IssuedBooks.jsp">View Issued Book</a></li>
           <li><a href="ReturnBookForm.jsp">Return Book</a></li>
          <li><a href="../Contact.html">Contact Us</a></li>
           <li><a href="../LogoutLibrarian">Logout</a></li>
       </ul>
    </div>
  </div>
</div>

	<div class='container'>
	 <table class="table table-bordered table-striped">
	 	 <thead>
	    <tr><th scope="col">Call No</th><th scope="col">Name</th><th scope="col">Author</th><th scope="col">Publisher</th>
        <th scope="col">Quantity</th><th scope="col">Issued</th><th scope="col">Delete</th></tr>
  		</thead>
  		<tbody id="table-body" style="font-size: small;">
 
 	<%
 	  for(BookBean bean:books)
 	  { 
 		out.println("<tr><td>"+bean.getCallno()+"</td><td>"+bean.getName()+"</td><td>"+bean.getAuthor()+"</td><td>"+bean.getPublisher()+"</td><td>"+bean.getQuantity()+"</td><td>"+bean.getIssued()+"</td><td><a href='../DeleteBook?id="+bean.getCallno()+"'>Delete</a></td></tr>");
 	  } 
 	 %> 
 		</tbody>
 	</table>
 
		</div>
		
</body>
</html>