<%-- 
    Document   : viewcars
    Author     : SPANDANA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="headerl.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DisplayCarsToUser</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	<div class="container">
		<h3>
			<i> ${username}, you have the following options</i>
		</h3>
		<form action="CarServlet" method="post">

			<table class="table">
				<tr>
					<th>CarId</th>
					<th>CarName</th>
					<th>Price per day</th>
					<th></th>

				</tr>
				<c:forEach var="car" items="${carList}">
					<tr>
						<td>${car.getCarId()}</td>
						<td>${car.getCarName()}</td>
						<td>${car.getPrice()}</td>

						<td><a
							href="CarServlet?action=rentcar&amp;carId=${car.getCarId()}&amp;uemail=${username}">Rent</a></td>

					</tr>
				</c:forEach>

				<!-- Hint! Remember to code for the 'Edit' and 'Delete' links -->
			</table>

		</form>
		<br /> <br />
	</div>
</body>
</html>




<%@include file="footer.jsp"%>
