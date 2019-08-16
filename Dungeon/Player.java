public class Player {
    Dungeon d = new Dungeon();
	int hp;
	static private int mWId = 2; //stores melee weapon Id: (2) is sword
	static public int rWId = 9; //stores ranged weapon Id
	static private String nameM;
	static private String qNameM;
	static private int damageM;
	static private int speedM;
	static private String nameR;
	static private String qNameR;
	static private int damageR;
	static private int ammo;
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
	
	public void setWeaponM(int sw) {
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
	
	public void setWeaponR(int swr) {
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
	
	public void setAmmo(int ra) {
		ammo += ra;
	}
	public int getAmmo() {
		return ammo;
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
