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
        p.hp -= w.getDamage();

        // Damage output
        System.out.println("  The " + w.getName() + " hits you for " + w.getDamage() + " damage.");
        if (p.hp <= 0) {
			d.Delay(null);
			System.out.println("  Final Score: "+p.score);
			d.Delay(null);
            System.out.println("  You Have Perished in the Dungeon...");
			d.Delay(null);
			System.exit(1);
        } else {
            System.out.println("  You have " + p.hp + " hp.");
        }
    }
	
	public void EnHit(Weapon w, Enemy en, Player p) {
        en.hp -= p.getDamageR();
		pl.setAmmo(-1);
		
        // Damage output
		System.out.println("");
        System.out.println("  You hit the "+ w.getName()+" with your "+p.getQNameR()+p.getNameR()+" for "+p.getDamageR()+" damage.");
        if (en.hp <= 0) {
            System.out.println("  The " + w.getName() + " dies!");
			en.isDead = true;
        } else {
            System.out.println("  The " + w.getName() + " has " + en.hp + " hp.");
        }
    }
}