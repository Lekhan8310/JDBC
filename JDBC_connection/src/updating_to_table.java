import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class updating_to_table {

	public static void main(String[] args) throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("the driver is loaded succesfully");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root" ,"80085");
		System.out.println("connection established");
		
		
		String s = "update student set name=? where id =?";
		PreparedStatement pstmt = con.prepareStatement(s);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the name: ");
		String name = sc.next();
		System.out.println("enter the id: ");
		int id = sc.nextInt();
		
		pstmt.setString(1, name);
		pstmt.setInt(2, id);
		
		int rows = pstmt.executeUpdate();
		System.out.println("the rows changed" + rows);
	}

}
