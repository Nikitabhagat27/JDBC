import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//step1: load the Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		//step2:Establish the connection 
		final String url="jdbc:mysql://localhost:3306/mydb";
		//DriverManager.getConnection("","","");
		Connection con = DriverManager.getConnection(url,"root","2004");
		 // Step 3: Prepare the SQL statement.
		   String sql = "insert into student values( 101,'Nikita','nikitabhagat101@gmail.com','balaghat',8839671982)";
		   // Step 4: Create JDBC statement
		   Statement st  = con.createStatement();
		   // Step 5: Submit the SQL statement to Database using JDBC statement.
		   int x = st.executeUpdate(sql);
		   // Step 6: Process the result.
		   if (x == 1) {
			   System.out.println("Record Inserted");
		   }else {
			   System.out.println("Record Not inserted");
		   }
		   //step.7 close all the resorces.
		   con.close();
		   st.close();

	}

}
