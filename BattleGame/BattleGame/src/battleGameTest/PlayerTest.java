package battleGameTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import battleGame.Player;
import battleGame.Troop;
import battleGame.TroopFactory;

public class PlayerTest {

	@Test
	void testConstructor() {
		List<Troop> army = new LinkedList<Troop>();
		Player player = new Player("");
		player.setPlayerName("Player One");
		player.setCurrentIndex(0);
		player.setTroopArmy(army);
		String expectedName = "Player One";
		int expectedArmyIndex = 0;
		int expectedArmySize = 0;
		Assert.assertEquals(expectedName, player.getPlayerName());
		Assert.assertEquals(expectedArmyIndex, player.getCurrentIndex());
		Assert.assertEquals(expectedArmySize , player.getTroopArmy().size());
	}
	
	@Test
	void testCreateArmy() throws Exception{
		Player player = new Player("Player");
		List<String> order1 = new LinkedList<String>();
		order1.add("Monkey"); order1.add("Wizard");
		player.createArmy(order1, 6);
		Assert.assertEquals(6, player.getTroopArmy().size());
	}
	
	@Test
	void testCreateArmyWithNoTroopInformation() throws Exception{
		Player player = new Player("Player");
		List<String> order1 = new LinkedList<String>();
		player.createArmy(order1, 5);
		Assert.assertEquals(0, player.getTroopArmy().size());
	}
	
	@Test
	void testDisplayTroops() throws Exception {
		Player player = new Player("Player");
		List<String> order1 = new LinkedList<String>();
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
		order1.add("Monkey"); order1.add("Wizard");
		player.createArmy(order1, 2);
	    String expectedOutput  = "Player: Player's Army is:\r\nMonkey\r\nWizard\r\n\r\n";
	    player.displayTroops();
	    assertEquals(expectedOutput, outContent.toString());
	}
	
	@Test
	void testDisplayWithNoTroops() throws Exception {
		Player player = new Player("Player");
		List<String> order1 = new LinkedList<String>();
		player.createArmy(order1, 2);
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
	    String expectedOutput  = "There are no troops\r\n";
	    player.displayTroops();
	    assertEquals(expectedOutput, outContent.toString());
	}
	
	@Test
	void testDisplayWithInvalidTroop() throws Exception {
		Player player = new Player("Player");
		List<Troop> army = new LinkedList<Troop>();
		army.add(new TroopFactory().buildTroop("Monkey"));
		Assertions.assertThrows(Exception.class, () -> army.add(new TroopFactory().buildTroop("Invalid")));
		player.setTroopArmy(army);
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
	    String expectedOutput  = "Player: Player's Army is:\r\nMonkey\r\n\r\n";
	    player.displayTroops();
	    assertEquals(expectedOutput, outContent.toString());
	}
	
	@Test
	void testDisplayArmy() throws Exception{
		Player player = new Player("Player");
		List<String> order1 = new LinkedList<String>();
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
		order1.add("Monkey"); order1.add("Wizard");
		player.createArmy(order1, 2);
	    String expectedOutput  = "Player's Remaining Army is:\r\n" + 
	    		"Monkey, Health = 50.0, Total Damage = 0.0\r\n" + 
	    		"Wizard, Health = 60.0, Total Damage = 0.0\r\n\r\n";
	    player.displayArmy();
	    assertEquals(expectedOutput, outContent.toString());
	}
	
	@Test
	void testDisplayEmptyArmy() throws Exception{
		Player player = new Player("Player");
		List<String> order1 = new LinkedList<String>();
		player.createArmy(order1, 2);
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
	    String expectedOutput  = "The army has no survivors\r\n";
	    player.displayArmy();
	    assertEquals(expectedOutput, outContent.toString());
	}
	
	@Test
	void testDelete() throws Exception {
		Player player = new Player("Player");
		List<Troop> army = new LinkedList<Troop>();
		Troop troop1 = new TroopFactory().buildTroop("Monkey");
		Troop troop2 = new TroopFactory().buildTroop("Balloon");
		army.add(troop1); army.add(troop2);
		player.setTroopArmy(army);
		player.delete(troop1);
		assertEquals(1, player.getTroopArmy().size());
		player.delete(troop2);
		assertEquals(0, player.getTroopArmy().size());
		
	}
	
	@Test
	void testOutstandingTroop() throws Exception {
		Player player = new Player("Player");
		List<Troop> army = new LinkedList<Troop>();
		Troop troop1 = new TroopFactory().buildTroop("Monkey");
		troop1.setTotalDamage(3);
		Troop troop2 = new TroopFactory().buildTroop("Balloon");
		troop2.setTotalDamage(1);
		army.add(troop1); army.add(troop2);
		player.setTroopArmy(army);
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput  = "Monkey, Health = 50.0, Total Damage = 3.0\r\n";
	    player.getOutstandingTroop();
		assertEquals(expectedOutput, outContent.toString());
	}
	
	@Test
	void testNoOutstandingTroop() throws Exception {
		Player player = new Player("Player");
		List<Troop> army = new LinkedList<Troop>();
		player.setTroopArmy(army);
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput  = "There is no Outstanding Troop\r\n";
	    player.getOutstandingTroop();
		assertEquals(expectedOutput, outContent.toString());
	}
	
	@Test
	void testGetNextTroop() throws Exception {
		Player player = new Player("Player");
		List<Troop> army = new LinkedList<Troop>();
		Troop troop1 = new TroopFactory().buildTroop("Monkey");
		troop1.setTotalDamage(3);
		Troop troop2 = new TroopFactory().buildTroop("Balloon");
		troop2.setTotalDamage(1);
		army.add(troop1); army.add(troop2);
		player.setTroopArmy(army);
		player.setCurrentIndex(1);
		assertEquals("Balloon", player.getNextTroop().getTroopName());
	}
	
	@Test
	void testGetNextTroopAfterDeletion() throws Exception {
		Player player = new Player("Player");
		List<Troop> army = new LinkedList<Troop>();
		Troop troop1 = new TroopFactory().buildTroop("Monkey");
		troop1.setTotalDamage(3);
		Troop troop2 = new TroopFactory().buildTroop("Balloon");
		troop2.setTotalDamage(1);
		army.add(troop1); army.add(troop2);
		player.setTroopArmy(army);
		player.setCurrentIndex(1);
		player.delete(troop2);
		assertEquals("Monkey", player.getNextTroop().getTroopName());
	}
	
	@Test
	void testGetNextTroopAfterDeletionAll() throws Exception {
		Player player = new Player("Player");
		List<Troop> army = new LinkedList<Troop>();
		Troop troop1 = new TroopFactory().buildTroop("Monkey");
		troop1.setTotalDamage(3);
		Troop troop2 = new TroopFactory().buildTroop("Balloon");
		troop2.setTotalDamage(1);
		army.add(troop1); army.add(troop2);
		player.setTroopArmy(army);
		player.setCurrentIndex(1);
		player.delete(troop2);
		player.delete(troop1);
		player.setCurrentIndex(-1);
		Assertions.assertThrows(NullPointerException.class, () -> player.getNextTroop().getTroopName());
	}
	
	@Test
	void testGetNextTroopWithInvalidIndex() throws Exception {
		Player player = new Player("Player");
		List<Troop> army = new LinkedList<Troop>();
		Troop troop1 = new TroopFactory().buildTroop("Monkey");
		troop1.setTotalDamage(3);
		army.add(troop1);
		player.setTroopArmy(army);
		player.setCurrentIndex(-1);
		Assertions.assertThrows(NullPointerException.class, () -> player.getNextTroop().getTroopName());

	}
}
