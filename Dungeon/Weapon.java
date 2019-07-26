import java.util.*;
public abstract class Weapon {
    
    protected String name;
    protected double damage;
	protected int speed;
	
	protected double qualityD;
	protected double qualityS;
	protected String qualityN;
	Dungeon d = new Dungeon();
	Player pl = new Player();
	protected int multiplier;

    public Weapon(String name, double damage, int speed) {
        this.name = name;
        this.damage = damage;
		this.speed = speed;
    }
	
	public void SendQualityName() {
		pl.setQName(qualityN);
	}
	
	public String getName() {
		return name;
	}
	
	public abstract int getSpeed();

    public abstract int getDamage();
	
	public void newWeapon() {
		
		multiplier = d.level - 1;
		Random t = new Random();
		Random q = new Random();
		int tier = t.nextInt(d.level)+1;
		int qualityId;
        
		switch (tier) {
			case 1: qualityId = q.nextInt(19)+1;
					QualityT1(qualityId); break;
			case 2: qualityId = q.nextInt(14)+1;
					QualityT2(qualityId); break;
			case 3: qualityId = q.nextInt(15)+1;
					QualityT3(qualityId); break;
			case 4: qualityId = q.nextInt(10)+1;
					QualityT4(qualityId); break;
		}
	}
	
	private void QualityT1(int Id)  {
		//Only negative effects on stats (0 < quality < 1)
		d.weaponCost = 10;
		switch (Id) {
			case 1: qualityD = 1; qualityS = 1; qualityN = "Basic "; break;
			case 2: qualityD = 0.8; qualityS = 0.9; qualityN = "Flimsy "; break;
			case 3: qualityD = 0.5; qualityS = 0.8; qualityN = "Rusty "; break;
			case 4: qualityD = 0.9; qualityS = 1; qualityN = "Vintage "; break;
			case 5: qualityD = 0.6; qualityS = 0.7; qualityN = "Moldy "; break;
			case 6: qualityD = 0.9; qualityS = 0.9; qualityN = "Old "; break;
			case 7: qualityD = 0.9; qualityS = 1; qualityN = "Stinky "; break;
			case 8: qualityD = 0.7; qualityS = 0.8; qualityN = "Poorly Made "; break;
			case 9: qualityD = 0.8; qualityS = 0.8; qualityN = "Dirty "; break;
			case 10:qualityD = 0.7; qualityS = 1; qualityN = "Tiny "; break;
			case 11:qualityD = 0.7; qualityS = 0.8; qualityN = "Unreliable "; break;
			case 12:qualityD = 0.6; qualityS = 0.8; qualityN = "Faulty "; break;
			case 13:qualityD = 0.5; qualityS = 0.8; qualityN = "Blunt "; break;
			case 14:qualityD = 0.8; qualityS = 0.7; qualityN = "Shoddy "; break;
			case 15:qualityD = 0.9; qualityS = 0.9; qualityN = "Child's "; break;
			case 16:qualityD = 0.6; qualityS = 0.7; qualityN = "Cheap "; break;
			case 17:qualityD = 1; qualityS = 1; qualityN = "Ordinary "; break;
			case 18:qualityD = 1; qualityS = 0.5; qualityN = "Slow "; break;
			case 19:qualityD = 0.4; qualityS = 0.6; qualityN = "Broken "; break;
		}
    }
    
    private void QualityT2(int Id) {
        //Mixed effects on stats or small buff
		d.weaponCost = 50;
        switch (Id) {
            case 1: qualityD = 0.8; qualityS = 1.7; qualityN = "Light "; break;
            case 2: qualityD = 1.7; qualityS = 0.8; qualityN = "Heavy "; break;
            case 3: qualityD = 1.2; qualityS = 1; qualityN = "Dense "; break;
            case 4: qualityD = 0.8; qualityS = 1.6; qualityN = "Nimble "; break;
            case 5: qualityD = 0.7; qualityS = 1.8; qualityN = "Quick "; break;
            case 6: qualityD = 1.4; qualityS = 1; qualityN = "Battle-tested "; break;
            case 7: qualityD = 1.5; qualityS = 0.9; qualityN = "Bloodied "; break;
            case 8: qualityD = 1.2; qualityS = 0.9; qualityN = "Raging "; break;
            case 9: qualityD = 1.6; qualityS = 0.8; qualityN = "Sharp "; break;
            case 10:qualityD = 1; qualityS = 1.3; qualityN = "Balanced "; break;
            case 11:qualityD = 1.4; qualityS = 0.9; qualityN = "Large "; break;
            case 12:qualityD = 0.7; qualityS = 1.5; qualityN = "Small "; break;
            case 13:qualityD = 1.3; qualityS = 1; qualityN = "Modified "; break;
            case 14:qualityD = 0.8; qualityS = 1.5; qualityN = "Excited "; break;
        }
    }
    
     private void QualityT3(int Id) {
		 d.weaponCost = 150;
        //good effects of stats (1 < quality)
        switch (Id) {
            case 1: qualityD = 1.3; qualityS = 1.3; qualityN = "Enhanced "; break;
            case 2: qualityD = 1; qualityS = 1.9; qualityN = "Unnaturally Fast "; break;
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
    
    private void QualityT4(int Id) {
		d.weaponCost = 200;
        //Special stat boosts (need coding)
        switch (Id) {
            case 1:; //Flaming (cont. burn damage)
            break;
            case 2:; //Toxic (lower dodge of opp + small cont. damage)
            break;
            case 3:; //Grounding (flighing enemies lose dodge buff)
            break;
            case 4:; //Vampirical (chance to regain health on hit)
            break;
            case 5:; //Heroic (more damage to legendary beasts e.g. Dragons)
            break;
            case 6:; //Enchanted (more damage to magical enemies)
            break;
            case 7:; //Deadly (more damage to living enemies)
            break;
            case 8:; //Holy (more damage to unholy monsters)
            break;
            case 9:; //Hunting (more damage to animal monsters)
            break;
            case 10:; //Perfect (better than 'powerful' stats)
        }
    }
}
