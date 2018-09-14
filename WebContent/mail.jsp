<%-- 
    Document   : mail
    Author     : SPANDANA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="headerl.jsp"%>

<br>
<br>
<section id="mail">

	<h3>Car Reserved!!</h3>
	<form action="EmailServlet" method="post">

		<label class="pad_top" style='color: #cc0000'>Email:</label> <input
			type="email" name="email"><br> <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit"
			value="send confirmation" class="btn btn-primary btn-lg">

	</form>

</section>

<%@include file="footer.jsp"%>