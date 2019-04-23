package battleGame;

public class Wizard extends Troop {

	public Wizard() {
		this.setTroopName("Wizard");
		this.setDamage(6.0);
		this.setType(Type.GROUND);
		this.setPreferredTarget(Type.ALL);
		this.setHealth(60.0);
	}

}
