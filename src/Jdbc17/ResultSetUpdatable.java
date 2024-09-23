package Jdbc17;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetUpdatable{
public static void main(String[] args) {
	Connection con=JdbcUtil.getMySqlConnection();
	Statement st =null;
	ResultSet rs= null;
	String sql = "select * from student";//in oracle it is read only 
	//String sql = "select id name city from Student";
	try {
		st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs = st.executeQuery(sql);

		System.out.println("**************** Forward direction *************");
		while ( rs.next() ) {
			System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("city"));
		}
		System.out.println("Update 1st record");
		rs.absolute(1);
		rs.updateString(2, "Ritika");
		rs.updateString(3, "Ayodhya");
		rs.updateRow();


//		System.out.println("**************** Record has been updated *************");
//		rs.absolute(6);
//			System.out.println(rs.getInt("stu_id") + " " + rs.getString("stu_name") + " " + rs.getString("city"));
//			System.out.println("************** Delete 5th record ********");
//			rs.absolute(5);
//			rs.deleteRow();
		System.out.println("Current position: " + rs.getRow());
			System.out.println("Insert a record");
			rs.moveToInsertRow();
			rs.updateInt(1, 333);
			rs.updateString(2, "Anuj");
			rs.updateString(3, "Patna");
			rs.insertRow();
			rs.beforeFirst();
			System.out.println("**************** Forward direction *************");
			while ( rs.next() ) {
				System.out
						.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("city"));
			}

	} catch ( SQLException e ) {
		e.printStackTrace();
	} finally {
		JdbcUtil.cleanResources(st, con, rs);
	}
}

	
	
	
}

