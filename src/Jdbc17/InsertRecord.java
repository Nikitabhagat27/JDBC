package Jdbc17;

	

	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
	import java.sql.Statement;

	public class InsertRecord {

		public static void main(String[] args) {
			Connection con = JdbcUtil.getMySqlConnection();
			PreparedStatement st=null;
			String sql = "insert into student(id,name,city) values(?,?,?)";
			try {
				st = con.prepareStatement(sql);
				//id ke liye 1 and name ke liye 2 and city ke liye 3 use ho rha hai.
				st.setInt(1, 101);
				st.setInt(1,111);
				st.setString(2,"chiya" );
				st.setString(3, "balaghat");
			    st.setString(2, "nikki");
				st.setString(3, "bhopal");
			    boolean result = st.execute();
				if ( !result ) {
					System.out.println("Record has been inserted");
				}
			} catch ( SQLException e ) {
				e.printStackTrace();
			} finally {
				JdbcUtil.cleanResources(st, con);
			}
		}
	}

