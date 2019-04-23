package battleGame;

public class Troop {
	  protected String troopName;
	  private double damage;
	  private Type type;
	  private Type preferredTarget;
	  private double health;
	  private double totalDamage;
	  
	  public Troop() {
		  this.setTotalDamage(0.0);
	  }
	  
	  public void setTroopName(String troopName) {
		  this.troopName = troopName;
	  }
	  
	  public void setDamage(double damage) {
		  this.damage = damage;
	  }
	  
	  public void setType(Type type) {
		  this.type = type;
	  }
	  
	  public void setPreferredTarget(Type preferredTarget) {
		  this.preferredTarget = preferredTarget;
	  }
	  
	  public void setHealth(double health) {
		  this.health = health;
	  }
	  
	  public void setTotalDamage(double totalDamage) {
		  this.totalDamage = totalDamage;
	  }
	  
	  public String getTroopName() {
		  return this.troopName;
	  }
	  
	  public double getDamage() {
		  return this.damage;
	  }
	  
	  public Type getType() {
		  return this.type;
	  }
	  
	  public Type getPreferredTarget() {
		  return this.preferredTarget;
	  }
	  
	  public double getHealth() {
		  return this.health;
	  }
	  
	  public double getTotalDamage() {
		  return this.totalDamage;
	  }
	  
	  public void attack(Troop enemyTroop) {
		  double enemyHealth = enemyTroop.getHealth();
		  double damageDealt;
		  double attackDamage;
		  attackDamage = this.preferredTarget == Type.ALL || enemyTroop.getType().equals(this.preferredTarget) ? 
				  this.damage : (this.damage / 2);
		  damageDealt = enemyHealth < attackDamage ? enemyHealth : attackDamage;
		  this.totalDamage += damageDealt;
		  enemyTroop.setHealth(enemyHealth - damageDealt);
	  }
	  
	  public int getContinuousOnes() {
		  
		  int decimal =  (int) this.totalDamage;
          int result = 0; 
          while (decimal != 0) { 
            decimal = (decimal & (decimal << 1)); 
            result++; 
          }
          return result; 
	  }
	  
	  public void displayProperties() {
		  System.out.println(" Troop Name: " + this.getTroopName() + ", Damage: " + this.damage + ", Type: " + this.type +
				  			", Preferred Type: " + this.preferredTarget + ", Health: " + this.health +
				  			", Total Damage Dealt: " + this.totalDamage);
	  }

	  public void displayHealthDamage() {
		  System.out.println(this.getTroopName() + ", Health = " + this.health + ", Total Damage = " + this.totalDamage);
	  }
}
