package battleGame;

import java.util.List;

public class Battle {
	
	private Player playerOne;
	private Player playerTwo;
	private List<String> troopOrder1;
	private List<String> troopOrder2;
	private int armySize;
	private int roundNumber;
	private Player winner;
	
	public Battle(Player playerOne, Player playerTwo, List<String> troopOrder1, List<String> troopOrder2, int armySize) {
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.troopOrder1 = troopOrder1;
		this.troopOrder2 = troopOrder2;
		this.armySize = armySize;
		this.roundNumber = 1;
		this.winner = null;
	}
	
	public Battle() {
		
	}

	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}
	
	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}
	
	public void setTroopOrder1(List<String> troopOrder1) {
		this.troopOrder1 = troopOrder1;
	}
	
	public void setTroopOrder2(List<String> troopOrder2) {
		this.troopOrder2 = troopOrder2;
	}
	
	public void setSize(int armySize) {
		this.armySize = armySize;
	}
	
	public void setWinner(Player winner) {
		this.winner = winner;
	}
	
	public Player getPlayerOne() {
		return this.playerOne;
	}
	
	public Player getPlayerTwo() {
		return this.playerTwo;
	}
	
	public List<String> getTroopOrder1() {
		return this.troopOrder1;
	}
	
	public List<String> getTroopOrder2() {
		return this.troopOrder2;
	}

	public int getSize() {
		return this.armySize;
	}
	
	public Player getWinner() {
		return this.winner;
	}
	
	public void createArmies() throws Exception {
		System.out.println("Creating Armies... \n");
		playerOne.createArmy(troopOrder1, armySize);
		playerTwo.createArmy(troopOrder2, armySize);
	}
	
	public void battleRound(Troop troopA, Troop troopB) throws NullPointerException{

			if (troopA == null || troopB == null) {
				throw new NullPointerException("Null troop detected");
			} else {
				// printing the battle round events.
				System.out.println("Round No: " + roundNumber ++);
				System.out.print(playerOne.getPlayerName() + " ");troopA.displayHealthDamage();
				System.out.print(" Vs ");
				System.out.print(playerTwo.getPlayerName() + " "); troopB.displayHealthDamage();
				
				troopA.attack(troopB);
				troopB.attack(troopA);
				
				// after fight, case where the troops die.
				if (troopA.getHealth() == 0) {
					playerOne.delete(troopA);
					System.out.println(playerOne.getPlayerName() + " " +troopA.getTroopName() +" was killed");
				} 
				if (troopB.getHealth() == 0) {
					playerTwo.delete(troopB);
					System.out.println(playerTwo.getPlayerName() + " " +troopB.getTroopName() +" was killed");
				}
				System.out.println();
			}
		
	}

	public void startBattle() {
		System.out.println("Starting the Battle... \n");
		
		// get next troop in line from each player's army and start battle round.
		while (playerOne.getTroopArmy().size() != 0 && playerTwo.getTroopArmy().size() != 0) {
			Troop troopA = playerOne.getNextTroop();
			Troop troopB = playerTwo.getNextTroop();
			if(troopA != null && troopB != null)
				battleRound(troopA, troopB);
		}
		
		// when the battle ends the winner has to be set
		if (playerOne.getTroopArmy().size() == 0 && playerTwo.getTroopArmy().size() == 0) {
			System.out.println("There are no survivors in both armies");
		} else if (playerOne.getTroopArmy().size() == 0) {
			this.winner = playerTwo;
		} else {
			this.winner = playerOne;
		}
	}

	public void displayArmies() {
		System.out.println("Displaying battling armies... \n");
		this.playerOne.displayTroops();
		this.playerTwo.displayTroops();
	}
	
	public void displayWinningArmy() {
		if(this.winner != null) {
			System.out.println("The winning player is: " + this.winner.getPlayerName());
			this.winner.displayArmy();
			System.out.println();
		} else {
			System.out.println("Winning Player could not be determined");
		}
	}
	
	public void displayOutstandingTroop() {
		if(this.winner != null) {
			System.out.println("The outstanding troop from survivors is: ");
			this.winner.getOutstandingTroop();
		} else {
			System.out.println("Outstanding Troop could not be determined");
		}
	}
}
