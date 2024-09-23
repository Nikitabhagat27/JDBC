package Jdbc17;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteQueryMethod {

	public static void main(String[] args) {
		Connection con = JdbcUtil.getMySqlConnection();
//			String sql = "drop table mystudent";
		// String sql = "create table mystudent( int,name varchar2(50),city
		// varchar2(50))";

		String sql = "insert into mystudent values(3,'Niki','Bhopal')";
//			String sql = "update mystudent set name='Sarad' where sid=3";
//	        String sql = "select * from mystudent";
//		    String sql = "delete from mystudent where sid=3";
		Statement st = null;

		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			System.out.println(rs);
			while (rs.next()) {
				System.out.println(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Exception occurs while updating the records");
		} finally {
			JdbcUtil.cleanResources(st, con);
		}
	}
}
