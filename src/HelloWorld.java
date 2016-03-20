// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class HelloWorld extends HttpServlet {
	
	public static String league;
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		league = request.getParameter("first_name");
		League newLeague = new League(league, null, 0);
		response.sendRedirect("http://localhost:8080/Hello.htm");
		//response.setContentType("text/html");
		
		//PrintWriter out = response.getWriter();
				
		//out.println(league);
		// Set response content type
//		response.setContentType("text/html");

//		PrintWriter out = response.getWriter();
//		String title = "Using GET Method to Read Form Data";
//		String docType =
//				"<!doctype html public \"-//w3c//dtd html 4.0 " +
//						"transitional//en\">\n";
//		out.println(docType +
//				"<html>\n" +
//				"<head><title>" + title + "</title></head>\n" +
//				"<body bgcolor=\"#f0f0f0\">\n" +
//				"<h1 align=\"center\">" + title + "</h1>\n" +
//				"<ul>\n" +
//				"  <li><b>First Name</b>: "
//				+ request.getParameter("first_name") + "\n" +
//				"  <li><b>Last Name</b>: "
//				+ request.getParameter("last_name") + "\n" +
//				"</ul>\n" +
//				"</body></html>");
	}
	public static void main (String[] args){
		System.out.println(league);
	}
}