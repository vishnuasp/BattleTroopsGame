package battleGameTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import battleGame.Battle;
import battleGame.Monkey;
import battleGame.Player;
import battleGame.Troop;
import battleGame.TroopFactory;
import battleGame.Wizard;

public class BattleTest {

	@Test
	void testBattleConstructor() {
		Player player1 = new Player("P1");
		Player player2 = new Player("P2");
		Battle battle = new Battle(new Player(""), new Player(""), 
				null, null, -1);
		battle.setPlayerOne(player1);
		battle.setPlayerTwo(player2);
		battle.setTroopOrder1(new ArrayList<String>());
		battle.setTroopOrder2(new ArrayList<String>());
		battle.setSize(0);
		String expectedName1 = "P1";
		int expectedtroopOrderSize1 = 0;
		int expectedArmySize = 0;
		String expectedName2 = "P2";
		int expectedtroopOrderSize2 = 0;
		String expectedWinnerName = "P1";
		battle.setWinner(player1);
		
		Assert.assertEquals(expectedName1, battle.getPlayerOne().getPlayerName());
		Assert.assertEquals(expectedtroopOrderSize1, battle.getTroopOrder1().size());
		Assert.assertEquals(expectedArmySize, battle.getSize());
		Assert.assertEquals(expectedName2, battle.getPlayerTwo().getPlayerName());
		Assert.assertEquals(expectedtroopOrderSize2, battle.getTroopOrder2().size());
		Assert.assertEquals(expectedWinnerName, battle.getPlayerOne().getPlayerName());
	}
	
	@Test
	void testCreateArmies() throws Exception {
		Battle battle = new Battle();
		battle.setPlayerOne(new Player("P1"));
		battle.setPlayerTwo(new Player("P2"));
		List<String> order = new ArrayList<String>();
		order.add("Monkey");
		order.add("Balloon");
		battle.setTroopOrder1(order);
		battle.setTroopOrder2(order);
		battle.setSize(20);
		battle.createArmies();
		Assert.assertEquals(20, battle.getPlayerOne().getTroopArmy().size());
		Assert.assertEquals(20, battle.getPlayerTwo().getTroopArmy().size());
	}
	
	@Test
	void testBattleRoundWithNullTroop() throws NullPointerException{
		Battle battle = new Battle();
		Troop troopA = null;
		Troop troopB = null;
		Assertions.assertThrows(NullPointerException.class, () -> battle.battleRound(troopA, troopB));
	}
	
	@Test
	void testBattleRoundWithOneNullTroop() throws NullPointerException{
		Battle battle = new Battle();
		Troop troopA = null;
		Troop troopB = new Monkey();
		Assertions.assertThrows(NullPointerException.class, () -> battle.battleRound(troopA, troopB));
		Assertions.assertThrows(NullPointerException.class, () -> battle.battleRound(troopB, troopA));
	
	}
	
	@Test
	void testBattleRoundNonNull() throws Exception{
		Player player1 = new Player("PlayerOne");
		Player player2 = new Player("PlayerOne");
		Battle battle = new Battle();
		battle.setPlayerOne(player1);
		battle.setPlayerTwo(player2);
		List<String> order = new ArrayList<String>();
		order.add("Monkey");
		battle.setTroopOrder1(order);
		battle.setTroopOrder2(order);
		battle.setSize(1);
		battle.createArmies();
		battle.battleRound(player1.getNextTroop(), player2.getNextTroop());
		Assert.assertEquals(44.0, player1.getNextTroop().getHealth(), 0); 
		Assert.assertEquals(44.0, player2.getNextTroop().getHealth(), 0); 
	}
	
	@Test
	void testBattleWhereTroopDies() {
		Battle battle = new Battle();
		battle.setPlayerOne(new Player("P1"));
		battle.setPlayerTwo(new Player("P2"));
		Troop troop1 = new Wizard();
		Troop troop2 = new Wizard();
		troop1.setHealth(6);
		troop2.setHealth(6);
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput  = "Round No: 0\r\n" + 
        		"P1 Wizard, Health = 6.0, Total Damage = 0.0\r\n" + 
        		" Vs P2 Wizard, Health = 6.0, Total Damage = 0.0\r\n" + 
        		"P1 Wizard was killed\r\nP2 Wizard was killed\r\n\r\n";
	    battle.battleRound(troop1, troop2);
		assertEquals(expectedOutput, outContent.toString());
		
	}
	
	@Test
	void testDisplayWinningArmyNoWinner() {
		Battle battle = new Battle();
		battle.setWinner(null);
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput  = "Winning Player could not be determined\r\n";
	    battle.displayWinningArmy();
		assertEquals(expectedOutput, outContent.toString());
	}
	
	@Test
	void testDisplayWinningArmy() throws Exception {
		Battle battle = new Battle();
		battle.setPlayerOne(new Player("P1"));
		battle.setWinner(battle.getPlayerOne());
		Player p1 = battle.getPlayerOne();
		List<Troop> army= new LinkedList<Troop>();
		army.add(new TroopFactory().buildTroop("Monkey"));
		p1.setTroopArmy(army);
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput  = "The winning player is: P1\r\n" + 
        		"P1's Remaining Army is:\r\n" + 
        		"Monkey, Health = 50.0, Total Damage = 0.0\r\n\r\n\r\n";
	    battle.displayWinningArmy();
		assertEquals(expectedOutput, outContent.toString());
	}
	
	@Test
	void testBattleWithPlayerOneWinning() throws Exception {
		Battle battle = new Battle();
		battle.setPlayerOne(new Player("P1"));
		battle.setPlayerTwo(new Player("P2"));
		List<String> order = new ArrayList<String>();
		order.add("Monkey");
		battle.setTroopOrder1(order);
		battle.setTroopOrder2(new ArrayList<String>());
		battle.setSize(1);
		battle.createArmies();
	    battle.startBattle();
		assertEquals("P1", battle.getWinner().getPlayerName());
	}
	
	@Test
	void testBattleWithPlayerTwoWinning() throws Exception {
		Battle battle = new Battle();
		battle.setPlayerOne(new Player("P1"));
		battle.setPlayerTwo(new Player("P2"));
		List<String> order = new ArrayList<String>();
		order.add("Monkey");
		battle.setTroopOrder2(order);
		battle.setTroopOrder1(new ArrayList<String>());
		battle.setSize(1);
		battle.createArmies();
	    battle.startBattle();
		assertEquals("P2", battle.getWinner().getPlayerName());
	}
	
	@Test
	void testBattleWithNoPlayerWinning() throws Exception {
		Battle battle = new Battle();
		battle.setPlayerOne(new Player("P1"));
		battle.setPlayerTwo(new Player("P2"));
		List<String> order = new ArrayList<String>();
		order.add("Monkey");
		battle.setTroopOrder1(order);
		battle.setTroopOrder2(order);
		battle.setSize(1);
		battle.createArmies();
		battle.getPlayerOne().getNextTroop().setHealth(0);
		battle.getPlayerTwo().getNextTroop().setHealth(0);
	    battle.startBattle();
		assertEquals(0, battle.getPlayerOne().getTroopArmy().size());
		assertEquals(0, battle.getPlayerTwo().getTroopArmy().size());
		assertEquals(null, battle.getWinner());
	}
	
	@Test
	void testDisplayArmies() {
		Battle battle = new Battle();
		battle.setPlayerOne(new Player("P1"));
		battle.setPlayerTwo(new Player("P2"));
		battle.displayArmies();
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput  = "Winning Player could not be determined\r\n";
	    battle.displayWinningArmy();
		assertEquals(expectedOutput, outContent.toString());
	}
	
	@Test
	void testNoOutstandingTroop() {
		Battle battle = new Battle();
		battle.setWinner(null);
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput  = "Outstanding Troop could not be determined\r\n";
	    battle.displayOutstandingTroop();
		assertEquals(expectedOutput, outContent.toString());
	}

	@Test
	void testOutStandingTroop() {
		Battle battle = new Battle();
		battle.setPlayerOne(new Player("P1"));
		Player playerOne = battle.getPlayerOne();
		List<Troop> army = new LinkedList<Troop>();
		Troop monkey = new Monkey();
		monkey.setTotalDamage(31);
		Troop wizard = new Wizard();
		wizard.setTotalDamage(24);
		army.add(wizard); army.add(monkey);
		playerOne.setTroopArmy(army);
		battle.setWinner(playerOne);
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput  = "The outstanding troop from survivors is: \r\n" + 
        		"Monkey, Health = 50.0, Total Damage = 31.0\r\n";
	    battle.displayOutstandingTroop();
		assertEquals(expectedOutput, outContent.toString());
	
		
	}
}
