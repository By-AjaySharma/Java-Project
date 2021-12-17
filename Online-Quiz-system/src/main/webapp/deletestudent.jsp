<%--Document   : deletestudent--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="oqs.db.*" %>
    <%@page import="oqs.model.*" %>
    
<%
if(session.getAttribute("name")==null)
	{
	String msg = "!! Please Login as Admin to Continue !!";
	response.sendRedirect("AdminLogin.jsp?msgRed="+msg);

	}else{

%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Student</title>
</head>
<body>
<%
		Students s = new Students();
		s.setEmail(request.getParameter("emailId"));
		boolean status = StudentsDao.deleteRecord(s);
		if(status){
			String msg="!! Successfully Deleted !!";
			response.sendRedirect("StudentList.jsp?msgGreen="+msg);
		}
		else{
			String msg="!! Fail to Deleted !!";
			response.sendRedirect("StudentList.jsp?msgRed="+msg);
		}
	%>
	
	<%} %>
</body>
</html>

