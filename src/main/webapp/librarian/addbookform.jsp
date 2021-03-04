<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="ISO-8859-1">
<title>E-Library</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="../cssfiles/bootstrap.min.css"/>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
<link rel="stylesheet" href="../cssfiles/Company.css"> 
</head>

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

<body style="background-image: url('../images/AmazingOldBook.jpg'); background-repeat: no-repeat; background-size: cover;">


	<%
    	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");

		if(session.getAttribute("user")==null)
		{
			response.sendRedirect("LibrarianLogin.html");
		} 

 
	%>
  <form action="../AddBook" method="post" style="width:400px">
  <div class="form-group">
    <label for="callno1">Call No</label>
    <input type="text" class="form-control" name="callno" id="callno1" placeholder="Callno"/>
  </div>
  <div class="form-group">
    <label for="name1">Name</label>
    <input type="text" class="form-control" name="name" id="name1" placeholder="Name"/>
  </div>
  <div class="form-group">
    <label for="author1">Author</label>
    <input type="text" class="form-control" name="author" id="author1" placeholder="Author"/>
  </div>
  <div class="form-group">
    <label for="publisher1">Publisher</label>
    <input type="text" class="form-control" name="publisher" id="publisher1" placeholder="Publisher"/>
  </div>
  <div class="form-group">
    <label for="quantity1">Quantity</label>
    <input type="number" class="form-control" name="quantity" id="quantity1" placeholder="Quantity"/>
  </div>
  <button type="submit" class="btn btn-primary">Save Book</button>
</form>
</body>
</html>