package battleGameTest;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import battleGame.Balloon;
import battleGame.FlyingMonkey;
import battleGame.Monkey;
import battleGame.Troop;
import battleGame.Type;
import battleGame.Wizard;

public class TroopTest {
	
	@Test
	public void testAttack() {
		Troop troop1 = new Monkey();
		Troop troop2 = new Monkey();
		troop2.setHealth(50.0);
		troop1.setDamage(40.0);
		troop1.attack(troop2);
		double expectedHealth = 10.0;
		double expectedTotalDamage = 40.0;
		
		Assert.assertEquals(expectedHealth,troop2.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, troop1.getTotalDamage(), 0);
	}
	
	@Test
	public void testContinuousOnes() {
		int expectedAnswer1 = 0;
		int expectedAnswer2 = 1;
		int expectedAnswer3 = 2;
		Troop monkey = new Monkey();
		monkey.setTotalDamage(0);
		assertEquals(expectedAnswer1, monkey.getContinuousOnes());
		monkey.setTotalDamage(64);
		assertEquals(expectedAnswer2, monkey.getContinuousOnes());
		monkey.setTotalDamage(3);
		assertEquals(expectedAnswer3, monkey.getContinuousOnes());
		
	}
	
	@Test
	public void testDisplayProperties() {
		 ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	     System.setOut(new PrintStream(outContent));
	     Troop winner = new Monkey();
	     String expectedOutput  = " Troop Name: Monkey, Damage: 6.0, Type: GROUND, Preferred Type: GROUND,"
	     		+ " Health: 50.0, Total Damage Dealt: 0.0\r\n";
	     winner.displayProperties();
	     assertEquals(expectedOutput, outContent.toString());
	}
	
	@Test
	public void testDisplayDamageHealth() {
		 ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	     System.setOut(new PrintStream(outContent));
	     Troop winner = new Monkey();
	     String expectedOutput  = "Monkey, Health = 50.0, Total Damage = 0.0\r\n";
	     winner.displayHealthDamage();
	     assertEquals(expectedOutput, outContent.toString());
	     System.out.print(outContent.toString());
	}
	
	@Test
	public void testMonkey() {
		Troop monkeyTest = new Monkey();
		String expectedName = "Monkey";
		double expectedDamage = 6.0;
		Type expectedType = Type.GROUND;
		Type expectedPreferredType = Type.GROUND;
		double expectedHealth = 50.0;
		double expectedTotalDamage = 0.0;
		
		Assert.assertEquals(expectedName, monkeyTest.getTroopName());
		Assert.assertEquals(expectedDamage, monkeyTest.getDamage(), 0.0);
		Assert.assertEquals(expectedType, monkeyTest.getType());
		Assert.assertEquals(expectedPreferredType, monkeyTest.getPreferredTarget());
		Assert.assertEquals(expectedHealth, monkeyTest.getHealth(), 0.0);
		Assert.assertEquals(expectedTotalDamage, monkeyTest.getTotalDamage(), 0);
	}
	
	@Test
	public void testFlyingMonkey() {
		Troop flyingMonkey = new FlyingMonkey();
		String expectedName = "Flying Monkey";
		double expectedDamage = 6.0;
		Type expectedType = Type.AIR;
		Type expectedPreferredType = Type.AIR;
		double expectedHealth = 50.0;
		double expectedTotalDamage = 0.0;
		
		Assert.assertEquals(expectedName, flyingMonkey.getTroopName());
		Assert.assertEquals(expectedDamage, flyingMonkey.getDamage(), 0.0);
		Assert.assertEquals(expectedType, flyingMonkey.getType());
		Assert.assertEquals(expectedPreferredType, flyingMonkey.getPreferredTarget());
		Assert.assertEquals(expectedHealth, flyingMonkey.getHealth(), 0.0);
		Assert.assertEquals(expectedTotalDamage, flyingMonkey.getTotalDamage(), 0);
	}
	
	
	@Test
	public void testWizard() {
		Troop wizard = new Wizard();
		String expectedName = "Wizard";
		double expectedDamage = 6.0;
		Type expectedType = Type.GROUND;
		Type expectedPreferredType = Type.ALL;
		double expectedHealth = 60.0;
		double expectedTotalDamage = 0.0;
		
		Assert.assertEquals(expectedName, wizard.getTroopName());
		Assert.assertEquals(expectedDamage, wizard.getDamage(), 0.0);
		Assert.assertEquals(expectedType, wizard.getType());
		Assert.assertEquals(expectedPreferredType, wizard.getPreferredTarget());
		Assert.assertEquals(expectedHealth, wizard.getHealth(), 0.0);
		Assert.assertEquals(expectedTotalDamage, wizard.getTotalDamage(), 0);
	}
	
	@Test
	public void testBalloon() {
		Troop balloon = new Balloon();
		String expectedName = "Balloon";
		double expectedDamage = 8.0;
		Type expectedType = Type.AIR;
		Type expectedPreferredType = Type.GROUND;
		double expectedHealth = 55.0;
		double expectedTotalDamage = 0.0;
		
		Assert.assertEquals(expectedName, balloon.getTroopName());
		Assert.assertEquals(expectedDamage, balloon.getDamage(), 0.0);
		Assert.assertEquals(expectedType, balloon.getType());
		Assert.assertEquals(expectedPreferredType, balloon.getPreferredTarget());
		Assert.assertEquals(expectedHealth, balloon.getHealth(), 0.0);
		Assert.assertEquals(expectedTotalDamage, balloon.getTotalDamage(), 0);
	}
}
