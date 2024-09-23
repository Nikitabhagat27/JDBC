package Jdbc17;


	
	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	public class SelectRecord {

		public static void main(String[] args) {
			Connection con = JdbcUtil.getMySqlConnection();
			Statement st = null;
			ResultSet rs = null;
			String sql = "select * from studentEC";
			try {
				st = con.createStatement();
				rs = st.executeQuery(sql);
				while ( rs.next() ) {
//					System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
					System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("city"));
				}
			} catch ( SQLException e ) {
				e.printStackTrace();
			} finally {
				JdbcUtil.cleanResources(st, con, rs);
			}
		}
	}

