package Jdbc17;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
public class JdbcConnection {
	public static void main(String[] args) throws SQLException {
		
	
		
		
	RowSetFactory rsFactory = RowSetProvider.newFactory();
	CachedRowSet cacheRowSet = rsFactory.createCachedRowSet();
	cacheRowSet.setUrl("jdbc:mysql://localhost:3306/mydb");
	cacheRowSet.setUsername("url");
	cacheRowSet.setPassword("2004");
	cacheRowSet.setCommand("select * from student");
	cacheRowSet.execute();
	while(cacheRowSet.next()) {
		System.out.println(cacheRowSet.getInt("stu_id") + " " + cacheRowSet.getString("stu_name") + " "
				+ cacheRowSet.getString("city"));
	}
	
	}
}

