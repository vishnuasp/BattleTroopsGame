package battleGame;

import java.util.LinkedList;
import java.util.List;

public class Player {
	private String playerName;
	private List<Troop> troopArmy;
	private int currentTroopIndex;
	
	public Player(String playerName) {
		this.playerName = playerName;
		this.troopArmy = new LinkedList<Troop>();
		this.currentTroopIndex = 0;
	}
	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public void setTroopArmy(List<Troop> troopArmy) {
		this.troopArmy = troopArmy;
	}
	
	public void setCurrentIndex(int currentTroopIndex) {
		this.currentTroopIndex = currentTroopIndex;
	}
	
	public String getPlayerName() {
		return this.playerName;
	}
	
	public List<Troop> getTroopArmy() {
		return this.troopArmy;
	}
	
	public int getCurrentIndex() {
		return this.currentTroopIndex;
	}
	
	public void createArmy(List<String> troopOrder, int armySize) throws Exception {
		if (troopOrder.size() != 0) {
			TroopFactory troopFactory = new TroopFactory();
			for (int i = 0; i < armySize; i++) {
				Troop troop=  troopFactory.buildTroop(troopOrder.get(i % troopOrder.size()));
				this.troopArmy.add(troop);
			}
		} else {
			System.out.println("Invalid creation order pattern detected for " + this.getPlayerName());
		}
		
	}
	
	public void displayTroops() {
		if(this.troopArmy.size() != 0) {
				System.out.println("Player: " + this.playerName +"'s Army is:");
				for (Troop troop : troopArmy) {
					System.out.println(troop.getTroopName());
				}
				System.out.println();

		} else {
			System.out.println("There are no troops");
		}
		
	}
	
	public void displayArmy() {
		if (this.troopArmy.size() == 0) {
			System.out.println("The army has no survivors");
		} else {
			System.out.println(this.playerName +"'s Remaining Army is:");
			for (Troop troop : troopArmy) {
				troop.displayHealthDamage();
			}
			System.out.println();
		}
	}
	
	public Troop getNextTroop() {
		// Note: currentTroopIndex is also changed when a troop is killed/deleted. see -> Player.delete() method
		Troop troop = null;
		if (this.troopArmy.size() != 0 && currentTroopIndex >=0) {
			troop = this.troopArmy.get(this.currentTroopIndex++ % this.troopArmy.size());
		} 
		return troop;
	}
	
	public void getOutstandingTroop() {
		// Among surviving troop get the outstanding troop.
		Troop bestTroop = null;
		int maxOnes = Integer.MIN_VALUE;
		for (Troop troop : troopArmy) {
			if (troop.getContinuousOnes() > maxOnes) {
				maxOnes = troop.getContinuousOnes();
				bestTroop = troop;
			}
		}
		if (bestTroop != null)
			bestTroop.displayHealthDamage();
		else 
			System.out.println("There is no Outstanding Troop");
	}

	public void delete(Troop troop) {
		// Here, index is updated here as the list size is changed when a troop is killed.
		if(troopArmy.size() != 0)
			this.currentTroopIndex =  (this.currentTroopIndex % (troopArmy.size())) == 0 ? 0 : (this.currentTroopIndex % (troopArmy.size())) - 1 ;
			troopArmy.remove(troop);
	}
}
