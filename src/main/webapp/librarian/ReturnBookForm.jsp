<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Return Book Form</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../cssfiles/bootstrap.min.css"/>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
<link rel="stylesheet" href="../cssfiles/Company.css"> 

</head>
<body>

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
          <li><a href="BooksDashboard.jsp">View Books</a></li>
          <li><a href="IssueBookForm.jsp">Issue Book</a></li>
          <li><a href="IssuedBooks.jsp">View Issued Book</a></li>
            <li><a href="ReturnBookForm.jsp">Return Book</a></li>
          <li><a href="../Contact.html">Contact Us</a></li>
           <li><a href="../LogoutLibrarian">Logout</a></li>
       </ul>

    </div>
  </div>
</div>

	<%
    	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");

		if(session.getAttribute("user")==null)
		{
			response.sendRedirect("LibrarianLogin.html");
		} 

	%>

 <form action="../ReturnBook" method="post" style="width:400px">
  <div class="form-group">
    <label for="callno1">Call No</label>
    <input type="text" class="form-control" name="callno" id="callno1" placeholder="A-1"/>
  </div>
  <div class="form-group">
    <label for="name1">Student Id</label>
    <input type="text" class="form-control" name="studentid" id="name1" placeholder="101"/>
  </div>

 
  <button type="submit" class="btn btn-primary">Return Book</button>
</form>

</body>
</html>