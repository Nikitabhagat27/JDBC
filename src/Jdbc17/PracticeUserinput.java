package Jdbc17;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class PracticeUserinput {
	public static void main(String[] args) {
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/mydb";
				String username="root";
				String password="2004";
				Connection con=DriverManager.getConnection(url,username,password);
				
				String sql="insert into girls1 (id,Name,City) values(?,?,?)"; 
				
				 PreparedStatement ps=con.prepareStatement(sql);
				 Scanner sc= new Scanner(System.in);
				 System.out.println("Inter name");
				 String Name=sc.next();
				 System.out.println("Inter city");
				 String city=sc.next();
				 System.out.println("id");
				 int id=sc.nextInt();
				  ps.setInt(1,id);
						  
				ps.setString(2, Name);
				ps.setString(3, city);
				ps.executeUpdate();
				
				System.out.println("record has bin inserted");
				con.close();
				}catch (Exception e) 
			{
					e.printStackTrace();	
					System.out.println("record has bin inserted");
					
			}
	}}		
			
			
		
		
		
	
	
					

		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
