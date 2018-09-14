<%-- 
    Document   : confirmdelete
    Author     : SPANDANA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="headerl.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>Confirm Delete</title>
</head>
<body>
	<section id="how">
		<form action="CarServlet" method="post">
			<h3>Delete this product?</h3>
			<blockquote>
				<label>Car Name: ${car.getCarName()}</label><br> <label>Price:
					${car.getPrice()}</label><br>
			</blockquote>
			<input type="submit" name="Yes" value="Yes"
				class="btn btn-primary btn-sm" /><input type="hidden" name="carId"
				value="${car.getCarId()}">&nbsp;&nbsp; <input type="submit"
				name="No" value="No" class="btn btn-primary btn-sm" />

		</form>
	</section>
</body>
</html>
<%@include file="footer.jsp"%>