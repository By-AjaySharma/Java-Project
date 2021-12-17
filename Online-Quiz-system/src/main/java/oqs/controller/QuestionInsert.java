package oqs.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import oqs.db.Questions;
import oqs.model.QuestionsDao;

/**
 * implementation class QuestionInsert
 */
@WebServlet("/controller.QuestionInsert")
public class QuestionInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public QuestionInsert() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String question = request.getParameter("Question");
		String a = request.getParameter("option1");
		String b = request.getParameter("option2");
		String c = request.getParameter("option3");
		String d = request.getParameter("option4");
		String answer = request.getParameter("answer");
		
		Questions q = new Questions();
		q.setA(a);
		q.setB(b);
		q.setC(c);
		q.setD(d);
		q.setAnswer(answer);
		q.setQuestion(question);
		
		boolean status = QuestionsDao.insertQuestion(q);
		
		if(status)
		{
			String msg = "Question Added";
	    	response.sendRedirect("AddQuestion.jsp?msgGreen="+msg);
		}
		else
		{
			String msg = "Question not Added";
	    	response.sendRedirect("AddQuestion.jsp?msgRed="+msg);
		}
		
		
		
	
	}

}