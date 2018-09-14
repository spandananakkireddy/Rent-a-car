<%-- 
    Document   : login
    Author     : SPANDANA
--%>

<%@include file="header.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section id="how">
	<br />
	<div class="container">

		<c:if test="${Message!=null}">
			<div class="row">
				<div class="col-md-offset-4 col-md-5">
					<div class="alert alert-info alert-dismissable">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<strong>${Message}</strong>
					</div>
				</div>
			</div>
		</c:if>
		<form class="form-horizontal" action="SendEmail" method="post">

			<input type="hidden" name="action" value="login" />
			<div class="form-group">
				<label class="col-sm-4 control-label">Enter Email: </label>
				<div class="col-sm-4">
					<input type="email" class="form-control" name="email" required />
				</div>
			</div>

			<div class='col-md-offset-3'>
				<input type="submit" name="submit" value="Submit"
					class="btn btn-primary btn-lg" />
			</div>
		</form>
	</div>

</section>
<%-- Include tag is used to import footer page --%>
<%@include file="footer.jsp"%>
