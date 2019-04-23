package battleGameTest;
import org.junit.Assert;
import org.junit.Test;
import battleGame.*;

public class MonkeyTest {

	@Test
	public void testConstructor() {
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
	public void testMonkeyAttackMonkey() {
		Troop monkey1 = new Monkey();
		Troop monkey2 = new Monkey();
		
		monkey1.attack(monkey2);
		double expectedHealth = 44.0;
		double expectedTotalDamage = 6.0;
		
		Assert.assertEquals(expectedHealth,monkey2.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, monkey1.getTotalDamage(), 0);
	}
	
	@Test
	public void testAttackMonkeyWithLowHealth() {
		Troop monkey1 = new Monkey();
		Troop monkey2 = new Monkey();
		monkey2.setHealth(2.0);
		monkey1.attack(monkey2);
		double expectedHealth = 0.0;
		double expectedTotalDamage = 2.0;
		
		Assert.assertEquals(expectedHealth,monkey2.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, monkey1.getTotalDamage(), 0);
	}
	
	
	@Test
	public void testMonkeyAttackFlyingMonkey() {
		Troop monkey = new Monkey();
		Troop flyingMonkey = new FlyingMonkey();
		
		monkey.attack(flyingMonkey);
		double expectedHealth = 47.0;
		double expectedTotalDamage = 3.0;
		
		Assert.assertEquals(expectedHealth,flyingMonkey.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, monkey.getTotalDamage(), 0);
	}
	
	@Test
	public void testAttackFlyingMonkeyWithLowHealth() {
		Troop monkey = new Monkey();
		Troop flyingMonkey = new FlyingMonkey();
		flyingMonkey.setHealth(3.0);
		monkey.attack(flyingMonkey);
		double expectedHealth = 0.0;
		double expectedTotalDamage = 3.0;
		
		Assert.assertEquals(expectedHealth,flyingMonkey.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, monkey.getTotalDamage(), 0);
	}
	
	@Test
	public void testMonkeyAttackWizard() {
		Troop monkey = new Monkey();
		Troop wizard = new Wizard();
		
		monkey.attack(wizard);
		double expectedHealth = 54.0;
		double expectedTotalDamage = 6.0;
		
		Assert.assertEquals(expectedHealth,wizard.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, monkey.getTotalDamage(), 0);
	}
	
	@Test
	public void testAttackWizardWithLowHealth() {
		Troop monkey = new Monkey();
		Troop wizard = new Wizard();
		wizard.setHealth(2.0);
		monkey.attack(wizard);
		double expectedHealth = 0.0;
		double expectedTotalDamage = 2.0;
		
		Assert.assertEquals(expectedHealth,wizard.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, monkey.getTotalDamage(), 0);
	}
	
	@Test
	public void testMonkeyAttackBalloon() {
		Troop monkey = new Monkey();
		Troop balloon = new Balloon();
		
		monkey.attack(balloon);
		double expectedHealth = 52.0;
		double expectedTotalDamage = 3.0;
		
		Assert.assertEquals(expectedHealth,balloon.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, monkey.getTotalDamage(), 0);
	}
	
	@Test
	public void testAttackBalloonWithLowHealth() {
		Troop monkey = new Monkey();
		Troop balloon = new Balloon();
		balloon.setHealth(1.0);
		monkey.attack(balloon);
		double expectedHealth = 0.0;
		double expectedTotalDamage = 1.0;
		
		Assert.assertEquals(expectedHealth,balloon.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, monkey.getTotalDamage(), 0);
	}
	
}
