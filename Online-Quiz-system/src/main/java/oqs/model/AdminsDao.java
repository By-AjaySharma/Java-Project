package oqs.model;
//Lib import
import java.sql.*;

import oqs.db.Admins;
import oqs.db.Provider;

public class AdminsDao {
    public static boolean doValidate(Admins ad) {
         
        boolean status = false;
        try
        {
            Connection con = Provider.getJdbcConnection();
            String sql = "select * from admininfo where emailId=? and password=?"; // SQL Query
	    PreparedStatement pst = con.prepareStatement(sql);
	    pst.setString(1, ad.getEmail());
	    pst.setString(2, ad.getPassword());
	    ResultSet rs = pst.executeQuery();
	    if(rs.next())
            {
	    		ad.setName(rs.getString("name"));
                status = true;
	    }
	    else
            {
                status = false;
            }
        }catch(Exception e){System.out.println(e);}
	return status;
    }
}
