package Jdbc17;


	

	import java.sql.Connection;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class UpdateRecord {

		public static void main(String[] args) {
			Connection con = JdbcUtil.getMySqlConnection();
			String sql = "update student set name='Niki' where id=105";
			Statement st = null;
			try {
				st = con.createStatement();
				boolean result = st.execute(sql);
				if ( !result ) {
					System.out.println("Record has been updated");
				} else {
					System.out.println("Something went wrong");
				}
			} catch ( SQLException e ) {
				System.out.println("Exception occurs while updating the records");
			}
			finally {
			JdbcUtil.cleanResources(st, con);
			}
		}
	}

