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
	
	public League(String name, String comm, int numTeams, int leagueID){
		Name = name;
		Commissioner = comm;
		num_Teams = numTeams;
		ID = leagueID;
	}
	public String getName(){
		return Name;
	}
}
