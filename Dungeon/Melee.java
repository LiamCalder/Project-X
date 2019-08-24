public class Melee extends Weapon {
    public Melee(String name, double damage, int special) {
        super(name, damage, special);
    }
	public int getBaseDamage() {
	return (int) damage;	
	}

    public int getDamage() {
        return (int) Math.round(damage * qualityD + multiplier); //round damage to an integer
    }
	
	public int getSpecial() {
		return (int) Math.round(special * qualityS); //round special to integer
	}
	
	public String getType() {
		String type = "melee";
		return type;
	}
	
	public void PlHit(Weapon w, Player p) {
		Dungeon d = new Dungeon();
		String enemyName = w.name;
		int enemyDamage = w.getDamage();
		if (d.enId == 37) {
			System.out.println("  Arvin spasms uselessly on the ground");
			return;
		}
		p.takeDamage(enemyDamage);
		
        // Damage output
        System.out.println("  The " +enemyName+ " hits you for " +enemyDamage+ " damage.");
        if (p.getHealth() <= 0) {
			d.Delay(null);
			System.out.println("  Level: "+d.level+"-"+d.subLevel);
			System.out.println("  Final Score: "+p.getScore());
			d.Delay(null);
            System.out.println("  You Have Perished in the Dungeon...");
			d.Delay(null);
			System.exit(1);
        } else {
            System.out.println("  You have " +p.getHealth()+ " hp.");
        }
    }
	
	public void EnHit(Weapon w, Enemy en, Player p) {
		Dungeon d = new Dungeon();
        String enemyName = w.name;
		int playerDamage = p.getDamageM();
		en.takeDamage(playerDamage);
		
        // Damage output
		System.out.println("");
        System.out.println("  You hit the "+enemyName+" with your "+p.getQNameM()+p.getNameM()+" for "+playerDamage+" damage.");
        if (en.getHealth() <= 0) {
            System.out.println("  The " +enemyName+ " dies!");
			en.setDead(true);
			if (d.enId == 37) {
				System.out.println("  You almost feel sorry for killing this pathetic creature. Almost.");
			}
        } else {
            System.out.println("  The " +enemyName+ " has " +en.getHealth()+ " hp.");
        }
    }
}