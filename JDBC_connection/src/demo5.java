import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class demo5 {

	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("the driver is loaded succesfully");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root" ,"80085");
		System.out.println("connection established");
		
		
		String s = "insert into student values(? ,? ,? ,? ,?)";
		PreparedStatement pstmt = con.prepareStatement(s);
		
		Scanner sc  = new Scanner(System.in);
		System.out.println("Entre the id :");
		int id = sc.nextInt();
		System.out.println("Enter the name:");
		String name = sc.next();
		System.out.println("Enter the marks1:");
		int marks1 = sc.nextInt();
		System.out.println("Enter the marks2:");
		int marks2 = sc.nextInt();
		System.out.println("Enter the marks3:");
		int marks3 = sc.nextInt();
		
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setInt(3, marks1);
		pstmt.setInt(4, marks2);
		pstmt.setInt(5, marks3);
		
		int rows = pstmt.executeUpdate();
		System.out.println("Number of rows upadated: "+rows);
		
	}

}
