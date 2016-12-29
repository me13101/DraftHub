package main.java;
// Import required java libraries
import java.io.*;    
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.log4j.FileAppender;

// Extend HttpServlet class
public class Join extends HttpServlet {
	static Logger log = Logger.getLogger(Join.class.getName());
	
	static final long serialVersionUID = 42L;
	public String Name;
	public String Team;
	public String Owner;

	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		File file = new File("C:/xampp/tomcat/webapps/ROOT/JoinLog.txt");
		PrintWriter printWriter = new PrintWriter(file);
		
		Name = request.getParameter("league_name");
		Owner = request.getParameter("OwnerName");
		Team = request.getParameter("teamName");
		
		//League newLeague = new League(Name, null, num_Teams, ID);
		log.info(Name+", "+Owner+", "+Team);
		printWriter.println(Name+", "+Owner+", "+Team);

		try
		{
			Connection conn = getConn();
			Statement stmt = conn.createStatement();
			String params = "";
			int id = getLeagueID(Name);
			printWriter.println(id);
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.append("true");
			out.close();
			//String sql = "insert into drafthub.league Values('"+(ID)+"','"+Name+"', '"+ID+"', '"+num_Teams+"', '"+Commissioner+"', '"+commEmail+"')";
			//int rs = stmt.executeUpdate(sql);

			conn.close();
		}
		catch(Exception e)
		{
			printWriter.println("Error:"+e);
		}
		printWriter.close();
	}
	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		
	}
	
	public static void testLog(String testString){
		log.info(testString);
	}
	
	public int getLeagueID(String leagueNM){
		
		try
		{
			File file = new File("C:/xampp/tomcat/webapps/ROOT/JoinLog.txt");
			PrintWriter printWriter = new PrintWriter(file);
			Connection conn = getConn();
			Statement stmt = conn.createStatement();
			String params = "";
			String sql = "Select * from drafthub.league where Name='"+leagueNM+"'";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				int id = rs.getInt("ID");
				return id;
			}
			//int rs = stmt.executeUpdate(sql);
		
			conn.close();
		}
		catch(Exception e)
		{
			
		}
		return -1;
	}
	
	public Connection getConn(){
//		try{
//			File file = new File("C:/xampp/tomcat/webapps/ROOT/Connection_Log.txt");
//			PrintWriter printWriter = new PrintWriter(file);
//			try{
//				Class.forName("com.mysql.jdbc.Driver");
//				Connection conn = null;
//				conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1","root", "");
//				printWriter.println("Connected");
//				printWriter.close();
//				return conn;
//			}catch(Exception e){
//				printWriter.println(e);
//			}
//			printWriter.println("DB Not Connected");
//			printWriter.close();
//		}catch(Exception e){
//		}
		return null;
	}
	
	public static void main (String[] args){
		testLog("test");
	}
}