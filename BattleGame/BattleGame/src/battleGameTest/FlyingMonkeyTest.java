package battleGameTest;
import battleGame.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class FlyingMonkeyTest {

	@Test
	public void testConstructor() {
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
	public void testFlyingMonkeyAttackFlyingMonkey() {
		Troop fMonkey1 = new FlyingMonkey();
		Troop fMonkey2 = new FlyingMonkey();
		
		fMonkey1.attack(fMonkey2);
		double expectedHealth = 44.0;
		double expectedTotalDamage = 6.0;
		
		Assert.assertEquals(expectedHealth,fMonkey2.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, fMonkey1.getTotalDamage(), 0);
	}
	
	@Test
	public void testAttackFlyingMonkeyWithLowHealth() {
		Troop fMonkey1 = new FlyingMonkey();
		Troop fMonkey2 = new FlyingMonkey();
		fMonkey2.setHealth(5.0);
		fMonkey1.attack(fMonkey2);
		double expectedHealth = 0.0;
		double expectedTotalDamage = 5.0;
		
		Assert.assertEquals(expectedHealth,fMonkey2.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, fMonkey1.getTotalDamage(), 0);
	}
	
	@Test
	public void testFlyingMonkeyAttackMonkey() {
		Troop monkey = new Monkey();
		Troop flyingMonkey = new FlyingMonkey();
		
		flyingMonkey.attack(monkey);
		double expectedHealth = 47.0;
		double expectedTotalDamage = 3.0;
		
		Assert.assertEquals(expectedHealth,monkey.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, flyingMonkey.getTotalDamage(), 0);
	}
	
	@Test
	public void testAttackMonkeyWithLowHealth() {
		Troop monkey = new Monkey();
		Troop flyingMonkey = new FlyingMonkey();
		monkey.setHealth(2.0);
		flyingMonkey.attack(monkey);
		double expectedHealth = 0.0;
		double expectedTotalDamage = 2.0;
		
		Assert.assertEquals(expectedHealth,monkey.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, flyingMonkey.getTotalDamage(), 0);
	}
	
	@Test
	public void testFlyingMonkeyAttackWizard() {
		Troop flyingMonkey = new FlyingMonkey();
		Troop wizard = new Wizard();
		
		flyingMonkey.attack(wizard);
		double expectedHealth = 57.0;
		double expectedTotalDamage = 3.0;
		
		Assert.assertEquals(expectedHealth,wizard.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, flyingMonkey.getTotalDamage(), 0);
	}
	
	@Test
	public void testAttackWizardWithLowHealth() {
		Troop flyingMonkey = new FlyingMonkey();
		Troop wizard = new Wizard();
		wizard.setHealth(2.0);
		flyingMonkey.attack(wizard);
		double expectedHealth = 0.0;
		double expectedTotalDamage = 2.0;
		
		Assert.assertEquals(expectedHealth,wizard.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, flyingMonkey.getTotalDamage(), 0);
	}
	
	@Test
	public void testFlyingMonkeyAttackBalloon() {
		Troop flyingMonkey = new FlyingMonkey();
		Troop balloon = new Balloon();
		
	    flyingMonkey.attack(balloon);
		double expectedHealth = 49.0;
		double expectedTotalDamage = 6.0;
		
		Assert.assertEquals(expectedHealth,balloon.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, flyingMonkey.getTotalDamage(), 0);
	}
	
	@Test
	public void testAttackBalloonWithLowHealth() {
		Troop flyingMonkey = new FlyingMonkey();
		Troop balloon = new Balloon();
		balloon.setHealth(2.0);
	    flyingMonkey.attack(balloon);
		double expectedHealth = 0.0;
		double expectedTotalDamage = 2.0;
		
		Assert.assertEquals(expectedHealth,balloon.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, flyingMonkey.getTotalDamage(), 0);
	}

}
