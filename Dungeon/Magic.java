public class Magic extends Weapon {
	public Magic(String name, double damage, int special) {
        super(name, damage, special);
    }
	
	public int getBaseDamage() {
	return (int) damage;	
	}
	
	public int getDamage() {
		this.newWeapon();
        return (int) Math.round(damage * qualityD + multiplier); //round damage to an integer
    }
	
	public int getSpecial() {
		return (int) special;
	}
	
	public String getType() {
		String type = "magic";
		return type;
	}
	
	public void PlHit(Weapon w, Player p) {
        String enemyName = w.name;
		int enemyDamage = w.getDamage();
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
		p.setMana(-this.getSpecial());
        if (this.name.equalsIgnoreCase("Fireball") || this.name.equalsIgnoreCase("Ice Beam") || this.name.equalsIgnoreCase("Lightning Bolt")) {
			en.takeDamage(this.getDamage());
			// Damage output
			System.out.println("");
			System.out.println("  You hit the "+enemyName+" with your "+this.name+" for "+this.getDamage()+" damage.");
			if (en.getHealth() <= 0) {
				System.out.println("  The " +enemyName+ " dies!");
				en.setDead(true);
			} else {
				System.out.println("  The " +enemyName+ " has " +en.getHealth()+ " hp.");
			}
		}
    }
}