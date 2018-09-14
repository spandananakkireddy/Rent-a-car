<%-- 
    Document   : cars
    Author     : SPANDANA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="headerl.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cars</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/animate.min.css" rel="stylesheet">
<link href="css/owl.carousel.css" rel="stylesheet">
<link href="css/owl.transitions.css" rel="stylesheet">
<link href="css/prettyPhoto.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<link rel="shortcut icon" href="images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="images/ico/apple-touch-icon-57-precomposed.png">

</head>
<body>
	<div class="container">
		<form action="CarServlet" method="post">
			<table class="table">
				<tr>
					<th>Car Id</th>
					<th>Car Name</th>
					<th>Price</th>
					<th></th>
					<th></th>

				</tr>
				<c:forEach var="car" items="${carList}">
					<tr>
						<td>${car.getCarId()}</td>
						<td>${car.getCarName()}</td>
						<td>${car.getPrice()}</td>
						<td><a
							href="CarServlet?action=edit&amp;carId=${car.getCarId()}">Edit</a></td>
						<td><a
							href="CarServlet?action=delete&amp;carId=${car.getCarId()}">Delete</a></td>
					</tr>
				</c:forEach>
				<!-- Hint! Remember to code for the 'Edit' and 'Delete' links -->
			</table>
			<br> <a href='addcar.jsp'>Add Car</a><br>
		</form>
		<!-- Hint! You need to code a form for the 'Add Product' button -->
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="http://maps.google.com/maps/api/js?sensor=true"></script>
		<script src="js/owl.carousel.min.js"></script>
		<script src="js/mousescroll.js"></script>
		<script src="js/smoothscroll.js"></script>
		<script src="js/jquery.prettyPhoto.js"></script>
		<script src="js/jquery.isotope.min.js"></script>
		<script src="js/jquery.inview.min.js"></script>
		<script src="js/wow.min.js"></script>
		<script src="js/main.js"></script>
	</div>

</body>
</html>

<%@include file="footer.jsp"%>