public class Ranged extends Weapon {
    public Ranged(String name, double damage, int special) {
        super(name, damage, special);
    }

	public int getBaseDamage() {
	return (int) damage;	
	}

    public int getDamage() {
        return (int) Math.round(damage * qualityD + multiplier); //round damage to an integer
    }
	
	public int getSpecial() {
		return (int) special; //special for ranged weapons is ammo
	}
	
	public String getType() {
		String type = "ranged";
		return type;
	}
	
	public void PlHit(Weapon w, Enemy en, Player p) {
        String enemyName = w.name;
		int enemyDamage = w.getDamage();
		p.takeDamage(enemyDamage);

        // Damage output
        System.out.println("  The " +enemyName+ " hits you for " +enemyDamage+ " damage.");
        if (p.getHealth() <= 0) {
			d.End();
        } else {
            System.out.println("  You have " +p.getHealth()+ " hp.");
        }
    }
	
	public void EnHit(Weapon w, Enemy en, Player p) {
		String enemyName = w.name;
		if (enemyName.equalsIgnoreCase("GTMichaels")) {
			System.out.println("  You drop your feeble weapons. Dispair fills your mind as he");
			System.out.println("  approaches you, his very presence the harbinger of Death.");
		} else {
			int playerDamage = p.getDamageR() + d.plDamEffect;
			en.takeDamage(playerDamage);
			pl.useAmmo(-1);
		
			// Damage output
			System.out.println("");
			System.out.println("  You hit the "+enemyName+" with your "+p.getQNameR()+p.getNameR()+" for "+p.getDamageR()+" damage.");
		}
        if (en.getHealth() <= 0) {
            System.out.println("  The " +enemyName+ " dies!");
			en.setDead(true);
        } else {
            System.out.println("  The " +enemyName+ " has " +en.getHealth()+ " hp.");
        }
    }
}