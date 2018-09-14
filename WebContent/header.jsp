<%-- 
    Document   : header
    Author     : SPANDANA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RENT-A-CAR</title>
<link rel="stylesheet" href="styles/main.css">
<script type="text/javascript" src="js/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>

<!-- BootStrap -->

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script type="text/javascript">
	
</script>
</head>
<body>
	<%-- Code to specify Header section of the page--%>
	<div id="header">
		<nav id="header_menu">
			<ul class="left">
				<li><a class="maintitle" href="index.jsp">RENT A CAR</a></li>
			</ul>
			<ul class="right">

				<li><a href="about.jsp">About Us</a></li>
				<li><a href="register.jsp">Register Now</a></li>
				<li><a href="login.jsp">Login</a></li>
				<li><a href="contact.jsp">Contact</a></li>

			</ul>
		</nav>
	</div>
</body>
</html>
