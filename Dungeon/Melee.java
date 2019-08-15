public class Melee extends Weapon {
    public Melee(String name, double damage, int speed) {
        super(name, damage, speed);
    }

    public int getDamage() {
        return (int) Math.round(damage * qualityD + multiplier); //round damage to an integer
    }
	
	public int getSpeed() {
		return (int) Math.round(speed * qualityS); //round speed to integer
	}
	
	public String getType() {
		String type = "melee";
		return type;
	}
	
	public void PlHit(Weapon w, Player p) {
        p.hp -= w.getDamage();
		String enemyName = w.name;
		int enemyDamage = w.getDamage();

        // Damage output
        System.out.println("  The " +enemyName+ " hits you for " +enemyDamage+ " damage.");
        if (p.hp <= 0) {
			d.Delay(null);
			System.out.println("  Final Score: "+p.score);
			d.Delay(null);
            System.out.println("  You Have Perished in the Dungeon...");
			d.Delay(null);
			System.exit(1);
        } else {
            System.out.println("  You have " +p.hp+ " hp.");
        }
    }
	
	public void EnHit(Weapon w, Enemy en, Player p) {
        en.hp -= p.getDamageM();
		String enemyName = w.name;
		int enemyDamage = w.getDamage();
		
        // Damage output
		System.out.println("");
        System.out.println("  You hit the "+enemyName+" with your "+p.getQNameM()+p.getNameM()+" for "+p.getDamageM()+" damage.");
        if (en.hp <= 0) {
            System.out.println("  The " +enemyName+ " dies!");
			en.isDead = true;
        } else {
            System.out.println("  The " +enemyName+ " has " +en.hp+ " hp.");
        }
    }
}