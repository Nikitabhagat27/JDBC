package Jdbc17;


	import java.sql.Connection;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class ExecuteUpdateMethod {
 
		public static void main(String[] args) {
			Connection con = JdbcUtil.getMySqlConnection();
		//String sql = "drop table mystudent";
		String sql = "create table mystudent(sid int,name varchar2(50),city varchar2(50))";

//			String sql = "insert into mystudent values(3,'Niki','Bhopal')";
//			String sql = "update mystudent set name='Sarad' where sid=1";
//			String sql = "select * from mystudent";
		//	String sql = "delete from mystudent where sid=1";
			Statement st = null;
			try {
				st = con.createStatement();
				int count = st.executeUpdate(sql);
				System.out.println(count);
				if ( count >0 ) {
					System.out.println("Welldone Sarad");
				} else {
					System.out.println("Something went wrong");
				}
			} catch ( SQLException e ) {
				System.out.println("Exception occurs while updating the records");
			} finally {
				JdbcUtil.cleanResources(st, con);
			}
		}
	}

