package oqs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oqs.model.*;

@WebServlet("/controller.UpdateQuestion")
public class UpdateQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
		 String OriginalQuestion = request.getParameter("quesoriginal");
			String newQuestion = request.getParameter("quesmodified");
	        String opta = request.getParameter("opta");
	        String optb = request.getParameter("optb");
	        String optc = request.getParameter("optc");
	        String optd = request.getParameter("optd");
	        String ans = request.getParameter("ans");
			
	        boolean status=QuestionsDao.doUpdateNowRecord(OriginalQuestion, newQuestion, opta, optb, optc, optd, ans);
	        if(status)
			{
	        	String msg="!! Successfully Update !!";
				response.sendRedirect("QuestionList.jsp?msgGreen="+msg);
			}
			else
			{
				String msg="!! Fail to Update !!";
				response.sendRedirect("updatequestion.jsp?msgRed="+msg);
			}
	}



}
