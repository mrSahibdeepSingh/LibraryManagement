<!DOCTYPE html>
<%@page import="com.elibrary.beans.LibrarianBean"%>
<%@page import="java.util.List"%>
<%@page import="com.elibrary.dao.LibrarianService"%>
<%-- <%@page import="com.elibrary.dao.LibrarianDao"%> --%>
<%@page trimDirectiveWhitespaces="true" %>
<html>
<head>
<title>ADMIN DASHBOARD</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="cssfiles/bootstrap.min.css"/>
<link rel="stylesheet" href="cssfiles/Global.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">

</head>

<body style="background-image: url('images/dark.jpg'); background-repeat: no-repeat; background-size: cover;">

   
	<%
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); // HTTP 1.0	
// 		response.setHeader("Pragma", "no-cache");	// HTTP 1.0
		if(session.getAttribute("admin")==null)
		{
			response.sendRedirect("index.html");
		} 

// 			HttpSession sess = request.getSession(false);  
			String n=(String)session.getAttribute("admin");  
	     
 			 LibrarianService service  = new LibrarianService();
			 List<LibrarianBean> list = service.view();
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
         <li><a href="admin/addlibrarianform.jsp">Add Librarian</a></li>
        <li><a href="Contact.html">Contact Us</a></li>
        <li><a href="LogoutAdmin">Logout</a></li>
       </ul>

    </div>
  </div>
</div>
	
	
		<div class='container'>
	 <table class="table table-bordered table-striped">
	 	 <thead>
	    <tr><th scope="col">ID</th><th scope="col">NAME</th><th scope="col">EMAIL</th><th scope="col">PASSWORD</th>
        <th scope="col">MOBILE</th><th scope="col">EDIT</th><th scope="col">DELETE</th></tr>
  		</thead>
  		<tbody id="table-body" style="font-size: small;">
 
 	<%
 	  for(LibrarianBean bean:list)
 	  { 
 		out.println("<tr><td>"+bean.getId()+"</td><td>"+bean.getName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getPassword()+"</td><td>"+bean.getMobile()+"</td><td><a href='EditLibrarian.jsp?id="+bean.getId()+"'>Edit</a></td><td><a href='DeleteLibrarian?id="+bean.getId()+"'>Delete</a></td></tr>");
 	  } 
 	 %> 
 		</tbody>
 	</table>
 
		</div>
	
	 
</body>
</html>