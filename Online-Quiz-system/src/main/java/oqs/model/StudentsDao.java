package oqs.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import oqs.db.Provider;
import oqs.db.Students;

public class StudentsDao {

	public static boolean doValidate(Students sd) {
		// TODO Auto-generated method stub
		boolean status = false;
		try
		{
		
		Connection con = Provider.getJdbcConnection();
		String sql = "select * from userinfo where emailId=? and password=?";//SQL
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, sd.getEmail());
		pst.setString(2, sd.getPassword());
		ResultSet rs = pst.executeQuery();
		
		if(rs.next())
		{
			sd.setName(rs.getString("Name"));
			status = true;
		}
		else
		{
			status = false;
		}
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}

	public static boolean SigupStudent(String name ,String email,String pass) {
		// TODO Auto-generated method stub
		boolean status = false;
		try
		{
		
		Connection con = Provider.getJdbcConnection();
		String sql = "insert into userinfo values(?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, name);
		pst.setString(2, email);
		pst.setString(3, pass);
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
			status = false;
		}
		return status;
	}
	
	public static ArrayList<Students> getAllRecords()
	{
        ArrayList<Students>  samp =new ArrayList<Students>();
		try
		{
			
		   samp.clear();
		   Connection con = Provider.getJdbcConnection();
		   String sql = "select * from userinfo";
		   PreparedStatement pst = con.prepareStatement(sql);
		   
		   ResultSet rs = pst.executeQuery(sql);
		   while(rs.next())
		   {
			  Students s = new Students();
			  s.setName(rs.getString("Name"));
			   s.setEmail(rs.getString("emailId"));
			  s.setPassword(rs.getString("password"));
			  
			   samp.add(s);
			 
			  
			   
		   }
		  

		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return samp;
	}
	public static boolean deleteRecord(Students st) {
		// TODO Auto-generated method stub
		boolean status = false;
		try
		{
		
		Connection con = Provider.getJdbcConnection();
		String sql = "delete from  userinfo where emailId=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, st.getEmail());
	
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
	public static String getStudentName(String email) {
		// TODO Auto-generated method stub
		String name = null;
		try
		{
		
		Connection con = Provider.getJdbcConnection();
		String sql = "select name from userinfo where emailId=?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1,email);
	
		ResultSet rs = pst.executeQuery();
		if(rs.next())
		{
			name = rs.getString(1);
		}
		else
		{
			name="DB-Error";
		}
		
	    }
		catch(Exception e)
		{
			name = e.getMessage();
		}
		return name;

   }

		
}
