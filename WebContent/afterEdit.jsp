<%-- 
    Document   : afterEdit
    Author     : SPANDANA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="headerl.jsp"%>

<body>
	<section id="how">
		<div class="container">
			<h3>Profile edited as:</h3>

			<label>First Name: ${cust.name}</label><br> <label>Address:
				${cust.getAddress()}</label><br> <label>City: ${cust.city}</label><br>
			<label>State: ${cust.state}</label><br> <label>Zip code:
				${cust.zipcode}</label><br> <b
				style="color: black; padding-left: auto; font-size: 20px;"> <a
				href="main.jsp">Back</a></b>
		</div>
	</section>
</body>



<%@include file="footer.jsp"%>