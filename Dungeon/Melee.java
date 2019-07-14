public class Melee extends Weapon {
    public Melee(String name, double damage, int speed) {
        super(name, damage, speed);
    }

    public int getDamage() {
        return (int) Math.round(damage * quality); //round damage to an integer
    }
}