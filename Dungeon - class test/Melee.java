public class Melee extends Weapon {
    public Melee(String name, double damage) {
        super(name, damage);
    }

    public int getDamage() {
        return (int) Math.round(damage * quality); //round damage to an integer
    }
}