
public class Owner {
	public String Full_Name;
	public String Team_Name;
	public int Draft_Position;
	
	public Owner(String name, String team, int position){
		Full_Name = name;
		Team_Name = team;
		Draft_Position = position;
	}
	
	public void changePosition(int newPosition){
		Draft_Position = newPosition;
	}
	
	public void Change_Owner_Name(String newName){
		Full_Name = newName;
	}
	
	public void Change_Team_Name(String newTeamName){
		Team_Name = newTeamName;
	}
}
