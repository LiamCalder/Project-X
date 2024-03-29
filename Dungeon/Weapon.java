import java.util.*;
public abstract class Weapon {
    
    protected String name;
    protected double damage; //Passed onto Child Classes
	protected double special;
	
	protected double qualityD;
	protected double qualityS; //determined in Weapon Class
	protected String qualityN;
	protected int multiplier;
	
	protected Dungeon d = new Dungeon();
	protected Player pl = new Player();  
	protected Enemy en = new Enemy();
	
    public Weapon(String name, double damage, int special) {
        this.name = name;
        this.damage = damage;
		this.special = special;
    }
	
	public void SendQualityNameM() {
		pl.setQNameM(qualityN);
	}
	
	public void SendQualityNameR() {
		pl.setQNameR(qualityN);
	}
	
	public String getName() {
		return name;
	}
	
	public abstract String getType();
	
	public abstract int getSpecial();

    public abstract int getDamage();      //These are defined in Child Classes (abstract)
	
	public abstract int getBaseDamage();
	
	public abstract void PlHit(Weapon w, Enemy En, Player p);
	
	public abstract void EnHit(Weapon w, Enemy en, Player p);
	
	public void newWeapon() {
		if (this.name.equalsIgnoreCase("gtmichaels")) {
			QualityT1(1);
			return;
		}
		multiplier = d.level - 1;
		Random r = new Random();
		int tier = 5;
		while (tier > 3) {
			tier = r.nextInt(d.level)+1;
		}
		
		if (d.forceQuality > 0) {
			QualityT1(1);
			d.forceQuality--;
			return;
		}
		
		int qualityId;
		
		switch (tier) {
			case 1: qualityId = r.nextInt(19)+1;
					QualityT1(qualityId); break;
			case 2: qualityId = r.nextInt(14)+1;
					QualityT2(qualityId); break;
			case 3: qualityId = r.nextInt(15)+1;
					QualityT3(qualityId); break;
		}
	}
	
	private void QualityT1(int Id)  {
		//Only negative effects on stats (0 < quality < 1)
		d.weaponCostMult = (int) Math.round(d.level * 1);
		switch (Id) {
			case 1: qualityD = 1;   qualityS = 1;   qualityN = "Basic "; break;
			case 2: qualityD = 0.8; qualityS = 0.9; qualityN = "Flimsy "; break;
			case 3: qualityD = 0.5; qualityS = 0.8; qualityN = "Rusty "; break;
			case 4: qualityD = 0.9; qualityS = 1;   qualityN = "Vintage "; break;
			case 5: qualityD = 0.6; qualityS = 0.7; qualityN = "Moldy "; break;
			case 6: qualityD = 0.9; qualityS = 0.9; qualityN = "Old "; break;
			case 7: qualityD = 0.9; qualityS = 1;   qualityN = "Stinky "; break;
			case 8: qualityD = 0.7; qualityS = 0.8; qualityN = "Poorly Made "; break;
			case 9: qualityD = 0.8; qualityS = 0.8; qualityN = "Dirty "; break;
			case 10:qualityD = 0.7; qualityS = 1;   qualityN = "Tiny "; break;
			case 11:qualityD = 0.7; qualityS = 0.8; qualityN = "Unreliable "; break;
			case 12:qualityD = 0.6; qualityS = 0.8; qualityN = "Faulty "; break;
			case 13:qualityD = 0.5; qualityS = 0.8; qualityN = "Blunt "; break;
			case 14:qualityD = 0.8; qualityS = 0.7; qualityN = "Shoddy "; break;
			case 15:qualityD = 0.9; qualityS = 0.9; qualityN = "Child's "; break;
			case 16:qualityD = 0.6; qualityS = 0.7; qualityN = "Cheap "; break;
			case 17:qualityD = 1;   qualityS = 1;   qualityN = "Ordinary "; break;
			case 18:qualityD = 1;   qualityS = 0.5; qualityN = "Slow "; break;
			case 19:qualityD = 0.5; qualityS = 0.6; qualityN = "Broken "; break;
		}
    }
    
    private void QualityT2(int Id) {
        //Mixed effects on stats or small buff
		d.weaponCostMult = (int) Math.round(d.level * 2);
        switch (Id) {
            case 1: qualityD = 0.8; qualityS = 1.7; qualityN = "Light "; break;
            case 2: qualityD = 1.7; qualityS = 0.8; qualityN = "Heavy "; break;
            case 3: qualityD = 1.2; qualityS = 1;   qualityN = "Dense "; break;
            case 4: qualityD = 0.8; qualityS = 1.6; qualityN = "Nimble "; break;
            case 5: qualityD = 0.7; qualityS = 1.8; qualityN = "Quick "; break;
            case 6: qualityD = 1.4; qualityS = 1;   qualityN = "Battle-tested "; break;
            case 7: qualityD = 1.5; qualityS = 0.9; qualityN = "Bloodied "; break;
            case 8: qualityD = 1.2; qualityS = 0.9; qualityN = "Raging "; break;
            case 9: qualityD = 1.6; qualityS = 0.8; qualityN = "Sharp "; break;
            case 10:qualityD = 1;   qualityS = 1.3; qualityN = "Balanced "; break;
            case 11:qualityD = 1.4; qualityS = 0.9; qualityN = "Large "; break;
            case 12:qualityD = 0.7; qualityS = 1.5; qualityN = "Small "; break;
            case 13:qualityD = 1.3; qualityS = 1;   qualityN = "Modified "; break;
            case 14:qualityD = 0.8; qualityS = 1.5; qualityN = "Excited "; break;
        }
    }
    
     private void QualityT3(int Id) {
		 d.weaponCostMult = (int) Math.round(d.level * 3);
        //good effects of stats (1 < quality)
        switch (Id) {
            case 1: qualityD = 1.3; qualityS = 1.3; qualityN = "Enhanced "; break;
            case 2: qualityD = 1;   qualityS = 1.9; qualityN = "Unnaturally Fast "; break;
            case 3: qualityD = 1.2; qualityS = 1.5; qualityN = "Shielding "; break;
            case 4: qualityD = 1.5; qualityS = 1.1; qualityN = "Reinforced "; break;
            case 5: qualityD = 1.6; qualityS = 1.2; qualityN = "Long Reaching "; break;
            case 6: qualityD = 1.5; qualityS = 1.5; qualityN = "Magically Infused "; break;
            case 7: qualityD = 1.7; qualityS = 1.1; qualityN = "Dwarven "; break;
            case 8: qualityD = 1.1; qualityS = 1.7; qualityN = "Elven "; break;
            case 9: qualityD = 1.2; qualityS = 1.2; qualityN = "Improved "; break;
            case 10:qualityD = 1.3; qualityS = 1.3; qualityN = "New "; break;
            case 11:qualityD = 1.6; qualityS = 1.2; qualityN = "Imbued "; break;
            case 12:qualityD = 1.4; qualityS = 1.4; qualityN = "Worthy "; break;
            case 13:qualityD = 1.5; qualityS = 1.3; qualityN = "Strong "; break;
            case 14:qualityD = 1.6; qualityS = 1.6; qualityN = "Mighty "; break;
            case 15:qualityD = 1.7; qualityS = 1.7; qualityN = "Powerful "; break;
        }
    }
}
