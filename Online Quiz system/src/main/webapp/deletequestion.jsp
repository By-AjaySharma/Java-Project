<%--Document : deletequestion--%>

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
<title>Delete Questions</title>
</head>
<body>
<%
		Questions q = new Questions();
		q.setQuestion(request.getParameter("ques"));
		boolean status = QuestionsDao.deleteRecord(q);
		if(status)
		{
			String msg="!! Question Deleted Successfully !!";
			response.sendRedirect("QuestionList.jsp?msgGreen="+msg);
		}
		else{
			String msg="!! Fail to Deleted Question !!";
			response.sendRedirect("QuestionList.jsp?msgGreen="+msg);
		}
			
		
	%>
	<%} %>
</body>
</html>