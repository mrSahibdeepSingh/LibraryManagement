<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Librarian Dashboard</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../cssfiles/bootstrap.min.css"/>
<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
<link rel="stylesheet" href="../cssfiles/LibrarianDashboard.css">
</head>
<body style="background-image: url('../images/AmazingOldBook.jpg'); background-repeat: no-repeat; background-size: cover;">

	<%
    	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");

		if(session.getAttribute("user")==null)
		{
			response.sendRedirect("LibrarianLogin.html");
		} 

 
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
        <li><a href="../Contact.html">Contact Us</a></li>
        <li><a href="../LogoutLibrarian">Logout</a></li>
       </ul>
    </div>
  </div>
</div>
	
	<ul class="svertical">
		<li><a href="addbookform.jsp">Add Book</a></li>
		<li><a href="BooksDashboard.jsp" >View Books</a></li>
		<li><a href="IssueBookForm.jsp">Issue Book</a></li>
		<li><a href="IssuedBooks.jsp">View Issued Book</a></li>
		<li><a href="ReturnBookForm.jsp">Return Book</a></li>
	</ul>
	
 

	
	
</body>
</html>