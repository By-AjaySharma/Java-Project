package oqs.controller;
// Importing lib
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oqs.db.Admins;
import oqs.model.AdminsDao;

@WebServlet("/controller.ValidateAdmin")
public class ValidateAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
        public ValidateAdmin() {
        super();
        }
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String email = request.getParameter("uname");
		String password = request.getParameter("pass");
		

		
		Admins ad = new Admins(); // Creating object
		ad.setEmail(email);
		ad.setPassword(password);
		
	    boolean status = AdminsDao.doValidate(ad);
	    
	    if(status)
	    {
	    
	    	//Logged in  as admin do something (pending)
	    	 HttpSession session = request.getSession();
			 session.setAttribute("email", ad.getEmail());
			 session.setAttribute("name", ad.getName());
			 response.sendRedirect("AdminPanel.jsp");
	    }
	    else
	    {
	    	String msg = "!! Invalid Username or Password !!";
	    	response.sendRedirect("AdminLogin.jsp?msgRed="+msg);
	    }
		
		
	}

}
