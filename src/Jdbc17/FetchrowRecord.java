package Jdbc17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchrowRecord {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
//		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection con = DriverManager.getConnection(url, "system", "admin");
		String sql = "select * from student";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while ( rs.next() )
			System.out.println(rs.getInt("stu_id") + " " + rs.getString("stu_name") + " " + rs.getString("city"));


	}

}
