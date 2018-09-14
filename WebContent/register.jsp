<%-- 
    Document   : register
    Author     : SPANDANA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>

<%--Code to signup form --%>
<section id="register">
	<br /> <br /> <br />
	<form class="form-horizontal" action="CarServlet" method="post">

		<input type="hidden" name="action" value="create" />
		<div class="form-group">
			<label class="col-sm-4 control-label">Name *</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" value="${CarServlet.name}"
					name="name" required />
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-4 control-label">Address *</label>
			<div class="col-sm-4">
				<input type="text" class="form-control"
					value="${CarServlet.address}" name="address" required />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">City *</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" value="${CarServlet.city}"
					name="city" required />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">State *</label>
			<div class="col-sm-4">
				<input type="text" class="form-control" value="${CarServlet.state}"
					name="state" required />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Zipcode *</label>
			<div class="col-sm-4">
				<input type="text" class="form-control"
					value="${CarServlet.zipcode}" name="zipcode" required />
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-4 control-label">Email *</label>
			<div class="col-sm-4">
				<input type="email" class="form-control" value="${CarServlet.email}"
					name="email" required />
			</div>
		</div>

		<div class="form-group">
			<label class="col-sm-4 control-label">Password *</label>
			<div class="col-sm-4">
				<input type="password" class="form-control"
					value="${CarServlet.password}" name="password" required />
			</div>
		</div>

		<div class='col-md-offset-3'>
			<input type="submit" name="register" value="Register"
				class="btn btn-primary btn-lg" />
		</div>
		<br /> <br />
		<p class="error">${msg}</p>

		<br />

	</form>
</section>

<%-- Include tag is used to import footer page --%>
<%@include file="footer.jsp"%>