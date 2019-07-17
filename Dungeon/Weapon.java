import java.util.*;
public abstract class Weapon {
    
    protected String name;
    protected double damage;
	protected int speed;
	
	protected double qualityD;
	protected double qualityS;
	protected String qualityN;
	dungeon d = new dungeon();
	Player pl = new Player();
	protected int multiplier = d.level;

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
	
	public void setQuality() {
		Random t = new Random();
		Random q = new Random();
		int tier = t.nextInt(d.level)+1;
		int qualityId;
        
		switch (tier)
		{
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
		//Only negative effects on stats
		switch (Id) {
			case 1: qualityD = 1; qualityS = 1; qualityN = "Basic "; break;
			case 2: qualityD = 1; qualityS = 1; qualityN = "Flimsy "; break;
			case 3: qualityD = 1; qualityS = 1; qualityN = "Rusty "; break;
			case 4: qualityD = 1; qualityS = 1; qualityN = "Vintage "; break;
			case 5: qualityD = 1; qualityS = 1; qualityN = "Moldy "; break;
			case 6: qualityD = 1; qualityS = 1; qualityN = "Old "; break;
			case 7: qualityD = 1; qualityS = 1; qualityN = "Stinky "; break;
			case 8: qualityD = 1; qualityS = 1; qualityN = "Poorly Made "; break;
			case 9: qualityD = 1; qualityS = 1; qualityN = "Dirty "; break;
			case 10:qualityD = 1; qualityS = 1; qualityN = "Small "; break;
			case 11:qualityD = 1; qualityS = 1; qualityN = "Unreliable "; break;
			case 12:qualityD = 1; qualityS = 1; qualityN = "Faulty "; break;
			case 13:qualityD = 1; qualityS = 1; qualityN = "Blunt "; break;
			case 14:qualityD = 1; qualityS = 1; qualityN = "Shoddy "; break;
			case 15:qualityD = 1; qualityS = 1; qualityN = "Child's "; break;
			case 16:qualityD = 1; qualityS = 1; qualityN = "Cheap "; break;
			case 17:qualityD = 1; qualityS = 1; qualityN = "Ordinary "; break;
			case 18:qualityD = 1; qualityS = 1; qualityN = "Slow "; break;
			case 19:qualityD = 1; qualityS = 1; qualityN = "Broken "; break;
		}
    }
    
    private void QualityT2(int Id) 
    {
        //Mixed effects on stats or small buff
        switch (Id)
        {
            case 1: qualityD = 1; qualityS = 1; qualityN = "Light "; break;
            case 2: qualityD = 1; qualityS = 1; qualityN = "Heavy "; break;
            case 3: qualityD = 1; qualityS = 1; qualityN = "Dense "; break;
            case 4: qualityD = 1; qualityS = 1; qualityN = "Nimble "; break;
            case 5: qualityD = 1; qualityS = 1; qualityN = "Quick "; break;
            case 6: qualityD = 1; qualityS = 1; qualityN = "Battle-tested "; break;
            case 7: qualityD = 1; qualityS = 1; qualityN = "Bloodied "; break;
            case 8: qualityD = 1; qualityS = 1; qualityN = "Raging "; break;
            case 9: qualityD = 1; qualityS = 1; qualityN = "Sharp "; break;
            case 10:qualityD = 1; qualityS = 1; qualityN = "Balanced "; break;
            case 11:qualityD = 1; qualityS = 1; qualityN = "Large "; break;
            case 12:qualityD = 1; qualityS = 1; qualityN = "Small "; break;
            case 13:qualityD = 1; qualityS = 1; qualityN = "Modified "; break;
            case 14:qualityD = 1; qualityS = 1; qualityN = "Excited "; break;
        }
    }
    
     private void QualityT3(int Id) {
        //good effects of stats
        switch (Id) {
            case 1: qualityD = 1; qualityS = 1; qualityN = "Enhanced "; break;
            case 2: qualityD = 1; qualityS = 1; qualityN = "Unnaturally Fast "; break;
            case 3: qualityD = 1; qualityS = 1; qualityN = "Shielding "; break;
            case 4: qualityD = 1; qualityS = 1; qualityN = "Reinforced "; break;
            case 5: qualityD = 1; qualityS = 1; qualityN = "Long Reaching "; break;
            case 6: qualityD = 1; qualityS = 1; qualityN = "Magically Infused "; break;
            case 7: qualityD = 1; qualityS = 1; qualityN = "Dwarven "; break;
            case 8: qualityD = 1; qualityS = 1; qualityN = "Elven "; break;
            case 9: qualityD = 1; qualityS = 1; qualityN = "Improved "; break;
            case 10:qualityD = 1; qualityS = 1; qualityN = "New "; break;
            case 11:qualityD = 1; qualityS = 1; qualityN = "Imbued "; break;
            case 12:qualityD = 1; qualityS = 1; qualityN = "Worthy "; break;
            case 13:qualityD = 1; qualityS = 1; qualityN = "Strong "; break;
            case 14:qualityD = 1; qualityS = 1; qualityN = "Mighty "; break;
            case 15:qualityD = 1; qualityS = 1; qualityN = "Powerful "; break;
        }
    }
    
    private void QualityT4(int Id) {
        //Special stat boosts
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
            case 7:; //Deadly (more damage to lving enemies)
            break;
            case 8:; //Holy (more damage to unholy monsters)
            break;
            case 9:; //Demonic (more damage to holy monsters)
            break;
            case 10:; //Perfect (more damage) - think of something
        }
    }
}
