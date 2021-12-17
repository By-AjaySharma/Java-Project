<%--Document:AdminLogin--%>
<!DOCTYPE html>
<html>
<head>
<link href="bootstrap.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<style type="text/css">
	li
	{
		float: left;
	}
	ul
	{
	
		list-style-type: none;
		margin: 0;
		padding: 0;
		overflow: hidden;
		background-color:#333; 
	}
	li a
	{
		display: inline-block;
		color: white;
		text-align: center;
		padding: 14px 16px;
		text-decoration: none; 
	}
	li a:HOVER {
	background-color: aqua;
}
</style>
<title>Admin Login</title>

</head>
<body><center>
	<font color="blue"><h1>Admin Login</h1></font>
	<font color="red" >
		<%
			if(request.getParameter("msgRed") != null)
				out.print(request.getParameter("msgRed"));
		%>
		</font>
			<font color="green" >
		<%
			if(request.getParameter("msgGreen") != null)
				out.print(request.getParameter("msgGreen"));
		%>
		</font>
		</center>
	<form action="controller.ValidateAdmin" method="post" style="margin-left:auto;margin-right:auto;width:500px;">
		<pre>
		<table>
		<tr>
		<td>	  Admin Id   :   </td>
		<td><input type="text" placeholder="Enter EmailId" name="uname"></td>
		</tr>
		
		<tr>
		<td>	  Password  :   </td>
		<td><input type="password" placeholder="Enter Password" name="pass"></td>
		</tr>
		<tr>
		<td><br></td>
		<td><br><input  onclick="location.href='index.html'" type="button" value="Exit" class="btn btn-outline-primary">          <input type="submit" value="Login" class="btn btn-outline-primary"></td>
		</tr>
		
		</table>
			
		</pre>
	</form>

</body>
</html>


















