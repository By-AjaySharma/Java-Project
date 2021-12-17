<%--Document : StudentList--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="oqs.model.*"%>
<%@page import="oqs.db.Students"%>
<%@page import="java.util.ArrayList"%>

<%
if(session.getAttribute("name")==null)
	{
	String msg = "!! Please Login as Admin to Continue !!";
	response.sendRedirect("AdminLogin.jsp?msgRed="+msg);

	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<center><h3><pre><font color="blue">List of all Users</font></h3></pre></center>
<center>
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
<table class="table table-bordered table-hover">
<tr tr class="table-dark">
 <th>s no.</th>
 <th>Name</th>
 <th>Email ID</th>
 <th>Password</th>
 <th>Delete</th>
</tr>
<tr>
<%
   int i = 0;
   ArrayList<Students> allstudents = StudentsDao.getAllRecords();
  for(Students e : allstudents)
  {   
	  
  
  %>
   <tr>
  <td><%=++i%></td>
  <td><%=e.getName() %></td>
  <td><%=e.getEmail()%></td>
  <td><%=e.getPassword() %></td>
  <td><center> <a href="deletestudent.jsp?emailId=<%=e.getEmail()%>"><input type="button"class="btn btn-danger" value="Delete"></a></center></td>

  </tr>
  <%
  }
  %>
<tr>

<th colspan="5"  ><center><input type="button"  class="btn btn-outline-danger" value="Back to Panel" onclick="location.href='AdminPanel.jsp'"></center></th>
</tr>
</table>

</body>
</html>

