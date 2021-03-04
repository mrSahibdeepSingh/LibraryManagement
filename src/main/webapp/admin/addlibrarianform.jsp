
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Librarian</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
<link rel="stylesheet" href="../cssfiles/Company.css"> 
<link rel="stylesheet" href="../cssfiles/bootstrap.min.css"/>

</head>

<nav class="navbar navbar-inverse">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
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
        <li><a href="../AdminDashboard.jsp">Home</a></li>
         <li><a href="../Contact.html">Contact Us</a></li>
        <li><a href="../LogoutAdmin">Logout</a></li>
       </ul>

    </div>
  </div>
</nav>

<body style="background-image: url('../images/wooden-table-with-blurred.jpg');">
<!-- <div class="admin_container"> -->

		<%
			response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		
			if(session.getAttribute("admin")==null)
			{
				response.sendRedirect("../index.html");
			} 
		%>
 <h3 style="color: white">Add Librarian</h3>
  <form action="../AddLibrarian" method="post" style="width:400px">
  <div class="form-group">
    <label for="name1">Name</label>
    <input type="text" class="form-control" name="name" id="name1" placeholder="Name"/>
  </div>
  <div class="form-group">
    <label for="email1">Email address</label>
    <input type="email" class="form-control" name="email" id="email1" placeholder="Email"/>
  </div>
  <div class="form-group">
    <label for="password1">Password</label>
    <input type="password" class="form-control" name="password" id="password1" placeholder="Password"/>
  </div>  
  <div class="form-group">
    <label for="mobile1">Mobile Number</label>
    <input type="number" class="form-control" name="mobile" id="mobile1" placeholder="Mobile"/>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
 

<!-- </div> -->

</body>
</html>