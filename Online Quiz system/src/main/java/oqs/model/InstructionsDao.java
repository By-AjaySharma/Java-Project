package oqs.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import oqs.db.*;


public class InstructionsDao {

	public static boolean insertInstruction(Instructions ist) {
		// TODO Auto-generated method stub
		boolean status = false;
		try
		{
		
		Connection con = Provider.getJdbcConnection();
		String sql = "insert into instructiontable values(?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1,ist.getInstruction());

		int val = pst.executeUpdate();
		if(val > 0)
		{
			status = true;
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
	public static ArrayList<Instructions> getAllRecords()
	{
        ArrayList<Instructions>  samp =new ArrayList<Instructions>();
		try
		{
			
		   samp.clear();
		   Connection con = Provider.getJdbcConnection();
		   String sql = "select * from instructiontable";
		   PreparedStatement pst = con.prepareStatement(sql);
		   
		   ResultSet rs = pst.executeQuery(sql);
		   while(rs.next())
		   {
			  Instructions i = new Instructions();
			   i.setInstruction(rs.getString(1));
			   samp.add(i);
			 
			  
			   
		   }
		  

		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return samp;
	}
	public static boolean deleteRecord(Instructions ist) {
		// TODO Auto-generated method stub
		boolean status = false;
		try
		{
		
		Connection con = Provider.getJdbcConnection();
		String sql = "delete from instructiontable where instruction=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1,ist.getInstruction());

	    int val = pst.executeUpdate();
	    if(val>0) {
	    	status=true;
	    }
	    
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	public static boolean doUpdateNowRecord(String instaoriginal,String instamodified)
	{
		boolean status = false;
		try
		{
		
		Connection con = Provider.getJdbcConnection();
		String sql = "update instructiontable set Instruction=? where Instruction=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1,instamodified);
		pst.setString(2, instaoriginal);
	
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
