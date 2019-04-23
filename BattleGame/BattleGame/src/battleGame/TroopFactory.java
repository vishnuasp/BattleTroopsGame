package battleGame;

public class TroopFactory {

	public Troop buildTroop(String troopCategory) throws Exception{
		Troop troop = null;
		
			if (troopCategory.replaceAll(" ","").toLowerCase().equals("monkey")) {
				troop = new Monkey();
			} else if (troopCategory.replaceAll(" ","").toLowerCase().equals("flyingmonkey")) {
				troop = new FlyingMonkey();
			} else if (troopCategory.replaceAll(" ","").toLowerCase().equals("wizard")) {
				troop = new Wizard();
			} else if (troopCategory.replaceAll(" ","").toLowerCase().equals("balloon")) {
				troop = new Balloon();
			} else {
				throw new Exception("Invalid troop type detected");
			}

		return troop;
	}

}
