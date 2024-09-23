package Jdbc17; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchRecord {


public static void main(String[] args) {
	Connection con = JdbcUtil.getMySqlConnection();
PreparedStatement ps =  null;
 ResultSet rs =null;
int id = 101;
String sql ="select*from student where id=?";
System.out.println(sql);
try {
	
	 ps = con.prepareStatement(sql);
	ps.setInt(1, id);
	rs=ps.executeQuery();
	rs.next();
	System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getString("city"));
}
catch(SQLException e) {
	e.printStackTrace();
	
}finally {
	JdbcUtil.cleanResources(ps, con, rs);
}


	
	
}
	
	
	
}
