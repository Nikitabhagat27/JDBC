package Jdbc17;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetDemo {


public static  void main(String[] args) throws ClassNotFoundException, SQLException {
	//load the driver
	Class.forName("com.mysql.cj.jdbc.Driver");
	RowSet rs = RowSetProvider.newFactory().createCachedRowSet();
	rs.setUrl("jdbc:mysql://localhost:3306/mydb");
	rs.setUsername("url");
	rs.setPassword("2004");
	String sql = "select * from student";
	rs.setCommand(sql);
	rs.execute();
	while ( rs.next() ) {
		System.out.println(rs.getInt("stu_id") + " " + rs.getString("stu_name") + " " + rs.getString("city"));
	}
	rs.absolute(3); 
	System.out.println("************");
	rs.updateString(2, "Anu");
	rs.updateRow();
	System.out.println(rs.getInt("stu_id") + " " + rs.getString("stu_name") + " " + rs.getString("city"));
}}

	

	


