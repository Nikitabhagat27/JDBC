package Jdbc17;
import java.util.Scanner;


public class Client {
	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter student id");
			int id = sc.nextInt();
     		StudentService service = new StudentService();
			service.getStudentById(id);
		}


}