<%-- 
    Document   : main
    Author     : SPANDANA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="headerl.jsp"%>

<br />
<h1 id='h'>Hi There ${username} !!</h1>
<br />
<section id="how">

	<form name="user" action="CarServlet" method="post">

		<a href="CarServlet?action=viewcarsbyuser&amp;uemail=${username}"><h3
				id='admin'>View Available Cars</h3></a><br> <a
			href="CarServlet?action=editprofile&amp;uemail=${username}"><h3
				id='admin'>Edit Profile</h3></a><br>


	</form>
</section>
<%@include file="footer.jsp"%>
