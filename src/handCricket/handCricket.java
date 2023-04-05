package handCricket;

import java.util.*;
import java.util.concurrent.*;


public class handCricket {
	
	// Team A Registration
	public static Team[] TeamA_Registation(int teamSize) {
		Random random = new Random();
		ArrayList<Player> players = new ArrayList<>();
    	players.add(new Player("KL Rahul", "Batsman"));
        players.add(new Player("Virat Kohli", "Batsman"));
        players.add(new Player("Suryakumar", "Batsman"));
        players.add(new Player("Hardik Pandya", "All-rounder"));
        players.add(new Player("Rishabh Pant", "Wicket-Keeper"));
        players.add(new Player("Ravindra Jadeja", "All-rounder"));
        players.add(new Player("R. Ashwin", "Bowler"));
        players.add(new Player("Arshdeep Singh", "Bowler"));
        players.add(new Player("Jasprit Bumrah", "Bowler"));
        for(int i=0; i<(10-teamSize); i++) {
        	int randomIndex = random.nextInt(players.size());
        	Player randomElement = players.get(randomIndex);
        	players.remove(randomIndex);
        }
        Team teamA[] = new Team[teamSize];
        int c=0;
        teamA[c++] = new Team("Rohit Sharma","Captain");
        for (Player p : players) {
        	teamA[c++] = new Team(p.getName(), p.getRole());
        }
        return teamA;
    }
	
	// Team B Registration
	public static Team[] TeamB_Registation(int teamSize) {
		Scanner sc = new Scanner(System.in);
		Team teamB[] = new Team[teamSize];
		boolean captain = true;
		String status = null;
		for(int i=0; i<teamSize; i++) {
			System.out.println("Enter the Player Name :");
			String name = sc.next();
			
			// Captain has to be one only
			if(captain) {
				System.out.println("1.Captain  2.Batsman  3.Bowler  4.All-Rounder  5.Wicket-Keeper");
				int val = sc.nextInt();
				switch (val) {
				case 1:
					status = "Captain";
					captain = false;
					break;
				case 2:
					status = "Batsman";
					break;
				case 3:
					status = "Bowler";
					break;
				case 4:
					status = "All-Rounder";
					break;
				case 5:
					status = "Wicket-Keeper";
					break;
				}
			}
			else {
				System.out.println("1.Batsman  2.Bowler  3.All-Rounder  4.Wicket-Keeper");
				int val = sc.nextInt();
				switch (val) {
				case 1:
					status = "Batsman";
					break;
				case 2:
					status = "Bowler";
					break;
				case 3:
					status = "All-Rounder";
					break;
				case 4:
					status = "Wicket-Keeper";
					break;
				}
			}
			teamB[i] = new Team(name,status);
		}
		return teamB;
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
	public static void display(Team[] teamA_Details, Team[] teamB_Details, String teamA, String teamB, int teamSize) {
		System.out.println("\t"+teamA+"\t\t"+teamB);
		System.out.println("====================================================");
		for(int i=0; i<teamSize; i++) {
			System.out.println("\t"+teamA_Details[i].getName()+
					"\t\t"+teamB_Details[i].getName());
		}
	}
	
	// Scoreboard of the Team
	public static int scoreboard(Team[] teamD, String team, int teamSize) {
		System.out.println("\t"+team);
		System.out.println("==============================================================");
		System.out.println("Name\t\tRole\t\tScores\t\tStatus\t\tBalls");
		int teamScore = 0;
		for(int i=0; i<teamSize; i++) {
			System.out.println(teamD[i].getName()+ "\t\t" + teamD[i].getRole() + "\t\t" + teamD[i].getScore() 
					+ "\t\t" +teamD[i].currentStatus()+"\t\t"+teamD[i].getBalls());
			teamScore += teamD[i].getScore();
		}
		System.out.println("========== \tTotal Score : "+teamScore+" \t==========");
		return teamScore;
	}
	
	// Instructions for the Game
	static {
		System.out.println("Hand Cricket is a game in which two players show scores on their respective \n"
				+ "fingers. If the scores are equal, the batsman is declared out. Else, the score of the\n"
				+ " batsman is added to the total runs of the batting team.");
		System.out.println("Entry the Runs from 0 to 6");
		System.out.println("==============================================================");
	}
	
	// Game 
	public static void calculateRuns(int balls, Team[] teamBatting) {
		Scanner sc = new Scanner(System.in);
		int runs = 0;
		int player = 0;
		int ballsPlayed = 0;
		System.out.println(teamBatting[player].getName()+ " is going to Bat");
		for(int i=1; i<=balls && player<teamBatting.length ;) {
			int batting = sc.nextInt();
			if(batting >= 0 && batting <= 6) {
				ThreadLocalRandom random = ThreadLocalRandom.current();
				int bowling = random.nextInt(1, 7);
				System.out.println(batting+" : "+bowling);
				ballsPlayed++;
				if(bowling == batting) {
					System.out.println(teamBatting[player].getName() + " is OUT");
					teamBatting[player].setBalls(ballsPlayed); 
					teamBatting[player].setScores(runs);
					teamBatting[player].changeStatus();
					player++;
					if(player == teamBatting.length) {
						return ;
					}
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
	
	// Go for Batting or Bowling based on toss
	public static void batting_OR_bowling(int choice, int balls, Team[] teamA,Team[] teamB, int teamSize, String teamA_Name, String teamB_Name) {

		if(choice == 1) {
			// Score of the Team B
			calculateRuns(balls,teamB);
			int teamB_Score = scoreboard(teamB, teamB_Name,teamSize);
			
			// Score of the Team
			calculateRuns(balls,teamA);
			int teamA_Score = scoreboard(teamA, teamA_Name, teamSize);
			
			if(teamA_Score > teamB_Score)
				System.out.println(teamA_Name + " won the match by "+ (teamA_Score-teamB_Score)+" Runs");
			else if(teamA_Score < teamB_Score)
				System.out.println(teamB_Name + " won the match by " + (teamB_Score-teamA_Score)+" Runs");
			else
				System.out.println("Match is Tie");
		} 
		else if(choice == 2) {
			// Score of the Team A
			calculateRuns(balls,teamA);
			int teamA_Score = scoreboard(teamA, teamA_Name, teamSize);
			
			// Score of the Team B
			calculateRuns(balls,teamB);
			int teamB_Score = scoreboard(teamB, teamB_Name, teamSize);
			
			if(teamA_Score > teamB_Score)
				System.out.println(teamA_Name + " won the match by "+ (teamA_Score-teamB_Score)+" Runs");
			else if(teamA_Score < teamB_Score)
				System.out.println(teamB_Name + " won the match by " + (teamB_Score-teamA_Score)+" Runs");
			else
				System.out.println("Match is Tie");
		}
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc= new Scanner(System.in); 
	
		System.out.println("Getting Ready to Play...");
		System.out.println("=============================================");
		
		// Team Name
		String teamA_Name = "Team India";
		System.out.println("Enter your Team Name:");
		String teamB_Name= "Team " +sc.nextLine();
		System.out.println(teamA_Name +"  VS  "+teamB_Name);
		
		// Team Size
		System.out.println("Enter your Team Size: ");
		int teamSize = sc.nextInt();
		
		// Team A Registration
		Team teamA[] = TeamA_Registation(teamSize);
		
		// Team B Registration
		Team teamB[] = TeamB_Registation(teamSize);
		
		// Display the teams Name
		display(teamA, teamB, teamA_Name, teamB_Name,teamSize);
		
		// Games Inputs : Overs
		System.out.println("Enter No of Overs you wanted to play :");
		int overs = sc.nextInt();
		int balls = overs*6;
		
		// Toss : Heads or Tails
		System.out.println("Enter your Toss:(H/T)");
		char ch = sc.next().charAt(0);
		ch = Character.toUpperCase(ch);
		
		// If user won the Toss.
		if(isWonToss(ch)) {
			System.out.println("Congrats! You won the Toss\n1. Batting\t2. Bowling");
			boolean correctInput = false;
			while(!correctInput) {
				int choice = sc.nextInt();
				if(choice == 1 || choice == 2) {
					correctInput = true;
					batting_OR_bowling(choice,balls, teamA, teamB,teamSize,teamA_Name, teamB_Name);
				}
				else {
					System.out.println("Invalid Input");
				}
			}
		}
		
		// If computer won the Toss.
		else {
			System.out.print(teamA_Name+" won the Toss");
			ThreadLocalRandom random = ThreadLocalRandom.current();
			int choice = random.nextInt(1, 3);
			if(choice == 2)
				System.out.println("& choose to bat");
			else
				System.out.println("& choose to bowl");
			
			batting_OR_bowling(choice,balls, teamA, teamB,teamSize,teamA_Name, teamB_Name);
		}
		sc.close();
	}

}
