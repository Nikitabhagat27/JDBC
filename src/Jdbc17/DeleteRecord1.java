package Jdbc17;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteRecord1 {
	
	

	

		public static void main(String[] args) {
			Connection con = JdbcUtil.getMySqlConnection();
			String sql = "delete student where id=4";
			Statement st = null;
			try {
				st = con.createStatement();
				int count = st.executeUpdate(sql);

				if ( count > 0 ) {
					System.out.println(count + " Record has been deleted");
				} else {
					System.out.println("Something went wrong");
				}
			} catch ( SQLException e ) {
				e.printStackTrace();
			}
			finally {
				JdbcUtil.cleanResources(st, con);
			}


		}
	}


