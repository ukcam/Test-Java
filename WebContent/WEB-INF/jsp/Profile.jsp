<%@ page contentType = "text/html; charset = UTF-8" %>
<html>

	<!-- Page that displays the profile details -->
   <head>
      <title>Profile</title>
      <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1">
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   </head>
   <style>
	   .superDiv{
	   	margin-top: 100px;
	   }
   </style>
   <body>
   <div class="superDiv">
      <div class="container panel panel-default">
	      <img src="${picture}">
	      <b>${completeName}</b>
	      <br/>
	      <br/>
		      <div class="row">
			    <div class="col-sm-1">
			      ID:
			    </div>
			    <div class="col-sm-11">
			      ${id}
			    </div>
			    <div class="col-sm-1">
			      profile
			    </div>
			    <div class="col-sm-11">
			     ${profile}
			    </div>
			    <div class="col-sm-1">
			      email
			    </div>
			    <div class="col-sm-11">
			     ${email}
			    </div>
			    <div class="col-sm-1">
			      phone
			    </div>
			    <div class="col-sm-11">
			     ${phone}
			    </div>
			    <div class="col-sm-1">
			      address
			    </div>
			    <div class="col-sm-11">
			     ${address}
			    </div>
			    <div class="col-sm-1">
			      age
			    </div>
			    <div class="col-sm-11">
			     ${age}
			    </div>
			    <div class="col-sm-1">
			      balance
			    </div>
			    <div class="col-sm-11">
			     ${balance}
			    </div>
			  </div>
      </div>
     </div>
   </body>
</html>