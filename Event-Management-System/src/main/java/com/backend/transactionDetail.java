package com.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewTransaction")
public class transactionDetail extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
         out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title> Transactions Page</title>");
    out.println("<link rel=\"stylesheet\" href=\"total.css\">");
    out.println("<link href=\"https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap\" rel=\"stylesheet\">");
    out.println("</head>");
    out.println("<body>");
        
        try{
        	String url="jdbc:mysql://localhost:3366/user_info";
			String id="root";
			String pass="1234";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,id, pass);
                 
                 Statement st=con.createStatement();
         		ResultSet rs=st.executeQuery("select * from register_user"); 
                 
                 out.println("<center><h1> Transaction  Details </h1> </center> ");
                
                 out.println("<div>");
                
                 out.println("<center>");
                 out.println("<table border=1 width=50% height=50%>");  
                 out.println("<tr><th>Event Name</th><th>Event No</th><th>Name</th><th>Card No</th>");  
             
                 while (rs.next()) 
                   {  
                      
                    String en = rs.getString("eventName");
                    String re = rs.getString("eventId");
                    String pd  = rs.getString("cardNo");
                    String name =rs.getString("cardHolderName");
                   
                    out.println("<tr><td>" + en + "</td><td>" + re + "</td><td>"+name+"</td><td>" + pd +"</td></tr>");   
                   }
                
                 con.commit();
                 con.close(); 
                 out.println("</table>"); 
                 out.println("</h3></center>");
                 out.println("</div>");
                 out.print("</body>");
                 out.print("</html>");
                 
                 
                 
            }    
        catch(Exception exe){System.out.println("Exception caught");}
    }
}