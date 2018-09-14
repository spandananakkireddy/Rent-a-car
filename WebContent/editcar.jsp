<%-- 
    Document   : editcar
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

<title>Editcar</title>


<section id=how>

	<form class="form-horizontal" action="CarServlet" method="post">

		<div class="section-header">
			<p class="section-title text-center wow fadeInDown">Edit car</p>
		</div>
		<div class="form-group">
			<label class="col-md-3 control-label"><h4>Car Id</h4></label>
			<div class="col-md-8">
				<input type="text" name="cid" class="form-control"
					value="${car.getCarId()}" title='select your password'>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-3 control-label"><h4>Car name</h4></label>
			<div class="col-md-8">
				<input type="text" name="cname" class="form-control"
					value="${car.getCarName()}" title='select your password'>
			</div>
		</div>
		<div class="form-group">
			<label class="col-md-3 control-label"><h4>Price</h4></label>
			<div class="col-md-8">
				<input type="text" name="price" class="form-control"
					value="${car.getPrice()}" title='select your password'>
			</div>
		</div>

		<div class='col-md-offset-3'>
			<input type="submit" name="UpdateExist" value="Update Car"
				class="btn btn-primary btn-lg" />

		</div>
	</form>
</section>

<%@include file="footer.jsp"%>