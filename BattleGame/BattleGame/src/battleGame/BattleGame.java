package battleGame;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BattleGame {
	public static void main(String args[]) {
		try {
			// Initializing Troop creation order and army size.
			Player playerOne = new Player("Player 1");
			Player playerTwo = new Player("Player 2");
			List<String> troopOrder1 = new ArrayList<String>();
			List<String> troopOrder2 = new ArrayList<String>();
			troopOrder1.addAll(Arrays.asList(new String[] {"Monkey", "Flying Monkey", "Wizard", "Balloon"}));
			troopOrder2.addAll(Arrays.asList(new String[] {"Flying Monkey", "Wizard", "Balloon", "Monkey"}));
			int armySize = 20;
			
			// Creating armies and starting the battle between two players.
			Battle battle = new Battle(playerOne, playerTwo, troopOrder1, troopOrder2, armySize);
			battle.createArmies();
			battle.displayArmies();
			battle.startBattle();
			battle.displayWinningArmy();
			battle.displayOutstandingTroop();
		} catch (Exception e) {
			System.out.print(e.toString());
		}
	}
}
