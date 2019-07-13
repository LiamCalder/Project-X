/**
 * There is a lot to digest in this, but I've almost added everything
 * to do with inheritance and class in here. If you read what I've wrote
 * you should be able to gain a better understanding of the concepts here.
 *
 * If you have any questions let me know, or google it. Java is a popular
 * language because of the features I've included in here.
 *
 * If you are really keen, or fully understand what is here and want to
 * know more, Google 'Java Interfaces'.
 */
public class Game {
    public static void main(String[] args) {
        // Instatiate Weapons and Player
        Weapon ironBroadSword   = new Melee("Iron Broadsword", 10);
        Weapon terraBlade       = new Melee("Terra Blade", 45);

        Weapon silverBow        = new Ranged("Silver Bow", 9);
        Weapon daedalusStormbow = new Ranged("Daedalus Stormbow", 40);
		
		Weapon firebolt         = new Magic("FireBolt", 30);

        Player p1 = new Player(null);

        // Simulate hitting the player
        //p1.hit(ironBroadSword);
        //p1.hit(silverBow);
        //p1.hit(daedalusStormbow);
        //p1.hit(terraBlade);
		//p1.hit(firebolt);
    }
}