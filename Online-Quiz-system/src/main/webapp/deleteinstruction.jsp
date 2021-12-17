<%--Document   : deleteinstruction--%>
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
<title>Delete Instructions</title>
</head>
<body>
<%
		Instructions i = new Instructions();
		i.setInstruction(request.getParameter("inst"));
		boolean status = InstructionsDao.deleteRecord(i);
		if(status){
			String msg="!! Successfully deleted !!";
			response.sendRedirect("InstructionList.jsp?msgGreen="+msg);
		}
		else{
			String msg="!! Fail to deleted !!";
			response.sendRedirect("InstructionList.jsp?msgRed="+msg);
		}
			
		
	%>
	<%} %>
</body>
</html>