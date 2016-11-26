// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.ArrayList;

// Extend HttpServlet class
public class Lottery extends HttpServlet {
	static final long serialVersionUID = 42L;
	public String Name;
	public String Password;
	public String Commissioner;
	public static int num_Teams;
	public int ID;
	public static String ownerList;

	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{
		try
		{
			File file = new File("C:/xampp/tomcat/webapps/ROOT/DraftLog.txt");
			PrintWriter printWriter = new PrintWriter(file);
			PrintWriter pw = response.getWriter();
			Name = request.getParameter("league_name");
			Commissioner = request.getParameter("commName");
			num_Teams = Integer.parseInt(request.getParameter("num_teams"));
			ownerList = request.getParameter("ownerList");
			//ArrayList<Owner> ownerOrder = runDraft(ownerList);
			//pw.println(ownerOrder);
			pw.close();
		}
		catch(Exception e)
		{
		
		}

	}

	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException
	{

	}

	public static ArrayList<Owner> runDraft(ArrayList<Owner> ownerList){

		try
		{
			File file = new File("C:/xampp/tomcat/webapps/ROOT/DraftLog.txt");
			PrintWriter printWriter = new PrintWriter(file);
			ArrayList<Owner> ownerOrder = new ArrayList<Owner>();
			ownerOrder = main.runLottery(ownerList, num_Teams);
		
			printWriter.println(ownerOrder.toString());
			printWriter.close();
			return ownerOrder;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

//	public static void main (String[] args){
//		Lottery draft = new Lottery();
//		draft.num_Teams = 10;
//		ArrayList<Owner> al = new ArrayList<Owner>();
//		for (int i = 1;i <= num_Teams;i++){
//			al.add(new Owner("player "+i,"",i));
//		}
//		al = draft.runDraft(al);
//		System.out.println(al.toString());
//	}
}