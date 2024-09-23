package Jdbc17;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetExample {
public static void main(String[] args) {
	Connection con=JdbcUtil.getMySqlConnection();
	Statement st =null;
	ResultSet rs= null;
	String sql = "select * from student";
	try {
		//st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rs=st.executeQuery(sql);
		//while(rs.next()) {
			//System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getString("city"));
		//}
		System.out.println("*************Forward direction***************");
		while(rs.next()) {
			System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getString("city"));
		}
		System.out.println("**************Backword direction**************");
		while(rs.previous()) {
			System.out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getString("city"));
		}
		
	}catch (SQLException e ) {
		e.printStackTrace();
		
	}finally {
		JdbcUtil.cleanResources(st,con,rs);
	}
	
}
}
