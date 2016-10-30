import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conn {

	public Conn(){
		
	}
	
	public Connection getConn(){
		try{
			File file = new File("C:/xampp/tomcat/webapps/ROOT/Connection_Log.txt");
			PrintWriter printWriter = new PrintWriter(file);
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = null;
				conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1","me13101", "Elemnopee3");
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
	public String getID(String table){
		String ID = "";
		try{
			File file = new File("C:/xampp/tomcat/webapps/ROOT/Connection_Log.txt");
			PrintWriter printWriter = new PrintWriter(file);
			
			Connection conn = getConn();
			Statement stmt = conn.createStatement();
			ResultSet res;
			String sql = "select count(*) from"+table;
			printWriter.println(sql);
			res = stmt.executeQuery(sql);
			ID = Integer.toString(res.getFetchSize());
			while(res.next()){
				ID = res.getString(1);
				if (ID.equals("")){
					ID = "0";
				}
				System.out.println("sql: "+sql);
				printWriter.println(res.getString(1));
			}
			return ID;
		}catch(Exception e){
			
		}
		return ID;
	}
}
