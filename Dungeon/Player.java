public class Player {
    Dungeon d = new Dungeon();
	
	//storing weapons - Melee
	static private int mWId = 2; //store melee weapon Id: (2) is sword
	static private String nameM;
	static private String qNameM;
	static private int damageM;
	static private int speedM;
	// - Ranged
	static private int rWId = 11; //store ranged weapon Id
	static private String nameR;
	static private String qNameR;
	static private int damageR;
	static private int ammo;
	static private int maxAmmo;
	
	//store player stats
	private int hp;
	private int score;
	private int cash;
	private int mana;
	private int hPotions;
	private int mPotions;
	
	//store learned spells
	private boolean flame = false;
	private boolean lightning = false;
	private boolean frost = false;
	private boolean sapping = false;
	private boolean aura = false;
	private boolean speed = false;
	private boolean shift = false;
	private boolean fireWall = false;
	
    public Player() {
        hp = 100;
		mana = 100;
		hPotions = 0;
		mPotions = 0;
		cash = 0;
    }
	
	public boolean getSpell(String spell) {
		switch(spell) {
			case "Fireball": return flame;
			case "Lightning Bolt": return lightning;
			case "Ice Beam": return frost;
			case "Drain Speed": return sapping;
			case "Defensive Aura": return aura;
			case "Swiftness": return speed;
			case "Dimensional Shift": return shift;
			case "Wall of Fire": return fireWall;
			default: return false;
		}
	}
	public void giveSpell(String spell) {
		switch(spell) {
			case "Fireball": flame = true;
			case "Lightning Bolt": lightning = true;
			case "Ice Beam": frost = true;
			case "Drain Speed": sapping = true;
			case "Defensive Aura": aura = true;
			case "Swiftness": speed = true;
			case "Dimensional Shift": shift = true;
			case "Wall of Fire": fireWall = true;
		}
	}
	
	public void setHealth(int sh) {
		hp += sh;
		if (hp > 100) {
			hp = 100;
		}
	}
	public void takeDamage(int d) {
		hp -= d;
	}
	public int getHealth() {
		return hp;
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
	
	public void setNameM(String sn) {
		nameM = sn;
	}
	public String getNameM() {
		return nameM;
	}
	
	public void setQNameM(String sq) {
		qNameM = sq;
	}
	public String getQNameM() {
		return qNameM;
	}
	
	public void setWeaponM(int sw, Weapon w) {
		mWId = sw;
		
	}
	public int getWeaponM() {
		return mWId;
	}
	
	public void setDamageM(int st) {
		damageM = st;
	}
	public int getDamageM() {
		return damageM;
	}
	
	public void setSpeedM(int ss) {
		speedM = ss;
	}
	public int getSpeedM() {
		return speedM;
	}
	
	public void setNameR(String snr) {
		nameR = snr;
	}
	public String getNameR() {
		return nameR;
	}
	
	public void setQNameR(String sqr) {
		qNameR = sqr;
	}
	public String getQNameR() {
		return qNameR;
	}
	
	public void setWeaponR(int swr, Weapon w) {
		rWId = swr;
	}
	public int getWeaponR() {
		return rWId;
	}
	
	public void setDamageR(int str) {
		damageR = str;
	}
	public int getDamageR() {
		return damageR;
	}
	
	public void useAmmo(int ar) {
		ammo += ar;
	}
	public void setMaxAmmo(int sma) {
		maxAmmo = sma;
	}
	public int getMaxAmmo() {
		return maxAmmo;
	}
	public void setNewAmmo(int sna) {
		ammo = sna;
	}
	public int getAmmoDiff() {
		return maxAmmo - ammo;
	}
	public int getAmmo() {
		return ammo;
	}
}
