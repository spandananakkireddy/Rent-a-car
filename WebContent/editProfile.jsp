<%-- 
    Document   : editProfile
    Author     : SPANDANA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="headerl.jsp"%>
<body>
	<section id="editp">
		<div class="section-header">
			<br>
			<h3 class="section-title text-center wow fadeInDown"
				style='right: 40%'>Edit Profile</h3>
		</div>

		<form class="form-horizontal" action="CarServlet" method="post">
			<div class="form-group">
				<label class="col-md-3 control-label"><h4>Name</h4></label>
				<div class="col-md-8">
					<input type="text" name="name" value="${cust.name}"
						class="form-control" title='select your user name'>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-3 control-label"><h4>Address</h4></label>
				<div class="col-md-8">
					<input type="text" name="address" value="${cust.getAddress()}"
						class="form-control" title='select your user name'>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label"><h4>City</h4></label>
				<div class="col-md-8">
					<input type="text" name="city" value="${cust.city}"
						class="form-control" title='select your user name'>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label"><h4>State</h4></label>
				<div class="col-md-8">
					<input type="text" name="state" value="${cust.state}"
						class="form-control" title='select your user name'>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label"><h4>Zipcode</h4></label>
				<div class="col-md-8">
					<input type="text" name="zipcode" value="${cust.zipcode}"
						class="form-control" title='select your user name'>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label"><h4>Email</h4></label>
				<div class="col-md-8">
					<input type="text" name="email" value="${cust.email}"
						class="form-control" title='select your user name'>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-3 control-label"><h4>Password</h4></label>
				<div class="col-md-8">
					<input type="password" name="password" value="${cust.password}"
						class="form-control" title='select your password'>
				</div>
			</div>
			<br />
			<div class='col-md-offset-3'>
				<input type="submit" name="UpdateCustomer" value="edit profile"
					class="btn btn-primary btn-lg" />
			</div>
		</form>
		<br /> <br />
	</section>
</body>




<%@include file="footer.jsp"%>