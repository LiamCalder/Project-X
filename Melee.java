public class Melee extends Weapon {
    public Melee(String name, double damage, int speed) {
        super(name, damage, speed);
    }

    public int getDamage() {
        return (int) Math.round(damage * qualityD + multiplier); //round damage to an integer
    }
	
	public int getSpeed() {
		return (int) Math.round(speed * qualityS); //round speed to integer
	}
}