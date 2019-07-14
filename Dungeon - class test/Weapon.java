public abstract class Weapon {
    
    protected String name;
    protected double damage;
    protected double quality;
	protected int speed;

    public Weapon(String name, double damage, int speed) {
        this.name = name;
        this.damage = damage;
		this.speed = speed;

        //quality = OneOfTheTierQualityMultipliers()
        quality = 1; // For demonstrative purposes
    }

    public String getName() {
        return name;
    }

    public abstract int getDamage();
	
	public int getSpeed() {
        return speed;
    }
}