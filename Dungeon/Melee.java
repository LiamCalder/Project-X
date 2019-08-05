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
	
	public void PlHit(Weapon w) {
        pl.hp -= w.getDamage();

        // Damage output
        System.out.println("  The " + w.getName() + " hits you for " + w.getDamage() + " damage.");
        if (pl.hp <= 0) {
			d.Delay(null);
			System.out.println("  Final Score: "+pl.score);
			d.Delay(null);
            System.out.println("  You Have Perished in the Dungeon...");
			d.Delay(null);
			System.exit(1);
        } else {
            System.out.println("  You have " + pl.hp + " hp.");
        }
    }
	
	public void EnHit(Weapon w, Enemy en) {
        en.hp -= pl.getDamage();

        // Damage output
		System.out.println("");
        System.out.println("  You hit the "+ w.getName()+" with your "+pl.getQName()+pl.getName()+" for "+pl.getDamage()+" damage.");
        if (en.hp <= 0) {
            System.out.println("  The " + w.getName() + " dies!");
			en.isDead = true;
        } else {
            System.out.println("  The " + w.getName() + " has " + en.hp + " hp.");
        }
    }
}