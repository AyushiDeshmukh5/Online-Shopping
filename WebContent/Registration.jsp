<html>
<script language="JavaScript">
function show(){
	alert("This app is used for online shopping");
}</script>
<body>
<h3>Online Shopping</h3>
<h3>Registration-Form</h3>
<hr>

<form action = "RegistrationServlet" method="post">
<input type="button" value="Info" name="b1" onclick="show()"/>
<table border="1">
<tr>
<td>Email</td><td><input type = "text" name = "email"/></td>
</tr>

<tr>
<td>Password</td><td><input type = "password" name="password"></td>
</tr>
<tr>
<td>Name</td><td><input type="text" name="name"/></td>
</tr>
<tr>
<td>Address</td><td><input type="text" name="address"/></td>
</tr>
<tr>
<td>City</td><td><input type = "text" name="city"/></td>
</tr>
<tr>
<td>State</td><td><input type = "text" name="state"/></td>
</tr>
<tr>
<td>Mobile number</td><td><input type = "text" name="mobile"/></td>
</tr>


<!--  fir choosing multiple cities
<tr>
<td>City</td><td><select name="city" multiple="multiple">
<option>Indore</option>
<option>Pune</option>
<option>Noida</option>
<option>Banglore</option>

</select></td>
</tr>-->

<!--  
<tr>
<td>Photo</td><td><input type="file" name="photo"></td>
</tr>-->
<tr>
<td><input type = "submit" value="Register"/></td>
<td><input type = "reset" value="Reset"/></td>
</tr>
</table>
</form>
<hr>
<a href="index.jsp">Home</a>
</body>

</html>