import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class INSERT_DATA_USER {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.println("1.new user \n2.Existing user");
		int usertype = sc.nextInt();

		if (usertype == 1) {
			register();
		} else if (usertype == 2) {
			login();
		} else {
			System.out.println("enter the valid number!");
		}
	}

	static void register() throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("The driver is loaded");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root" ,"80085");
		System.out.println("the connection is established");
		
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter the name:");
		String name = sc.next();
		System.out.println("Enter the userName: ");
		String username = sc.next();
		
		
		while(true) {
			String s = "Select * from user where username=?";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, username);
			ResultSet res = pstmt.executeQuery();
			
			if(res.next()) {
				System.out.println("username is already exists! please enter the anothe username");
				
				8username = sc.next();
			}
			else {
				break;
			}
			
		}
		
		System.out.println("Enter the Password: ");
		String password = sc.next();
		System.out.println("Enter the ConfirmPassword: ");
		String conpass = sc.next();
		while(!conpass.equals(password)) {
			System.out.println("password is not  matching");
			System.out.println("Enter the Password: ");
			password = sc.next();
			System.out.println("Enter the ConfirmPassword: ");
			conpass = sc.next();
			
		}
		System.out.println("enter the email: ");
		String email = sc.next();
		
		String query = "insert into user values(?, ?, ?, ?)";
		PreparedStatement pstmt1 = con.prepareStatement(query);
		pstmt1.setString(1,name);
		pstmt1.setString(2, username);
		pstmt1.setString(3, password);
		pstmt1.setString(4, email);
		pstmt1.executeUpdate();
		System.out.println("The User is added");
		
		
	}

	static void login() throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("The driver is loaded");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024", "root", "80085");
		System.out.println("the connection is established");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the username: ");
		String username = sc.next();
		System.out.println("Enter the password: ");
		String password = sc.next();

		String query = "select * from user where username=?";
		PreparedStatement pstmt = con.prepareStatement(query);

		pstmt.setString(1, username);
		ResultSet res = pstmt.executeQuery();

		if (res.next()) {
			if (password.equals(res.getString(3))) {
				System.out.println("the login  is successful");
				String name = res.getString(1);
				username = res.getString(2);
				password = res.getString(3);
				String email = res.getString(4);
				System.out.println(name + "  " + username + "  " + password + "  " + email);
			} else {
				System.out.println("Invalid login password!");
			}

		} 
		else {
			System.out.println("Invalid username!");
		}
	}
}
