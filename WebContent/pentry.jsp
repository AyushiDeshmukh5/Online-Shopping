<html>
<script language="JavaScript">
function show(){
	alert("This app is used for online shopping");
}</script>
<body>
<h3>Book Bazaar</h3>
<h3>Registration-Form</h3>
<hr>

<form action = "SaveProduct" method="post">
<input type="button" value="Info" name="b1" onclick="show()"/>
<table border="1">
<tr>
<td>Code</td><td><input type = "text" name = "code"/></td>
</tr>

<tr>
<td>Name</td><td><input type = "text" name="name"></td>
</tr>
<tr>
<td>Description</td><td><input type="text" name="description"/></td>
</tr>
<tr>
<td>Price</td><td><input type="text" name="price"/></td>
</tr>
<tr>
<td>Category</td><td><select name="category">


<option>Action and Adventure</option>
<option>Horror</option>
<option>Self-Help</option>
<option>Romance novel</option>
<option>Memoir</option>
<option>Historical fiction</option>
<option>Detective and Mystery</option>
<option>Classics</option>
<option>Comic book</option>
</select></td>
</tr>

<tr>
<td><input type = "submit" value="Save"/></td>
<td><input type = "reset" value="Reset"></td>
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

</table>
</form>
<hr>
<a href="owner-dashboard.jsp">Owner-Dashboard</a>
</body>

</html>


