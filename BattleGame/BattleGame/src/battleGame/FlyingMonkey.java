package battleGame;

public class FlyingMonkey extends Monkey {

	public FlyingMonkey() {
		this.setTroopName("Flying Monkey");
		this.setType(Type.AIR);
		this.setPreferredTarget(Type.AIR);
	}

}
