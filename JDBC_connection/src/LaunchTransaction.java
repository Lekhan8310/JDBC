import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class LaunchTransaction {
	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root" ,"80085");
		
		con.setAutoCommit(false);
		String s1 = "insert into student values(?, ?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(s1);
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
		pstmt.executeUpdate();
		
		String s2 = "insert into student values(?, ?, ?,?, ?)";
		PreparedStatement pstmt1 = con.prepareStatement(s2);
		
		System.out.println("Entre the id :");
		int id1 = sc.nextInt();
		System.out.println("Enter the name:");
		String name1 = sc.next();
		System.out.println("Enter the marks1:");
		int marks11 = sc.nextInt();
		System.out.println("Enter the marks2:");
		int marks21 = sc.nextInt();
		System.out.println("Enter the marks3:");
		int marks31 = sc.nextInt();
		
		pstmt1.setInt(1, id);
		pstmt1.setString(2, name);
		pstmt1.setInt(3, marks1);
		pstmt1.setInt(4, marks2);
		pstmt1.setInt(5, marks3);
		pstmt1.executeUpdate();
		
		con.commit();
	}
}
