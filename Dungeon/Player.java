public class Player {
    dungeon d = new dungeon();
	private int hp;
	private int wId = 2; //determines starting weapon Id: (2) is sword
	private String name;
	private String qName;
	private int damage;
	private int speed;
	private int score;
	private int mana;
	private int hPotions;
	private int mPotions;
	
    public Player() {
        hp = 100;
		mana = 100;
		hPotions = 0;
		mPotions = 0;
    }
	
	public void setMana(int sm) {
		mana = sm;
	}
	public int getMana() {
		return mana;
	}
	
	public void setHPotions(int shp) {
		hPotions += shp;
	}
	public int getHPotions() {
		return hPotions;
	}
	
	public void setMPotions(int smp) {
		mPotions = smp;
	}
	public int getMPotions() {
		return mPotions;
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
		if (hp > 100) {
			hp = 100;
		}
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
