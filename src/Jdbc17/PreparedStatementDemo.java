package Jdbc17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class PreparedStatementDemo {
public static void main(String[] args) {
	try {
		
		 
		
		Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mydb";
		String userName="url";
		String password="2004";
		con = DriverManager.getConnection(url, "root", "2004");
		String sql="insert into student (Name,City) values(?,?)";
		PreparedStatement ps  = con.prepareStatement(sql);
		
		ps.setString(1,"ABCD");
		ps.setString(2,"CCCCC");
		ps.executeUpdate();

		System.out.println("inserted");
		con.close();
		
		
		
		
		

		
	}catch(Exception e)
	{
	
	e.printStackTrace();
}
}



}
