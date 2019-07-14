public class Player {
    
	private int hp;
	public static int wId = 1;
	public static String name;
	public static int damage;
	public static int speed;
	dungeon d = new dungeon();
	
    public Player() {
        hp = 100;
    }
	
	public void setWeapon(int sw) {
		wId = sw;
	}
	
	public int getWeapon() {
		return wId;
	}
	
	public void setDamage(int st) {
		damage = st;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void setSpeed(int ss) {
		speed = ss;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getHealth() {
		return hp;
	}
	
    public void hit(Weapon w) {
        hp -= w.getDamage();

        // Damage output
        System.out.println("  You were hit by the " + w.getName() + " for " + w.getDamage() + " damage.");
        if (hp <= 0) {
			d.Delay(null);
            System.out.println("  You Have Perished in the Dungeon...");
			d.Delay(null);
			System.exit(1);
        } else {
            System.out.println("  You have " + hp + " hp.");
        }
    }
}
