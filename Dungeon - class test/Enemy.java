public class Enemy {
    private int hp;
	public boolean isDead = false;
	Player pl = new Player();
	dungeon d = new dungeon();

    public void setHealth(int h) {
		hp = h;
	}
	
	public int getHealth() {
		return hp;
	}

    public void hit(Weapon w) {
        hp -= pl.getDamage();

        // Damage output
		System.out.println("");
        System.out.println("  You hit the " + w.getName() + " for " + pl.getDamage() + " damage.");
        if (hp <= 0) {
            System.out.println("  The " + w.getName() + " dies!");
			isDead = true;
        } else {
            System.out.println("  The " + w.getName() + " has " + hp + " hp.");
        }
    }
}