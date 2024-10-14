package jdbc.jdbc_maven_mainapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCrud {
    public static void main( String[] args ) throws Exception {
    	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("the driver is loaded succesfully");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root" ,"80085");
		System.out.println("connection established");
		
		String s = "Select * from Student";
		Statement stmt = con.createStatement();
		ResultSet res = stmt.executeQuery(s);
		
		ResultSetMetaData rsmd = res.getMetaData();
		
		for(int i=1; i<=rsmd.getColumnCount(); i++) {
			System.out.print(rsmd.getColumnName(i));
			System.out.print("->"+rsmd.getColumnTypeName(i));
			System.out.println();
		}
		System.out.println("The table values:");
		while(res.next()) {
			int id = res.getInt(1);
			String name = res.getString(2);
			int marks1 = res.getInt(3);
			int marks2 = res.getInt(4);
			int marks3 = res.getInt(5);
			System.out.println(id+" "+name+" "+marks1+" "+marks2+" "+marks3);
		}
    }
}
