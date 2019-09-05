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
		Dungeon d = new Dungeon();
		String enemyName = w.name;
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
		else if (this.name.equalsIgnoreCase("Drain Speed")) {
			d.enSpecEffect = this.getBaseDamage();
			System.out.println("  The enemies movements become slower");
		}
		else if (this.name.equalsIgnoreCase("Defensive Aura")) {
			d.enDamEffect = this.getBaseDamage();
			System.out.println("  A protective field surrounds you");
		}
		else if (this.name.equalsIgnoreCase("Swiftness")) {
			d.plSpecEffect = this.getBaseDamage();
			System.out.println("  Your body is imbued with speed");
		}
		else if (this.name.equalsIgnoreCase("Channel Magic")) {
			d.plDamEffect = this.getBaseDamage();
			System.out.println("  You channel powerful magic into your weapon");
		}
		else if (this.name.equalsIgnoreCase("Wall Of Fire")) {
			d.firewall = true;
			System.out.println("  A fierce blaze springs up between you and you foe");
		}
    }
}