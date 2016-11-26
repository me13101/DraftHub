import java.io.*;    
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

// Extend HttpServlet class
public class Authent extends HttpServlet {
	static final long serialVersionUID = 42L;
	public static String email, pswd, userID, userName, leagueID, leagueName;

	public Authent(String email,String pswd,String userID,String userName,String leagueID,String leagueName){
		this.email = email;
		this.email = pswd;
		this.email = userID;
		this.email = userName;
		this.email = leagueID;
		this.email = leagueName;
	}
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		
		File file = new File("C:/xampp2/tomcat/webapps/ROOT/Authent.txt");
		PrintWriter printWriter = new PrintWriter(file);
		try{
		email = request.getParameter("email");
		pswd = request.getParameter("password");
		
		if (checkDB(email, pswd) == true){
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("true");
			out.close();
		}
		else{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("false");
			out.close();
		}
		
		printWriter.println(email+" : "+pswd);
		printWriter.close();
		}catch(Exception e){
			printWriter.println(e);
			printWriter.close();
		}
	}
	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		File file = new File("C:/xampp2/tomcat/webapps/ROOT/Authent.txt");
		PrintWriter printWriter = new PrintWriter(file);
		try{
		userName = request.getParameter("userName");
		leagueName = request.getParameter("leagueName");
		leagueID = request.getParameter("leagueID");
		email = request.getParameter("email");
		pswd = request.getParameter("password");
		
		if (checkDB(email, pswd) == true){
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("fount");
			out.close();
		}
		else{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			if (newUser(email, pswd, userID, userName, leagueID, leagueName)== true){
				out.println("successful");
			}
			else{
				out.println("failed");
			}
			out.close();
		}
		
		printWriter.println(email+" : "+pswd);
		printWriter.close();
		}catch(Exception e){
			printWriter.println(e);
			printWriter.close();
		}
	}
	public static boolean checkDB(String email, String pswd){
		try{
			File file = new File("C:/xampp/tomcat/webapps/ROOT/ChechDB_Log.txt");
			PrintWriter printWriter = new PrintWriter(file);
			try{
				Conn conn = new Conn();
				Connection c = conn.getConn();
				//System.out.println(c);
				PreparedStatement ps = c.prepareStatement("Select * from draftHub.player where email ='"+email+"' and pswd ='"+pswd+"'");
				ResultSet rs;
				rs = ps.executeQuery();
				//System.out.println(rs.getFetchSize());
				if (rs.getFetchSize() > 0){
					return true;
				}
				return false;
			}catch(Exception e){
				//System.out.println(e);
				printWriter.println(e);
			}
		}catch(Exception e){
			//System.out.println(e);
		}
		return false;
	}
	public static boolean newUser(String userID, String userName, String leagueID, String leagueName, String email, String pswd){
		try{
			File file = new File("C:/xampp/tomcat/webapps/ROOT/ChechDB_Log.txt");
			PrintWriter printWriter = new PrintWriter(file);
			try{
				Conn conn = new Conn();
				Connection c = conn.getConn();
				//userID = conn.getID("drafthub.player");
				System.out.println(userID);
				int i = Integer.parseInt(userID);
				int j = Integer.parseInt(leagueID);
				System.out.println(i);
				System.out.println(j);
				PreparedStatement ps = c.prepareStatement("Insert into draftHub.player values('"+i+"', '"+userName+"', '"+j+"', '"+leagueName+"', '"+email+"', SYSDATE(), '"+pswd+"')");
				return true;
			}catch(Exception e){
				System.out.println(e);
				printWriter.println(e);
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return false;
	}
	public static void main(String[] args){
		//System.out.println(newUser("1","me13101","1","test league","michael.mathews10@comcast.net","pswwd"));
	}
}
