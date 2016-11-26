import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


/**
 * main class for draft lottery. 
 * @author michaelmathews
 */
public class main {
	
	
	/** runs the draft lottery once number of owners and owner names has been provided
	 * @param owners
	 * @param number_of_teams
	 */
	public static ArrayList<Owner> runLottery(ArrayList<Owner> owners, int number_of_teams){
		//Scanner sc = new Scanner(System.in);
		ArrayList<Owner> order = new ArrayList<Owner>();
		int i = 0;
		String cont;
		int count = 1;
		int loopIncrementor = number_of_teams;


		for (int j = 0; j < loopIncrementor; j++){
			i = (int)Math.floor(Math.random()*number_of_teams);
			if (owners.get(i) != null){
				order.add(owners.get(i));
				order.get(j).Draft_Position = j+1;
				owners.remove(i);
				number_of_teams--;
				//System.out.println(order.get(j).Draft_Position+") "+order.get(j).Full_Name);
				if(count < loopIncrementor){
					//System.out.println("continue?(y/n)");
					//cont = sc.nextLine().toLowerCase();
						count++;
						continue;
				}
			}
			else{
				j--;
			}
		}
		return(order);
	}
	/**
	 * prints the resulting lottery.
	 * @param owners
	 */
	public static void printDraftOrder(ArrayList<Owner> owners){
		System.out.println(" ");
		System.out.println("2015 Draft Order: ");
		for (int i = 0; i < owners.size(); i++){
			System.out.println((i+1)+") "+owners.get(i).Full_Name);
		}
	}

	/**
	 * runs program, asks for input number of teams and names. Then calls runLottery.
	 * @param args
	 */
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		boolean done_input = false;
		boolean teamsInput = false;
		int count_in_owners = 0;
		String name;
		String team;
		ArrayList<Owner> Owners;
		int number_of_teams = 0;
		String beginDraft;

		System.out.println("Enter number of teams: ");
		number_of_teams = Integer.parseInt(sc.nextLine());



		teamsInput = true;
		Owners = new ArrayList<Owner>(number_of_teams);


		while(done_input != true){

			System.out.println("enter owner name: ");
			name = sc.nextLine();
			Owner newOwner = new Owner(name, null, 0);
			Owners.add(newOwner);
			count_in_owners++;
			if (count_in_owners == number_of_teams){
				System.out.println("Begin draft lottery?(y/n) ");
				beginDraft = sc.nextLine().toLowerCase();
				if (beginDraft.equals("y")){
					done_input = true;
				}
				else{
					System.exit(-1);
				}
			}
		}

		runLottery(Owners, number_of_teams);
	}
}
