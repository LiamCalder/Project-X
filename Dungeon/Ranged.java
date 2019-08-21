public class Ranged extends Weapon {
    public Ranged(String name, double damage, int speed) {
        super(name, damage, speed);
    }

    public int getDamage() {
        return (int) Math.round(damage * qualityD + multiplier); //round damage to an integer
    }
	
	public int getSpeed() {
		return speed; //speed for ranged weapons is ammo
	}
	
	public String getType() {
		String type = "ranged";
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
		String enemyName = w.name;
		int playerDamage = p.getDamageR();
		en.takeDamage(playerDamage);
		pl.useAmmo(-1);
		
        // Damage output
		System.out.println("");
        System.out.println("  You hit the "+enemyName+" with your "+p.getQNameR()+p.getNameR()+" for "+p.getDamageR()+" damage.");
        if (en.getHealth() <= 0) {
            System.out.println("  The " +enemyName+ " dies!");
			en.setDead(true);
        } else {
            System.out.println("  The " +enemyName+ " has " +en.getHealth()+ " hp.");
        }
    }
}