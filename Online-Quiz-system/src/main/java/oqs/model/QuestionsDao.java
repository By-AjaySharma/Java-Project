package oqs.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import oqs.db.Provider;
import oqs.db.Questions;
import oqs.db.Students;

public class QuestionsDao {

	public static boolean insertQuestion(Questions q) {
		// TODO Auto-generated method stub
		boolean status = false;
		try
		{
		
		Connection con = Provider.getJdbcConnection();
		String sql = "insert into questiontable values(?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
	    pst.setString(1, q.getQuestion().trim());
	    pst.setString(2, q.getA());
	    pst.setString(3, q.getB());
	    pst.setString(4, q.getC());
	    pst.setString(5, q.getD());
	    pst.setString(6, q.getAnswer());
	   // pst.setString(7,"e");
	    
	    int val = pst.executeUpdate();
	    if(val > 0)
	    {
	    	status =true;
	    }
	    else
	    {
	    	status = false;
	    }
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	public static ArrayList<Questions> getAllRecords()
	{
        ArrayList<Questions>  samp =new ArrayList<Questions>();
		try
		{
			
		   samp.clear();
		   Connection con = Provider.getJdbcConnection();
		   String sql = "select * from questiontable";
		   PreparedStatement pst = con.prepareStatement(sql);
		   
		   ResultSet rs = pst.executeQuery(sql);
		   while(rs.next())
		   {
			  Questions s = new Questions();
			  s.setQuestion(rs.getString(1));
			  s.setAnswer(rs.getString(6));
			  s.setA(rs.getString(2));
			  s.setB(rs.getString(3));
			  s.setC(rs.getString(4));
			  s.setD(rs.getString(5));
			   samp.add(s);
			 
			  
			   
		   }
		  

		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return samp;
	}
	public static boolean deleteRecord(Questions q)
	{
		boolean status = false;
		try
		{
		
		Connection con = Provider.getJdbcConnection();
		String sql = "delete from questiontable where question=?";
		PreparedStatement pst = con.prepareStatement(sql);
	    pst.setString(1, q.getQuestion());
	  
	    
	    int val = pst.executeUpdate();
	    if(val > 0)
	    {
	    	status = true;
	    }
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
		
	}
	public static boolean doUpdateNowRecord(String OriginalQuestion,String newQuestion,String opta,String optb,String optc,String optd,String ans)
	{
		boolean status = false;
		try
		{
		
		Connection con = Provider.getJdbcConnection();
		String sql = "update questiontable set question=?,optionA=?,optionB=?,optionC=?,optionD=?,answer=? where question=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1,newQuestion);
		pst.setString(2, opta);
		pst.setString(3, optb);
		pst.setString(4, optc);
		pst.setString(5, optd);
		pst.setString(6, ans);
		pst.setString(7, OriginalQuestion);
	
		int val = pst.executeUpdate();
		if(val > 0)
		{
			status = true;
		}
		}
		catch(Exception f)
		{
			f.printStackTrace();
		}
		
	    
		return status;
	}
	

}
