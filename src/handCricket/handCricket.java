package handCricket;

import java.util.*;

class TeamIndia {
	String name;
	String role;
	// If batsmans, then how much Runs
	int score = 0;
	// If bowler, then how much wickets
	int wickets = 0;
	// Out or Not-Out
	int status = 0;
	
	public TeamIndia(String name, String role) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.role = role;
	}

	public TeamIndia() {
		// TODO Auto-generated constructor stub
	}
	
	// Getting the details
	String getName() {
		return name;
	}
	String getRole() {
		return role;
	}
	int getScore() {
		return score;
	}
	int getWickets() {
		return wickets;
	}
	
}

class Player {
	String name;
	String role;
	int runs = 0;
	int wickets = 0;
	// Out or Not-Out
	int status = 0;
	
	// Add runs for the player
	public void addRun(int run) {
		
	}
	
	// Add wickets for the player
	public void addWicket(int run) {
	
	}
	
	// Current Status of the Cricket
	public void currentStatus() {
		System.out.println();
	}
	
	public Player(String name, String role) {
		this.name = name;
		this.role = role;
	}
	public Player() {
	}
}

public class handCricket {
	
	//Team A Registration
	public static void teamIndiaRegistation(TeamIndia teamIndia_Details[]) {
		teamIndia_Details[0] = new TeamIndia ("Rohit Sharma","Captain");
		teamIndia_Details[1] = new TeamIndia ("KL Rahul","Vice-Captain");
		teamIndia_Details[2] = new TeamIndia ("Virat Kohli","Batsman");
		teamIndia_Details[3] = new TeamIndia ("Suryakumar Yadav","Batsman");
		teamIndia_Details[4] = new TeamIndia ("Rishabh Pant","Wicket Keeper");
		teamIndia_Details[5] = new TeamIndia ("Hardik Pandya","All Rounder");
		teamIndia_Details[6] = new TeamIndia ("R. Ashwin","Bowler");
		teamIndia_Details[7] = new TeamIndia ("Yuzvendra Chahal","Bowler");
		teamIndia_Details[8] = new TeamIndia ("Mohammad Siraj","Bowler");
		teamIndia_Details[9] = new TeamIndia ("Arshdeep Singh","Bowler");
	}
	
	// Team B Registration
	public static void teamBRegistation(TeamIndia teamB_Details[]) {
		Scanner sc= new Scanner(System.in);
		for(int i=0; i<10; i++) {
			System.out.println("Enter the Player Name :");
			String name = sc.next();
			System.out.println("1.Captain  2.Vice-Captain  3.Batsman  4.Wicket Keeper  5.All Rounder  6.Bowler");
			int val = sc.nextInt();
			String status;
			
			if(val == 1)
				status = "Captain";
			else if(val == 2)
				status = "Vice-Captain";
			else if(val == 3)
				status = "Batsman";
			else if(val == 4)
				status = "Wicket Keeper";
			else if(val == 5)
				status = "All Rounder";
			else
				status = "Bowler";
			
			teamB_Details[i] = new TeamIndia (name,status);
		}
		sc.close();
	}
	
	public static boolean isWonToss(char ch) {
		String chars = "HTHHTTHHT";
		Random rnd = new Random();
		char toss = chars.charAt(rnd.nextInt(chars.length()));
		if(ch == toss) {
			return true;
		}
		return false;
	}
	
	public static void display(TeamIndia[] teamA_Details, TeamIndia[] teamB_Details, String teamA, String teamB) {
		System.out.println("\t\t"+teamA+" ||\t\t"+teamB);
		System.out.println("====================||$||====================");
		for(int i=0; i<10; i++) {
			System.out.println("\t\t"+teamA_Details[i].getName()+
					" ||\t\t"+teamB_Details[i].getName());
		}
	}
	
	public static void instruction() {
		// Over 
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in); 
		System.out.println("Getting Ready to Play...");
		System.out.println("====================================================");
		
		// Team Names
		String teamA_Name = "Team India";
		System.out.println("Enter your Team Name:");
		String teamB_Name= "Team " +sc.next();
		
		System.out.println(teamA_Name +"  VS  "+teamB_Name);
		// Team A Registration
		TeamIndia teamA_Details[] = new TeamIndia[10];
		teamIndiaRegistation(teamA_Details);
	
		// Team B Registration
		TeamIndia teamB_Details[] = new TeamIndia[10];
		teamBRegistation(teamB_Details);
		
		// Games Inputs
		System.out.println("Enter the No of Overs you wanted to play");
		int over = sc.nextInt();
		// Toss : Heads or Tails
		System.out.println("Enter your Toss:(H/T)");
		char ch = sc.next().charAt(0);
		ch = Character.toUpperCase(ch);
		if(isWonToss(ch)) {
			System.out.println("Congrats! You won the Toss");
		}else {
			System.out.println( teamA_Name+" won the Toss");
		}
		sc.close();
		
		// Display the team Status
		display(teamA_Details, teamB_Details,teamA_Name,teamB_Name);
	}
}
