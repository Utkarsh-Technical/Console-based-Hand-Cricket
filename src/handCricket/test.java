package handCricket;

import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class test {
	
	public static class Player {
	    String name;
	    String role;

	    public Player(String name, String role) {
	        this.name = name;
	        this.role = role;
	    }

	    public String getName() {
	        return name;
	    }

	    public String getRole() {
	        return role;
	    }
	}
	
    
	public static void main(String[] args) {
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
        
        Scanner sc = new Scanner(System.in);
        int teamSize = sc.nextInt();
        
        for(int i=0; i<(10-teamSize); i++)
        {
        	int randomIndex = random.nextInt(players.size());
        	Player randomElement = players.get(randomIndex);
        	players.remove(randomIndex);
        }
        // print the players' names and roles
        for (Player p : players) {
            System.out.println(p.getName() + " - " + p.getRole());
        }
    }
}



      
