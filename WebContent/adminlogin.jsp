<%-- 
    Document   : adminlogin
    Author     : SPANDANA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="header.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AdminLogin</title>
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
	<section id='how'>
		<form class="form-horizontal" action="CarServlet" method="post">
			<div class="container">
				<div class="section-header">
					<br>
					<p class="section-title text-center wow fadeInDown">Login As
						Admin here</p>
				</div>

				<input type="hidden" name="action" value="login">
				<div class="form-group">
					<label class="col-sm-4 control-label">Username *</label>
					<div class="col-sm-4">
						<input type="text" name="adminname" class="form-control"
							title='select your user name' required />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-4 control-label">Password *</label>
					<div class="col-sm-4">
						<input type="password" name="adminpassword" class="form-control"
							title='select your password' required />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-10">
						<input type="submit" name="adminlogin" value="Sign in"
							class="btn btn-primary">
					</div>
				</div>
			</div>
		</form>
	</section>
</body>
</html>
<%@include file="footer.jsp"%>
