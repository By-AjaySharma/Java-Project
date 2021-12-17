package oqs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oqs.db.*;
import oqs.model.StudentsDao;


@WebServlet("/controller.StudentSignup")
public class StudentSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		String sName=request.getParameter("uname");
		String sEmail=request.getParameter("uemail");
		String sPass=request.getParameter("pass");
		String sCPass=request.getParameter("cpass");
		

		
		if(sPass.equals(sCPass)) {
			boolean status=StudentsDao.SigupStudent(sName, sEmail,sPass);
			if(status) {
				String msg1 ="!! Account Created Successfully !!";
		    	response.sendRedirect("StudentLogin.jsp?msgGreen="+msg1);
			}
			else {
				String msg = "!! Email Id Already Used !!";
		    	response.sendRedirect("StudentSignup.jsp?msgRed="+msg);
			}
			
		}else {
			String msg = "!! Password and Confirm Password not Match !!";
	    	response.sendRedirect("StudentSignup.jsp?msgRed="+msg);
		}
		
	}

}
