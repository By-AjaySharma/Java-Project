<%--Document : updateinstructionnow--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
                <%@page import="oqs.model.InstructionsDao"%>
<%@page import="oqs.db.Instructions"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Updating Instructions</title>
</head>
<body>
<%

		if(session.getAttribute("name")==null)
		{
		String msg = "!! Please Login as Admin to Continue !!";
		response.sendRedirect("AdminLogin.jsp?msgRed="+msg);
		
		}else{
			String instoriginal = request.getParameter("instoriginal");
	        String instmodified = request.getParameter("instamodified");
	     
			boolean status = InstructionsDao.doUpdateNowRecord(instoriginal,instmodified);
			if(status)
			{
				String msg="!! Successfully Updated !!";
				response.sendRedirect("InstructionList.jsp?msgGreen="+msg);
			}
			else
			{
				String msg="!! Fail to Updated !!";
				response.sendRedirect("updateinstruction.jsp?msgRed="+msg);
			}
		}
		
	%>
</body>
</html>