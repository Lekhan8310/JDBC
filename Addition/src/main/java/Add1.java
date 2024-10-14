// Addition application taking input from Html file in form and
// redirecting to the java file to adding it and printing the output in browser

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Add1 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstNumber = request.getParameter("firstNumber");
		String secondNumber = request.getParameter("secondNumber");

		//		converting string to integer
		int firstNumber1 = Integer.parseInt(firstNumber);
		int secondNumber1 = Integer.parseInt(secondNumber);
		
		int result = firstNumber1+secondNumber1;
		
		PrintWriter out = response.getWriter();
		
		out.println("The addition of two given values are = "+result);
		
	}
}
