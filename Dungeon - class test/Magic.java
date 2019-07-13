public class Magic extends Weapon {
	public Magic(String name, double damage) {
		super(name, damage);
	}
	
	public int getDamage() {
        return (int) Math.round(damage * quality); //round damage to an integer
    }
}