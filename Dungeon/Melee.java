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
	
	public void PlHit(Weapon w, Enemy en, Player p) {
		Dungeon d = new Dungeon();
		if (d.enId == 37) {
			System.out.println("  Arvin spasms uselessly on the ground");
			return;
		}
		String enemyName = w.name;
		int damage = w.getDamage() + d.enDamEffect;
		p.takeDamage(damage);
		
        // Damage output
        System.out.println("  The "+enemyName+" hits you for "+damage+" damage.");
        if (p.getHealth() <= 0) {
			d.End();
        } else {
            System.out.println("  You have "+p.getHealth()+" hp.");
        }
		if (d.firewall == true) {
			damage = d.fireWall.getBaseDamage();
			en.takeDamage(damage);
			System.out.println("");
			System.out.println("  The wall of fire burns the "+enemyName+" for " +damage+ " damage.");
		}
		if (en.getHealth() <= 0) {
				System.out.println("  The " +enemyName+ " dies!");
				en.setDead(true);
			} else {
            System.out.println("  The " +enemyName+ " has " +en.getHealth()+ " hp.");
		}
    }
	
	public void EnHit(Weapon w, Enemy en, Player p) {
		Dungeon d = new Dungeon();
        String enemyName = w.name;
		int damage = p.getDamageM() + d.plDamEffect;
		en.takeDamage(damage);
		
        // Damage output
        System.out.println("  You hit the "+enemyName+" with your "+p.getQNameM()+p.getNameM()+" for "+damage+" damage.");
		if (en.getHealth() <= 0) {
            System.out.println("  The " +enemyName+ " dies!");
			en.setDead(true);
			if (d.enId == 37) {
				System.out.println("  You almost feel sorry for killing this pathetic creature. Almost.");
			}
        } else {
            System.out.println("  The " +enemyName+ " has " +en.getHealth()+ " hp.");
        }
		if (d.firewall == true) {
			damage = d.fireWall.getBaseDamage();
			p.takeDamage(damage);
			System.out.println("");
			System.out.println("  The wall of fire burns you for " +damage+ " damage.");
			
			if (p.getHealth() <= 0) {
				d.End();
			} else {
				System.out.println("  You have "+p.getHealth()+" hp.");
			}
		}
    }
}