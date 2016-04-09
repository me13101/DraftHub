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
	public int num_Teams;
	public int ID;


	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		File file = new File("C:/xampp/tomcat/webapps/ROOT/Log.txt");
		PrintWriter printWriter = new PrintWriter(file);
		Name = request.getParameter("league_name"); 
		num_Teams = Integer.parseInt(request.getParameter("num_teams"));
		ID = getID();
		League newLeague = new League(Name, null, num_Teams, ID);

		printWriter.println(newLeague.Name+", "+newLeague.num_Teams);

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1","root", "");
			printWriter.println("Database is connected !");
			String name = "New League";
			int num = 10;
			
			Statement stmt = conn.createStatement();
			int rs = stmt.executeUpdate("insert into drafthub.league Values('"+ID+"','"+name+"', '1', '"+num+"')");
			ID += ID;
			setID(ID);
			conn.close();
		}
		catch(Exception e)
		{
			printWriter.println("Do not connect to DB - Error:"+e);
		}
		printWriter.close();
	}
	
	public int getID(){
		Object id = 0;
		try
	      {
	         FileInputStream fileIn = new FileInputStream("C:/xampp/tomcat/webapps/ROOT/LeagueID.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         id = in.readObject();
	         int temp = Integer.parseInt(id.toString());
	         System.out.println(temp+1);
	         in.close();
	         fileIn.close();
	         return temp+1;
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	      }
		return 0;
	}
	
	public void setID(int ID){
		Object id = ID;
		try{
			FileOutputStream fileOut =
			         new FileOutputStream("C:/xampp/tomcat/webapps/ROOT/LeagueID.ser");
			         ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         out.writeObject(id);
			         out.close();
			         fileOut.close();
			         System.out.printf("Serialized data is saved in /tmp/employee.ser");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main (String[] args){
		Object id = 0;
		//int id = 1;
		try{
			FileOutputStream fileOut =
			         new FileOutputStream("C:/xampp/tomcat/webapps/ROOT/LeagueID.ser");
			         ObjectOutputStream out = new ObjectOutputStream(fileOut);
			         out.writeObject(id);
			         out.close();
			         fileOut.close();
			         System.out.printf("Serialized data is saved in /tmp/employee.ser");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try
	      {
	         FileInputStream fileIn = new FileInputStream("C:/xampp/tomcat/webapps/ROOT/LeagueID.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         id = in.readObject();
	         int temp = Integer.parseInt(id.toString());
	         System.out.println(temp+1);
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }
		
		
//		{
//			try
//			{
//				Class.forName("com.mysql.jdbc.Driver");
//				Connection conn = null;
//				conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1","root", "");
//				System.out.println("Database is connected !");
//				String name = "New League";
//				int num = 10;
//				
//				Statement stmt = conn.createStatement();
//				int rs = stmt.executeUpdate("insert into drafthub.league Values('"+0+"','"+name+"', '0', '"+num+"')");
//				
//				conn.close();
//			}
//			catch(Exception e)
//			{
//				System.out.print("Do not connect to DB - Error:"+e);
//			}
//		}
	}
}