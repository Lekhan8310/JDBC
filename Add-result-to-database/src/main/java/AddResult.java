

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddResult extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		gettting the data from user and coverting string into a integer
		int id = Integer.parseInt(request.getParameter("id"));
//		we just get the data not coverting it
		String name = request.getParameter("name");
//		gettting the data from user and coverting string into a integer
		int marks1 = Integer.parseInt(request.getParameter("marks1"));
		int marks2 = Integer.parseInt(request.getParameter("marks2"));
		int marks3 = Integer.parseInt(request.getParameter("marks3"));
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root" ,"80085");
			
			String query = "insert into student values(?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, marks1);
			pstmt.setInt(4, marks2);
			pstmt.setInt(5, marks3);
			int rows = pstmt.executeUpdate();
			PrintWriter out = response.getWriter();
			if(rows == 0) {
				out.println("not successfully");
				
			}else {
				out.println("Successfully...:)");
			}
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
