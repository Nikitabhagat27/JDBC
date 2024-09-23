package Jdbc17;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class BetchUpdateExample {
public static void main(String[] args) throws SQLException {
	Connection con=JdbcUtil.getMySqlConnection();
	String sql1="insert into student(id,name,city) values(111,'Satya prakash','Ranchi')";
	String sql2="delete from  student where name='Shailash mishra'";
//	String sql3="update student  set name='Shailash mishra'";
	Statement st =con.createStatement();
	st.addBatch(sql1);
	st.addBatch(sql2);
	//st.addBatch(sql3);
	int[]count=st.executeBatch();
	for(int i:count) {
		System.out.println(i);
	}
JdbcUtil.cleanResources(st, con);
}
}
