public class Enemy {
    private int hp;

    public Enemy(int h) {
        hp = h;
		
    }

    public void hit(Weapon w) {
        hp -= w.getDamage();

        // Damage output
        System.out.println("  You hit by the " + w.getName() + " for " + w.getDamage() + " damage.");
        if (hp <= 0) {
            System.out.println("  The " + w.getName + " dies!");
        } else {
            System.out.println("  The + " + w.getName + " has " + hp + " hp.");
        }
    }
}