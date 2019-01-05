<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<!-- Page that displays the list -->
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<style>
			.divBorder{
				border-style: groove;
			}
		</style>
	</head>
	<body>
		<h2>Home Page</h2>
		
		<!-- Script for the search bar -->
		<script>
			$(document).ready(function(){
			  $("#myInput").on("keyup", function() {
			    var value = $(this).val().toLowerCase();
			    $("#myTable tr").filter(function() {
			      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
			    });
			  });
			});
		</script>
		<input id="myInput" type="text" placeholder="Search..">
		<br/><br/>
		<div class = "divBorder">
		
			<!-- table for the data -->
			<table class="table table-striped">
				<thead>
			      <tr>
					<th>Name</th>
					<th>Age</th> 
					<th>Active</th>
					<th>Blocked</th>
				</tr>
			    </thead>
			    <tbody id="myTable">
			    	<!-- iteration of the people List -->
					<c:forEach var="listValue" items="${lists}">
					<tr>
						<!-- if the name is clicked it will redirect to another JSP page that contains the profile details -->
						<td><a href="<c:url value='/Profile/${listValue.id}'/>">${listValue.completeName}</a></td>
						<td class = "tdAge">${listValue.age}</td>
						<!-- if the active boolean is true it will display a checkbox that is checked -->
						<td class = "tdActive">
							<c:choose>
							    <c:when test="${listValue.active}">
							        <input type="checkbox" checked>
							    </c:when>    
							    <c:otherwise>
							        <input type="checkbox">
							    </c:otherwise>
							</c:choose>
						</td>
						<!-- if the blocked boolean is true it will display a checkbox that is checked -->
						<td class = "tdBlocked">
							<c:choose>
							    <c:when test="${listValue.blocked}">
							        <input type="checkbox" checked>
							        <br />
							    </c:when>    
							    <c:otherwise>
							        <input type="checkbox">
							        <br />
							    </c:otherwise>
							</c:choose>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>