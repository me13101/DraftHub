// Import required java libraries
import java.io.*;   
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

// Extend HttpServlet class
public class App extends HttpServlet {
	static final long serialVersionUID = 42L;
	public String Name;
	public String Commissioner;
	public String commEmail;
	public int num_Teams;
	public int ID;

	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		File file = new File("C:/xampp/tomcat/webapps/ROOT/Log.txt");
		PrintWriter printWriter = new PrintWriter(file);
		Name = request.getParameter("league_name"); 
		Commissioner = request.getParameter("commName"); 
		commEmail = request.getParameter("commEmail"); 
		num_Teams = Integer.parseInt(request.getParameter("num_teams"));
		ID = getID();
		League newLeague = new League(Name, null, num_Teams, ID);

		printWriter.println(newLeague.Name+", "+newLeague.num_Teams+", "+commEmail+", "+Commissioner);

		try
		{
			Connection conn = getConn();
			Statement stmt = conn.createStatement();
			String params = "";
			String sql = "insert into drafthub.league Values('"+(ID)+"','"+Name+"', '"+ID+"', '"+num_Teams+"', '"+Commissioner+"', '"+commEmail+"')";
			int rs = stmt.executeUpdate(sql);
		
			conn.close();
		}
		catch(Exception e)
		{
			printWriter.println("Error:"+e);
		}
		printWriter.close();
	}
	
	public Connection getConn(){
		try{
			File file = new File("C:/xampp/tomcat/webapps/ROOT/Connection_Log.txt");
			PrintWriter printWriter = new PrintWriter(file);
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = null;
				conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1","root", "");
				printWriter.println("Connected");
				printWriter.close();
				return conn;
			}catch(Exception e){
				printWriter.println(e);
			}
			printWriter.println("DB Not Connected");
			printWriter.close();
		}catch(Exception e){
		}
		return null;
	}
	
	public int getID(){
		try{
			File file = new File("C:/xampp/tomcat/webapps/ROOT/Connection_Log.txt");
			PrintWriter printWriter = new PrintWriter(file);
			
			Connection conn = getConn();
			Statement stmt = conn.createStatement();
			ResultSet res;
			String sql = "select count(*) from drafthub.league";
			printWriter.println(sql);
			res = stmt.executeQuery(sql);
			while(res.next()){
				ID = Integer.parseInt(res.getString(1));
				printWriter.println(res.getString(1));
			}
			return ID;
		}catch(Exception e){
			
		}
		return -1;
	}
	
	public static void main (String[] args){
		
	}
}