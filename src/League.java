import java.io.*;
//import org.
import javax.servlet.*;
import javax.servlet.http.*;


public class League extends HttpServlet {
	static final long serialVersionUID = 42L;

	public String Name;
	public String Commissioner;
	public int num_Teams;
	public int ID;

	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		Name = request.getParameter("league_name");
		League newLeague = new League(Name, null, 0, 0);
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.println(Name);
		//Set response content type
//		response.setContentType("text/html");
//
//		//PrintWriter out = response.getWriter();
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
	public League(String name, String comm, int numTeams, int leagueID){
		Name = name;
		Commissioner = comm;
		num_Teams = numTeams;
		ID = leagueID;
	}
	public String getName(){
		return Name;
	}
	public static void main (String[] args){
		//System.out.println(league);
	}
}
