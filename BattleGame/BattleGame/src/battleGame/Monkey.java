package battleGame;

public class Monkey extends Troop {
	
	public Monkey() {
		
		this.setTroopName("Monkey");
		this.setDamage(6.0);
		this.setType(Type.GROUND);
		this.setPreferredTarget(Type.GROUND);
		this.setHealth(50.0);
		
	}
}
