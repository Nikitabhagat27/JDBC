package Jdbc17;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class ResultSetMetaDeta {
public static void main(String[] args) {
	Connection con = JdbcUtil.getMySqlConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;

	String sql = "select * from student";
	try {
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		ResultSetMetaData rsMetaData = (ResultSetMetaData) rs.getMetaData();

//		System.out.println(rsMetaData.getTableName(0));
//		System.out.println(rsMetaData.getColumnCount());
//		System.out.println(rsMetaData.getColumnName(1));
//		System.out.println(rsMetaData.getColumnName(2));
//		System.out.println(rsMetaData.getColumnName(3));

		for ( int i = 1; i <= rsMetaData.getColumnCount(); i++ ) {
			String columnName = rsMetaData.getColumnName(i);
			int columnType = rsMetaData.getColumnType(i);
			String columnTypeName = rsMetaData.getColumnTypeName(i);
			String tableName = rsMetaData.getTableName(i);
			System.out.println(columnName + "\t" + columnTypeName + "\t" + tableName);

		}

	} catch ( SQLException e ) {
		e.printStackTrace();
	} finally {
		JdbcUtil.cleanResources(ps, con, rs);
	}
}

}
