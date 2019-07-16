public class Ranged extends Weapon {
    public Ranged(String name, double damage, int speed) {
        super(name, damage, speed);
    }

    public int getDamage() {
        return (int) Math.round(damage * qualityD); //round damage to an integer
    }
}