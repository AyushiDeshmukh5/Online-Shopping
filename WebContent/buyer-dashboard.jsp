<%
int n = session.getMaxInactiveInterval();
//Authentication
String email = (String)session.getAttribute("uid");
if(email==null){
	response.sendRedirect("index.jsp");
}
%>


<html>
<body>
<h3>Welcome <%=email %>r</h3>

<%=n%>
<hr>
<a href="CategoryServlet">Explore-Store</a>
<a href="DisplayCart">View-Cart</a>

<a href="Logout">Logout</a>
<hr>
</body>
</html>