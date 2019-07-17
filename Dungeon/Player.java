public class Player {
    
	private int hp;
	public static int wId = 2; //determines starting weapon Id: (2) is sword
	public static String name;
	public static String qName;
	public static int damage;
	public static int speed;
	public static int score;
	
	dungeon d = new dungeon();
	
    public Player() {
        hp = 100;
    }
	
	public void addScore(int ssc) {
		score += ssc;
	}
	public int getScore() {
		return score;
	}
	
	public void setName(String sn) {
		name = sn;
	}
	public String getName() {
		return name;
	}
	
	public void setQName(String sq) {
		qName = sq;
	}
	public String getQName() {
		return qName;
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
	
	public void setHealth(int sh) {
		hp += sh;
	}
	public int getHealth() {
		return hp;
	}
	
    public void hit(Weapon w) {
        hp -= w.getDamage();

        // Damage output
        System.out.println("  The " + w.getName() + " hits you for " + w.getDamage() + " damage.");
        if (hp <= 0) {
			d.Delay(null);
			System.out.println("  Final Score: "+score);
			d.Delay(null);
            System.out.println("  You Have Perished in the Dungeon...");
			d.Delay(null);
			System.exit(1);
        } else {
            System.out.println("  You have " + hp + " hp.");
        }
    }
}
