package battleGameTest;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import battleGame.Troop;
import battleGame.TroopFactory;

public class TroopFactoryTest {

	@Test
	void testMonkey() throws Exception {
		TroopFactory troopFactory = new TroopFactory();
		String expectedName = "Monkey";
		
		Troop troop = troopFactory.buildTroop("Monkey");
		Assert.assertEquals(expectedName, troop.getTroopName());
		troop = troopFactory.buildTroop("monkey");
		Assert.assertEquals(expectedName, troop.getTroopName());
		troop = troopFactory.buildTroop("MONKEY");
		Assert.assertEquals(expectedName, troop.getTroopName());
	}
	
	@Test
	void testFlyingMonkey() throws Exception {
		TroopFactory troopFactory = new TroopFactory();
		String expectedName = "Flying Monkey";
		
		Troop troop = troopFactory.buildTroop("FlyingMonkey");
		Assert.assertEquals(expectedName, troop.getTroopName());
		troop = troopFactory.buildTroop("flyingmonkey");
		Assert.assertEquals(expectedName, troop.getTroopName());
		troop = troopFactory.buildTroop("Flying MONKEY");
		Assert.assertEquals(expectedName, troop.getTroopName());
		troop = troopFactory.buildTroop("FLYINGMONKEY");
		Assert.assertEquals(expectedName, troop.getTroopName());
	}
	
	@Test
	void testWizard() throws Exception {
		TroopFactory troopFactory = new TroopFactory();
		String expectedName = "Wizard";
		
		Troop troop = troopFactory.buildTroop("wizard");
		Assert.assertEquals(expectedName, troop.getTroopName());
		troop = troopFactory.buildTroop("Wizard");
		Assert.assertEquals(expectedName, troop.getTroopName());
		troop = troopFactory.buildTroop("WIZARD");
		Assert.assertEquals(expectedName, troop.getTroopName());
	}
	
	@Test
	void testBalloon() throws Exception {
		TroopFactory troopFactory = new TroopFactory();
		String expectedName = "Balloon";
		
		Troop troop = troopFactory.buildTroop("balloon");
		Assert.assertEquals(expectedName, troop.getTroopName());
		troop = troopFactory.buildTroop("Balloon");
		Assert.assertEquals(expectedName, troop.getTroopName());
		troop = troopFactory.buildTroop("BALLOON");
		Assert.assertEquals(expectedName, troop.getTroopName());
	}

	@Test
	void testUnexpectedTroopType() throws Exception{
		TroopFactory troopFactory = new TroopFactory();
		Assertions.assertThrows(Exception.class, () -> troopFactory.buildTroop("Some type"));
	}

}
