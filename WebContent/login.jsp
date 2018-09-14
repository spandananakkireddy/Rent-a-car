<%-- 
    Document   : login
    Author     : SPANDANA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
<%-- Section to input login details --%>

<%-- Code to create login form--%>
</br>
<section id="how">
	</br>
	<form class="form-horizontal" action="CarServlet" method="post">

		<input type="hidden" name="action" value="login">
		<div class="form-group">
			<label class="col-sm-4 control-label">Email Address *</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" name="username" required />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Password *</label>
			<div class="col-sm-4">
				<input class="form-control" type="password" name="password" required />
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-10">
				<input type="submit" name="login" value="Log in"
					class="btn btn-primary"> <a href="forgotpassword.jsp"
					id="forgot_password_link">Forgot Password?</a>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-10">
				<a href="adminlogin.jsp" id='admin'>Admin? Login here</a><br>
			</div>
		</div>
	</form>
	<br />
	<p class="error">${msg}</p>

</section>

<%-- Include tag is used to import footer page --%>
<%@include file="footer.jsp"%>
