<%@page import="com.elibrary.beans.LibrarianBean"%>
<%@page import="com.elibrary.dao.LibrarianService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Librarian Form</title>
<link rel='stylesheet' href='cssfiles/bootstrap.min.css'>
</head>
<body style="background-image: url('../images/photo-1481.jpg') background-repeat: no-repeat; background-size: cover;">

	<%
	
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	
		if(session.getAttribute("admin")==null)
		{
			response.sendRedirect("index.html");
		} 

		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
 		
		 LibrarianService service  = new LibrarianService();
		 LibrarianBean bean = service.viewById(id);
		 		 
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
         <li><a href="AdminDashboard.jsp">Home</a></li>
         <li><a href="admin/addlibrarianform.html">Add Librarian</a></li>
        <li><a href="../html/Contact.jsp">Contact Us</a></li>
        <li><a href="Logout">Logout</a></li>
       </ul>

    </div>
  </div>
</div>
		
		<div class='container'>
		
		<form action='EditLibrarian' method='post' style='width:300px'>
		<div class='form-group'>
		<input type="hidden" name='id' value=<%= bean.getId()%>>
		
		<label for='name1'>Name</label>
		<input type="text" class='form-control' value=<%= bean.getName()%> name='name' id='name1'/>
		</div>
		<div class='form-group'>
		<label for='email1'>Email address</label>
		<input type='email' class='form-control' value=<%= bean.getEmail()%>  name='email' id='email1' placeholder='Email'/>
		</div>
		<div class='form-group'>
		<label for='password1'>Password</label>
		<input type='password' class='form-control' value=<%= bean.getPassword()%>  name='password' id='password1' placeholder='Password'/>
		</div>
		<div class='form-group'>
		<label for='mobile1'>Mobile Number</label>
		<input type='number' class='form-control' value=<%= bean.getMobile()%>  name='mobile' id='mobile1' placeholder='Mobile'/>
		</div>
		<button type='submit' class='btn btn-primary'>Update</button>
		</form>
		
		</div>
	
	
</body>
</html>