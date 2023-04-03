package handCricket;

class Team {
	
	String name;
	//Bats-man || Bowler || Captain
	String role;
	// If batsmans, then how much Runs
	int score = 0;
	// Out or Not-Out
	boolean isOut = false;
	//Balls Player Played
	int balls= 0;
	
	// Parameterized Constructor
	public Team(String name, String role) {
		this.name = name;
		this.role = role;
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
		if(isOut)
			return "OUT";
		return "NOT OUT";
	}
	
	// Add runs for the player
	public void setScores(int run) {
		this.score = run;
	}
	
	//Change the Status to OUT	
	public void changeStatus(){
		isOut = true;
	}
	
	//Store the Balls that Player played.
	public void setBalls(int balls) {
		this.balls = balls;
	}
}