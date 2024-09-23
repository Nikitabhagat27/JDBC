package Jdbc17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//prepared statement me ham (???)value insrt krate hai to ise dynamic query khete hai isliye prepared statement k
//ka use krte hai(???)fill krne ke liye.
public class InsertPractice{
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/mydb";
		String username="root";
		String password="2004";
		Connection con=DriverManager.getConnection(url,username,password);
		
		String sql="insert into girls1 (id,Name,City) values(?,?,?)"; 
		 
		 PreparedStatement ps=con.prepareStatement(sql);
		 
		 ps.setInt(1,111);
		ps.setString(2, "SiyaRam");
		ps.setString(3, "Aayodhya");
		ps.executeUpdate();
		System.out.println("record has bin inserted");
		con.close();
		
	}catch (Exception e) 
	{
		
	e.printStackTrace();	
	System.out.println("record has bin inserted");
	

}
}}