package battleGame;

public class Balloon extends Troop {

	public Balloon() {
		this.setTroopName("Balloon");
		this.setDamage(8.0);
		this.setType(Type.AIR);
		this.setPreferredTarget(Type.GROUND);
		this.setHealth(55.0);
	}

}
