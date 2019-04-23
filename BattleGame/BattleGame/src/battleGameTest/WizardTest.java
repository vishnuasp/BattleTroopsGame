package battleGameTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import battleGame.Balloon;
import battleGame.FlyingMonkey;
import battleGame.Monkey;
import battleGame.Troop;
import battleGame.Type;
import battleGame.Wizard;

public class WizardTest {

	@Test
	public void testConstructor() {
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
	public void testWizardAttackMonkey() {
		Troop wizard = new Wizard();
		Troop monkey = new Monkey();
		
		wizard.attack(monkey);
		double expectedHealth = 44.0;
		double expectedTotalDamage = 6.0;
		
		Assert.assertEquals(expectedHealth,monkey.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, wizard.getTotalDamage(), 0);
	}
	
	@Test
	public void testAttackMonkeyWithLowHealth() {
		Troop wizard = new Wizard();
		Troop monkey = new Monkey();
		monkey.setHealth(2.0);
		wizard.attack(monkey);
		double expectedHealth = 0.0;
		double expectedTotalDamage = 2.0;
		
		Assert.assertEquals(expectedHealth,monkey.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, wizard.getTotalDamage(), 0);
	}
	
	
	@Test
	public void testWizardAttackFlyingMonkey() {
		Troop wizard = new Wizard();
		Troop flyingMonkey = new FlyingMonkey();
		
		wizard.attack(flyingMonkey);
		double expectedHealth = 44.0;
		double expectedTotalDamage = 6.0;
		
		Assert.assertEquals(expectedHealth,flyingMonkey.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, wizard.getTotalDamage(), 0);
	}
	
	@Test
	public void testAttackFlyingMonkeyWithLowHealth() {
		Troop wizard = new Wizard();
		Troop flyingMonkey = new FlyingMonkey();
		flyingMonkey.setHealth(3.0);
		wizard.attack(flyingMonkey);
		double expectedHealth = 0.0;
		double expectedTotalDamage = 3.0;
		
		Assert.assertEquals(expectedHealth,flyingMonkey.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, wizard.getTotalDamage(), 0);
	}
	
	@Test
	public void testWizardAttackWizard() {
		Troop wizard1 = new Wizard();
		Troop wizard2 = new Wizard();
		
		wizard1.attack(wizard2);
		double expectedHealth = 54.0;
		double expectedTotalDamage = 6.0;
		
		Assert.assertEquals(expectedHealth,wizard2.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, wizard1.getTotalDamage(), 0);
	}
	
	@Test
	public void testAttackWizardWithLowHealth() {
		Troop wizard1 = new Wizard();
		Troop wizard2 = new Wizard();
		wizard2.setHealth(2.0);
		wizard1.attack(wizard2);
		double expectedHealth = 0.0;
		double expectedTotalDamage = 2.0;
		
		Assert.assertEquals(expectedHealth,wizard2.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, wizard1.getTotalDamage(), 0);
	}
	
	@Test
	public void testWizardAttackBalloon() {
		Troop wizard = new Wizard();
		Troop balloon = new Balloon();
		
		wizard.attack(balloon);
		double expectedHealth = 49.0;
		double expectedTotalDamage = 6.0;
		
		Assert.assertEquals(expectedHealth,balloon.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, wizard.getTotalDamage(), 0);
	}
	
	@Test
	public void testAttackBalloonWithLowHealth() {
		Troop wizard = new Wizard();
		Troop balloon = new Balloon();
		balloon.setHealth(1.0);
		wizard.attack(balloon);
		double expectedHealth = 0.0;
		double expectedTotalDamage = 1.0;
		
		Assert.assertEquals(expectedHealth,balloon.getHealth(), 0);
		Assert.assertEquals(expectedTotalDamage, wizard.getTotalDamage(), 0);
	}
	

}
