package battleGameTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import battleGame.Balloon;
import battleGame.FlyingMonkey;
import battleGame.Monkey;
import battleGame.Troop;
import battleGame.Type;
import battleGame.Wizard;

public class BalloonTest {

	@Test
	public void testConstructor() {
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
	
	@Test
	public void testBalloonAttackMonkey() {
		Troop balloon = new Balloon();
		Troop monkey = new Monkey();
		
		balloon.attack(monkey);
		double expectedHealth = 42.0;
		double expectedTotalDamage = 8.0;
		
		Assert.assertEquals(expectedHealth,monkey.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, balloon.getTotalDamage(), 0);
	}
	
	@Test
	public void testAttackMonkeyWithLowHealth() {
		Troop balloon = new Balloon();
		Troop monkey = new Monkey();
		monkey.setHealth(2.0);
		balloon.attack(monkey);
		double expectedHealth = 0.0;
		double expectedTotalDamage = 2.0;
		
		Assert.assertEquals(expectedHealth,monkey.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, balloon.getTotalDamage(), 0);
	}
	
	
	@Test
	public void testBalloonAttackFlyingMonkey() {
		Troop balloon = new Balloon();
		Troop flyingMonkey = new FlyingMonkey();
		
		balloon.attack(flyingMonkey);
		double expectedHealth = 46.0;
		double expectedTotalDamage = 4.0;
		
		Assert.assertEquals(expectedHealth,flyingMonkey.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, balloon.getTotalDamage(), 0);
	}
	
	@Test
	public void testAttackFlyingMonkeyWithLowHealth() {
		Troop balloon = new Balloon();
		Troop flyingMonkey = new FlyingMonkey();
		flyingMonkey.setHealth(3.0);
		balloon.attack(flyingMonkey);
		double expectedHealth = 0.0;
		double expectedTotalDamage = 3.0;
		
		Assert.assertEquals(expectedHealth,flyingMonkey.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, balloon.getTotalDamage(), 0);
	}
	
	@Test
	public void testBalloonAttackWizard() {
		Troop balloon = new Balloon();
		Troop wizard = new Wizard();
		
		balloon.attack(wizard);
		double expectedHealth = 52.0;
		double expectedTotalDamage = 8.0;
		
		Assert.assertEquals(expectedHealth,wizard.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, balloon.getTotalDamage(), 0);
	}
	
	@Test
	public void testAttackWizardWithLowHealth() {
		Troop balloon = new Balloon();
		Troop wizard = new Wizard();
		wizard.setHealth(2.0);
		balloon.attack(wizard);
		double expectedHealth = 0.0;
		double expectedTotalDamage = 2.0;
		
		Assert.assertEquals(expectedHealth,wizard.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, balloon.getTotalDamage(), 0);
	}
	
	@Test
	public void testBalloonAttackBalloon() {
		Troop balloon1 = new Balloon();
		Troop balloon2 = new Balloon();
		
		balloon1.attack(balloon2);
		double expectedHealth = 51.0;
		double expectedTotalDamage = 4.0;
		
		Assert.assertEquals(expectedHealth,balloon2.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, balloon1.getTotalDamage(), 0);
	}
	
	@Test
	public void testAttackBalloonWithLowHealth() {
		Troop balloon1 = new Balloon();
		Troop balloon2 = new Balloon();
		balloon2.setHealth(1.0);
		balloon1.attack(balloon2);
		double expectedHealth = 0.0;
		double expectedTotalDamage = 1.0;
		
		Assert.assertEquals(expectedHealth,balloon2.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, balloon1.getTotalDamage(), 0);
	}

}
