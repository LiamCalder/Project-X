public class Player {
    Dungeon d = new Dungeon();
	int hp;
	static private int mWId = 2; //stores melee weapon Id: (2) is sword
	static private int rWId = -1; //stores ranged weapon Id
	static private String name;
	static private String qName;
	static private int damage;
	static private int speed;
	int score;
	private int cash;
	private int mana;
	private int hPotions;
	private int mPotions;
	
    public Player() {
        hp = 100;
		mana = 100;
		hPotions = 0;
		mPotions = 0;
		cash = 0;
    }
	
	public void setMana(int sm) {
		mana = sm;
		if (mana > 100) {
			mana = 100;
		}
	}
	public int getMana() {
		return mana;
	}
	
	public void setCash(int sc) {
		cash += sc;
	}
	public int getCash() {
		return cash;
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
		mWId = sw;
	}
	public int getWeapon() {
		return mWId;
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
}
