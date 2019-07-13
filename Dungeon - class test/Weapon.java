public abstract class Weapon {
    
    protected String name;
    protected double damage;
    protected double quality;

    public Weapon(String name, double damage) {
        this.name = name;
        this.damage = damage;

        //quality = OneOfTheTierQualityMultipliers()
        quality = 1; // For demonstrative purposes
    }

    public String getName() {
        return name;
    }

    public abstract int getDamage();
}