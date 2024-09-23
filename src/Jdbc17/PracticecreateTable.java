package Jdbc17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class PracticecreateTable {
public static void main(String[] args) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/mydb";
		String username="root";
		String password="2004";
Connection con=DriverManager.getConnection(url,username,password);
//
String sql="create table girls1(id int(20),Name varchar(200) ,City varchar(400))";
		//
Statement st=con.createStatement();

st.executeUpdate(sql);
System.out.println("Table created in databases ");
con.close();

		
	}catch (Exception e)
	{
		e.printStackTrace();
	}
}
}
