public class Player {
    private int hp;

    public Player(String[] args) {
        hp = 100;
    }
	
	public int getHealth() {
		return hp;
	}

    public void hit(Weapon w) {
        hp -= w.getDamage();

        // Damage output
        System.out.println("  You were hit by the " + w.getName() + " for " + w.getDamage() + " damage.");
        if (hp <= 0) {
            System.out.println("  You are dead!");
        } else {
            System.out.println("  You have " + hp + " hp.");
        }
    }
}
