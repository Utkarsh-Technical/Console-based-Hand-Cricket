package handCricket;

import java.util.*;

class TeamIndia {
	
	String name;
	String role;
	
	// If batsmans, then how much Runs
	int score = 0;
	
	// Out or Not-Out
	int status = 0;
	
	//Balls Player Played
	int balls= 0;
	
	// Parameterized Constructor
	public TeamIndia(String name, String role) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.role = role;
	}

	// Default Constructors
	public TeamIndia() {
		// TODO Auto-generated constructor stub
	}
	
	// Storing the names of the Player
	String getName() {
		return name;
	}
	
	// Role of Player : Caption, Batsman, Bowler
	String getRole() {
		return role;
	}
	
	// Individual Players Score
	int getScore() {
		return score;
	}
	
	// How many balls played by player
	int getBalls() {
		return balls;
	}
	
	// Status of Player : Not-Out & Out
	String currentStatus() {
		if(status == 0)
			return "NOT OUT";
		return "OUT";
	}
	
	// Add runs for the player
	public void setScores(int run) {
		this.score = run;
	}
	//Change the Status to OUT	
	public void changeStatus(){
		status = 1;
	}
	
	//Store the Balls that Player played.
	public void setBalls(int balls) {
		this.balls = balls;
	}
}

public class handCricket {

	//Team A Registration
	public static void teamIndiaRegistation(TeamIndia teamIndia_Details[]) {
		teamIndia_Details[0] = new TeamIndia ("Rohit Sharma","Captain");
		teamIndia_Details[1] = new TeamIndia ("Virat Kohli","Batsman");
		teamIndia_Details[2] = new TeamIndia ("Suryakumar","Batsman");
		teamIndia_Details[3] = new TeamIndia ("R. Ashwin","Bowler");
		teamIndia_Details[4] = new TeamIndia ("Arshdeep Singh","Bowler");
	}
	
	// Checking for the Toss Won
	public static boolean isWonToss(char ch) {
		String chars = "HTHHTTHHT";
		Random rnd = new Random();
		char toss = chars.charAt(rnd.nextInt(chars.length()));
		if(ch == toss) {
			return true;
		}
		return false;
	}
	
	// Display the Name of the Player in the Starting of Match
	public static void display(TeamIndia[] teamA_Details, TeamIndia[] teamB_Details, String teamA, String teamB) {
		System.out.println("\t"+teamA+"\t\t"+teamB);
		System.out.println("====================================================");
		for(int i=0; i<5; i++) {
			System.out.println("\t"+teamA_Details[i].getName()+
					"\t\t"+teamB_Details[i].getName());
		}
	}
	
	// Scoreboard of the Team
	public static int scoreboard(TeamIndia[] teamD, String team) {
		System.out.println("\t"+team);
		System.out.println("==============================================================");
		System.out.println("Name\t\tRole\t\tScores\t\tStatus\t\tBalls");
		int teamScore = 0;
		for(int i=0; i<5; i++) {
			System.out.println(teamD[i].getName()+ "\t\t" + teamD[i].getRole() + "\t\t" + teamD[i].getScore() 
					+ "\t\t" +teamD[i].currentStatus()+"\t\t"+teamD[i].getBalls());
			teamScore += teamD[i].getScore();
		}
		return teamScore;
	}
	
	// Instructions for the Game
	public static void instruction() {
		System.out.println("Hand Cricket is a game in which two players show scores on their respective \n"
				+ "fingers. If the scores are equal, the batsman is declared out. Else, the score of the\n"
				+ " batsman is added to the total runs of the batting team.");
		System.out.println("Entry the Runs from 0 to 6");
		System.out.println("==============================================================");
		System.out.println("==============================================================");
	}
	
	// Main Game 
	public static void calculateRuns(int balls, TeamIndia[] teamBatting) {
		Scanner sc = new Scanner(System.in);
		int runs = 0;
		int player = 0;
		int ballsPlayed = 0;
		System.out.println(teamBatting[player].getName()+ " is going Bat");
		for(int i=1; i<=balls && player<teamBatting.length ;) {
			int batting = sc.nextInt();
			if(batting >= 0 && batting <= 6) {
				int bowling = (int)Math.random()*6 + 1;
				System.out.println(batting+" : "+bowling);
				ballsPlayed++;
				if(bowling == batting) {
					System.out.println(teamBatting[player].getName() + " is OUT");
					teamBatting[player].setBalls(ballsPlayed); 
					teamBatting[player].setScores(runs);
					teamBatting[player].changeStatus();
					player++;
					runs=0; ballsPlayed=0;
					System.out.println(teamBatting[player].getName()+ " is going next to Bat");
				}
				else {
					runs += batting;
				}
				i++;
			}
			else {
				System.out.println("Invalid Input: Plz enter the value from 0 to 6");
			}
				
		}
		System.out.println("---Inning Finished---");
		teamBatting[player].setBalls(ballsPlayed); 
		teamBatting[player].setScores(runs);
		return ;
	}
	
	
	
	public static void main(String[] args) throws Exception{
		Scanner sc= new Scanner(System.in); 
		instruction();
		System.out.println("Getting Ready to Play...");
		System.out.println("==============================================================");
		
		// Team Name
		String teamA_Name = "Team India";
		System.out.println("Enter your Team Name:");
		String teamB_Name= "Team " +sc.next();
		System.out.println(teamA_Name +"  VS  "+teamB_Name);
		
		// Team A Registration
		TeamIndia teamA_Details[] = new TeamIndia[5];
		teamIndiaRegistation(teamA_Details);
		
		// Team B Registration
		TeamIndia teamB_Details[] = new TeamIndia[5];
		for(int i=0; i<5; i++) {
			System.out.println("Enter the Player Name :");
			String name = sc.next();
			System.out.println("1.Captain  2.Batsman  3.Bowler");
			int val = sc.nextInt();
			String status = null;
			
			if(val == 1)
				status = "Captain";
			else if(val == 2)
				status = "Batsman";
			else 
				status = "Bowler";
			
			teamB_Details[i] = new TeamIndia(name,status);
		}
		
		// Display the teams Name
		display(teamA_Details, teamB_Details, teamA_Name, teamB_Name);
		
		// Games Inputs : Overs
		System.out.println("Enter the No of Overs you wanted to play");
		int overs = sc.nextInt();
		int balls = overs*6;
		
		// Toss : Heads or Tails
		System.out.println("Enter your Toss:(H/T)");
		char ch = sc.next().charAt(0);
		ch = Character.toUpperCase(ch);
		
		// Check the TOSS 
		if(isWonToss(ch)) {
			System.out.println("Congrats! You won the Toss\n1. Batting\t2. Bowling");
			int choice = sc.nextInt();
			if(choice == 1) {
				calculateRuns(balls,teamB_Details);
				// Score of the Team
				int teamB = scoreboard(teamB_Details, teamB_Name);
				calculateRuns(balls,teamA_Details);
				// Score of the Team
				int teamA = scoreboard(teamA_Details, teamA_Name);
				
				if(teamA > teamB)
					System.out.println(teamA_Name + " won the match by "+ (teamA-teamB)+" Runs");
				else if(teamA < teamB)
					System.out.println(teamB_Name + " won the match by " + (teamB-teamA)+" Runs");
				else
					System.out.println("Match is Tie");
			} else {
				calculateRuns(balls,teamA_Details);
				// Score of the Team
				int teamA = scoreboard(teamA_Details, teamA_Name);
				calculateRuns(balls,teamB_Details);
				// Score of the Team
				int teamB = scoreboard(teamB_Details, teamB_Name);
				
				if(teamA > teamB)
					System.out.println(teamA_Name + " won the match by "+ (teamA-teamB)+" Runs");
				else if(teamA < teamB)
					System.out.println(teamB_Name + " won the match by " + (teamB-teamA)+" Runs");
				else
					System.out.println("Match is Tie");
			}
		}
		else {
			System.out.println(teamA_Name+" won the Toss\n Choose the Batting..");
			calculateRuns(balls,teamA_Details);
			// Score of the Team
			int teamA = scoreboard(teamA_Details, teamA_Name);
			calculateRuns(balls,teamB_Details);
			// Score of the Team
			int teamB = scoreboard(teamB_Details, teamB_Name);
			
			if(teamA > teamB)
				System.out.println(teamA_Name + " won the match by "+ (teamA-teamB)+" Runs");
			else if(teamA < teamB)
				System.out.println(teamB_Name + " won the match by " + (teamB-teamA)+" Runs");
			else
				System.out.println("Match is Tie");
		}
		sc.close();
		
		
		
		
	}
}
