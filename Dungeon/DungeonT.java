import java.util.*;
import java.io.*;
//import javax.swing.*;

public class DungeonT {
    //initialize Variables
    public static int level = 1; //highest weapon tier that can be generated. Adds onto enemy damage
	public static int subLevel = 0;
	static String battleLast = "weapon";
	static String battleSubLast = "melee";
	static String weaponType;
    static double healthMult = 1.0; //enemy health = base x this
	static int enSpecEffect = 0;
	static int enDamEffect = 0;
	static int plSpecEffect = 0;
	static int plDamEffect = 0;
	static int forceQuality = 0; //make starting weapons start with basic quality (2 on | 0 off)
    static int potionHeal = 60; //potion regen amount
    static int potionMana = 60;
	static int healBaseCost = 10;//base cost
	static int manaBaseCost = 10;
	static int hPotionCost = 10;//current cost
	static int mPotionCost = 10;
	static double mPotionMult = 1.0;//cost multiplier
	static double hPotionMult = 1.0;//cost multiplier
    static int weaponCost;
	static int weaponCostMult;
	static int reloadCost;
    static int enId = -1;
    static Weapon shopW;
	static boolean firewall = false;
	static boolean findWeapon = false;
    static boolean isChest = false;
    static boolean changeW = true;
    static boolean wGen = false;
    static boolean shop = false;
    static boolean fast = false;
	static boolean usedCheats = false;
	static boolean prompt = true;
	static boolean tutorial = true;
    
    //initialise Classes
    static Player pl = new Player();
	static DungeonT dt = new DungeonT();
	
	//used to call general class functions eg: melee.enHit()
	static Weapon melee         = new Melee("", 0, 0); 
	static Weapon ranged         = new Ranged("", 0, 0);
	static Weapon magic         = new Magic("", 0, 0);
    //static DungeonT dt = new DungeonT();
    
    //Melee weapons - special determines dodge chance
    static Weapon dagger         = new Melee("Dagger", 6, 7);            
    static Weapon sword          = new Melee("Sword", 8, 6);             
    static Weapon mace           = new Melee("Mace", 12, 5);                
    static Weapon axe            = new Melee("Axe", 9, 5);             
    static Weapon warHammer      = new Melee("War Hammer", 16, 4);        
    static Weapon quarterstaff   = new Melee("Quarterstaff", 10, 8);      
    static Weapon greatsword     = new Melee("Greatsword", 11, 6);      
    static Weapon shank          = new Melee("Shank", 5, 8);                
    static Weapon spear          = new Melee("Spear", 8, 6);               
    static Weapon wristBlades    = new Melee("Wrist Blades", 8, 5);       
    static Weapon battleAxe      = new Melee("Battle Axe", 16, 4);          
    static Weapon morningstar    = new Melee("Morningstar", 14, 6);       
    static Weapon pike           = new Melee("Pike", 10, 8);              
    static Weapon cutlass        = new Melee("Cutlass", 7, 7);           
    static Weapon flail          = new Melee("Flail", 12, 3);               
    static Weapon club           = new Melee("Club", 8, 4);      
    static Weapon warScythe      = new Melee("War Scythe", 17 ,1);
            
    //Ranged weapons - special determines max ammunition
    static Weapon shortbow       = new Ranged("Shortbow", 5, 7);         
    static Weapon longbow        = new Ranged("Longbow", 7, 5);          
    static Weapon shurikan       = new Ranged("Shurikan", 3, 9);         
    static Weapon crossbow       = new Ranged("Crossbow", 8, 4);
    static Weapon magicStaff     = new Ranged("Magic Staff", 14, 15);
    static Weapon sling          = new Ranged("Sling", 4, 8);
    static Weapon tomahawk       = new Ranged("Tomahawk", 6, 6);
    static Weapon dartGun        = new Ranged("Dart Gun", 3, 9);
    static Weapon compoundBow    = new Ranged("Compound Bow", 13, 3);
    static Weapon rCrossbow      = new Ranged("Repeating Crossbow", 6, 10);
    static Weapon javelin        = new Ranged("Javelin", 9, 7);
           
    //Magic weapons - 'damage' is effect on target stat; special is mana cost 
    static Weapon flame          = new Magic("Fireball", 12, 17);
    static Weapon lightning      = new Magic("Lightning Bolt", 10, 15);    
    static Weapon frost          = new Magic("Ice Beam", 14, 19);         
    static Weapon sapping        = new Magic("Drain Speed", -3, 25); //decrease en special  
    static Weapon aura           = new Magic("Defensive Aura", -4, 25); //decrease en damage   
    static Weapon speed          = new Magic("Swiftness", 3, 25); //increase pl dodge 
    static Weapon channel          = new Magic("Channel Magic", 4, 25); //increase pl damage
    static Weapon fireWall       = new Magic("Wall Of Fire", 3, 10); //damage melee attackers 
    
    //Enemies - Kept in Weapon class in case we want
    //to be able to 'wield' (ie summon) an ally monster
    static Weapon skeleton         = new Melee("Skeleton", 8, 7);           
    static Weapon spider           = new Melee("Spider", 6, 8);             
    static Weapon troll            = new Melee("Troll", 11, 2);              
    static Weapon snake            = new Melee("Snake", 4, 8);              
    static Weapon necromancer      = new Melee("Necromancer", 10, 5);        
    static Weapon wizard           = new Melee("Wizard", 11, 5);             
    static Weapon skeletonArcher   = new Melee("Skeleton Archer", 7, 6);   
    static Weapon goblin           = new Melee("Goblin", 6, 7);             
    static Weapon outlaw           = new Melee("outlaw", 8, 6);             
    static Weapon caveRat          = new Melee("Cave Rat", 4, 8);           
    static Weapon wraith           = new Melee("Wraith", 10, 5);             
    static Weapon zealot           = new Melee("Zealot", 9, 4);             
    static Weapon demon            = new Melee("Demon", 11, 5);              
    static Weapon dragon           = new Melee("Dragon", 12, 2);             
    static Weapon orc              = new Melee("Orc", 9, 4);                
    static Weapon vampire          = new Melee("Vampire", 9, 5);            
    static Weapon leviathan        = new Melee("Leviathan", 11, 3);          
    static Weapon pixie            = new Melee("Pixie", 4, 8);              
    static Weapon harpy            = new Melee("Harpy", 5, 7);              
    static Weapon fallenHero       = new Melee("Fallen Hero", 9, 5);        
    static Weapon guardian         = new Melee("Guardian", 11, 2);           
    static Weapon carnPlant        = new Melee("Carnivorous Plant", 7, 4);  
    static Weapon giant            = new Melee("Giant", 9, 2);              
    static Weapon looter           = new Melee("Looter", 6, 6);             
    static Weapon wyvern           = new Melee("Wyvern", 10, 3);               
    static Weapon cursedSoul       = new Melee("Cursed Soul", 8, 4);        
    static Weapon fElemental       = new Melee("Fire Elemental", 9, 5);    
    static Weapon wElemental       = new Melee("Water Elemental", 9, 5);   
    static Weapon eElemental       = new Melee("Earth Elemental", 9, 5);   
    static Weapon aElemental       = new Melee("Air Elemental", 9, 5);     
    static Weapon basilisk         = new Melee("Basilisk", 11, 3);           
    static Weapon golem            = new Melee("Rock Golem", 10, 2);
    static Weapon manticore        = new Melee("Manticore", 12, 6);
    static Weapon draugr           = new Melee("Draugr", 12, 4);
    static Weapon legion           = new Melee("Legion", 8, 2);
    static Weapon gtmichaels       = new Melee("GTMichaels", 8554, 2002);
    static Weapon arvin            = new Melee("Arvin", 0, 0);
    static Weapon griffin          = new Melee("Griffin", 11, 3);
    static Weapon mimic            = new Melee("Mimic", 9, 6);
	
    
    public static void main(String[] args) {
        //set up beginning of game
        Scanner s = new Scanner(System.in);
        WeaponStats(pl.getWeaponM()); //sets player melee and ranged weapons
		changeW = true;
		WeaponStats(pl.getWeaponR());
        String input = "";
		System.out.println("  Welcome to the Dungeon tutorial. This tutorial will explain");
		System.out.println("  the various features and functions inside the game, and teach");
		System.out.println("  you the basic rules. Now, when the game pauses like this, with");
		System.out.println("  no input prompt, just press enter to continue.");
		Delay();
		System.out.println("  First off, the menu.");
		System.out.println("");
		System.out.println("  Below is the menu that appears at the beginning of");
		System.out.println("  each new game. It has a few simple options, like quit,");
		System.out.println("  help, and controls. The menu will continue to appear until");
		System.out.println("  'start' is entered. But first, type 'help' and press enter");
		System.out.println("  for information on how to play the game.");
		System.out.println("");
        while (tutorial == true) {
            //option select
			System.out.println("");
            System.out.println("       Do you want to enter The Dungeon?");
            System.out.println("  ===========================================");
            System.out.println("  [Start] [Help] [Controls] [Tutorial] [Quit]");
            System.out.print("  ");
            input = s.nextLine();
			System.out.println("");
            if (input.equalsIgnoreCase("start") || input.equalsIgnoreCase("s")) {
				System.out.println("");
				System.out.println("  Now the game starts. The game will show the following message:");
				System.out.println("");
				System.out.println("  You descend the stairs...");
				System.out.println("");
				System.out.println("  You will see this message every now and again as you play.");
				System.out.println("  Be aware, this message means that as you go deeper into the");
				System.out.println("  Dungeon, enemies will get harder.");
				LevelChain();//level method
            }
            else if (input.equalsIgnoreCase("quit") || input.equalsIgnoreCase("q")) {
                System.exit(1); //exit java
            }
            else if (input.equalsIgnoreCase("controls") || input.equalsIgnoreCase("c")) {
                Controls(); //control method
            }
            else if (input.equalsIgnoreCase("tutorial") || input.equalsIgnoreCase("t")) {
                System.out.println("  You are already in the tutorial!");
            }
            else {
                Help(); // help method 
            }
        }
    }
	
	public static void End() { //end of game printouts
		if (usedCheats == true) {
			pl.addScore(-(pl.getScore()*421610)); //-'ve mult for cheaters
		}
		Delay();
		System.out.println("  Level: "+level+"-"+subLevel);
		System.out.println("  Final Score: "+pl.getScore());
		Delay();
        System.out.println("  You Have Perished in the Dungeon...");
		Delay();
		Scanner s = new Scanner(System.in);
		String input = "";
		while (1 == 1) {
			System.out.println("  Do you want to play again?");
			System.out.println("  ==========================");
			System.out.println("        [Yes]      [No]");
			System.out.print("  ");
			input = s.nextLine();
			if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
				try {
					Runtime.getRuntime().exec("cmd /c start Dungeon.lnk"); //run game again
					System.exit(0);
				} 
				catch (Exception e) {
					System.out.println(e);
				}
				finally {
					System.exit(0);
				}
			} 
			else if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")) {
				System.exit(1);
			} else {
				System.out.println("");
				System.out.println("  Not a valid option. Enter '?' for help");
				System.out.println("");
			}
		}
	}
    
    private static void LevelChain() {
		subLevel++;
        Delay(); //make game wait for user
        Random r = new Random();
        int vary = r.nextInt(3)+4; //variation on number of levels (btwn 4 - 6)
        int roomArr[] = new int[vary]; //create array of vary length
        for (int i=0; i<vary; i++) {
            //call RoomId and grab Id
            int roomId = RoomId();
            boolean isDup = isDuplicate(roomArr, roomId); //check for duplicates
            if (isDup == true) {
                i--;
            }
            else {
                roomArr[i] = roomId; //if no dupes, add Id to array and execute room
				RoomGen(roomId);
				
            }
        }
        RoomGen(26); //generate shop at end of each level
        NextLevel();
    }
    
    private static boolean isDuplicate(int roomArr[], int Id) {//duplicate room check function
        for (int i=0; i<roomArr.length; i++) {
            if (Id == roomArr[i])
            {
                return true;
            }
        }
        return false;
    }
    
    private static void Help() {
        System.out.println("  When you need to make a choice, your options appear in");
        System.out.println("  square brackets under a double line, like this:");
        System.out.println("");
		System.out.println("   What will you do?");
        System.out.println("  ===================");
        System.out.println("  [Option1] [Option2]");
        System.out.println("");
        System.out.println("  The game will then pause and wait for input. To choose an");
        System.out.println("  option, just type the first letter 'o' or the whole option");
        System.out.println("  name 'option1'. Then press enter and the option is selected.");
        System.out.println("  when the game pauses without this input prompt, simply press");
        System.out.println("  enter and the game will continue.");
        Delay();
    }
    
    private static void Controls() {
		System.out.println("  These are the commands you can enter");
		System.out.println("  during a pause. Remember, they cannot");
		System.out.println("  be used during an input prompt.");
		System.out.println("");
        System.out.println("  KEYBINDINGS            FUNCTION");
		System.out.println("  'controls' or 'c'......brings up this menu");
        System.out.println("  'quit' or 'q'..........quit the game");
        System.out.println("  'help' or 'h' or '?'...bring up help menu");
        System.out.println("  'examine' or 'e'.......find more info on enemy");
		System.out.println("  'prompt' or 'p'........toggle continue prompt on pause");
        Delay();
    }
    
    private static void NextLevel() {
        //This method bumps up enemy stats and loot spawn tiers
		Scanner s = new Scanner(System.in);
        level++;
		subLevel = 0;
        healthMult += 0.2;
		String input = "";
		
		System.out.println("  You find a staircase leading deeper into the dungeon");
		System.out.println("");
        System.out.println("  You descend the stairs...");
		Delay();
		System.out.println("  After you leave the shop, there is only one more thing to do before");
		System.out.println("  you start the next level. here, you can choose either your max. health");
		System.out.println("  or your max. mana to be increased by 10. Seeing as though this is the");
		System.out.println("  first level, it is probably wise to upgrade your health.");
		System.out.println("");
		while (1 == 1) { //increase maximum health or mana by 10
			System.out.println("      Choose a stat to increase");
			System.out.println("  ==================================");
			System.out.println("  [Health]:"+pl.getHpCap()+"->"+(pl.getHpCap()+10)+"  [Mana]:"+pl.getManaCap()+"->"+(pl.getManaCap()+10)+"");
			System.out.print("  ");
			input = s.nextLine();
			System.out.println("");
			if (input.equalsIgnoreCase("health") || input.equalsIgnoreCase("h")) {
				pl.setHpCap(10);
				pl.setHealth(10);
				System.out.println("  Max health increased to "+pl.getHpCap());
				break;
			}
			else if (input.equalsIgnoreCase("mana") || input.equalsIgnoreCase("m")) {
				pl.setManaCap(10);
				pl.setMana(10);
				System.out.println("  Max mana increased to "+pl.getManaCap());
				break;
			} else {
				System.out.println("  Not a valid option. Enter '?' for help");
			}
		}
		System.out.println("");
        System.out.println("  Congratulations! You completed the tutorial!");
		Delay();
		return;
    }
    
    private static void Delay() {//wait for user to continue, or enter a command
        if (fast == true) {
            System.out.println("");
            return;
        }
		if (prompt == true) {
			System.out.println("  Press enter to continue... ");
		}
        Scanner s = new Scanner(System.in);
        String delay = s.nextLine();
        
        if (delay.equalsIgnoreCase("?") || delay.equalsIgnoreCase("help") || delay.equalsIgnoreCase("h")) {
            Help();
        }
        else if (delay.equalsIgnoreCase("quit")|| delay.equalsIgnoreCase("q")) {
            System.exit(1);
        }
		else if (delay.equalsIgnoreCase("controls")|| delay.equalsIgnoreCase("c")) {
            Controls();
        }
        else if (delay.equalsIgnoreCase("examine") || delay.equalsIgnoreCase("e")) {
            Examine(enId);
        }
		else if (delay.equalsIgnoreCase("prompt") || delay.equalsIgnoreCase("p")) {
            prompt = !prompt;
        }
		if (!delay.equalsIgnoreCase("") || prompt == true) {
			System.out.println("");
		}
		else if (delay.equalsIgnoreCase("subscribe to GTMichaels2002")) {
			System.out.println("");
			System.out.println("  The caverns around you tremble. An ancient and powerful presence surrounds you,");
			System.out.println("  filling your mind with dread and your body with weakness. As pure fear floods your ");
			System.out.println("  body with hopelessness, you know one thing is certain: you are going to die.");
			Battle(gtmichaels, 1000);
		}
		else if (delay.equalsIgnoreCase("111")) { //debug commands, with code activation
            usedCheats = true;
			delay = s.nextLine();
        }
		if (usedCheats == true) {
			if (delay.equalsIgnoreCase("fast")) {
            fast = !fast;
			}
			else if (delay.equalsIgnoreCase("money")) {
				pl.setCash(999999999);
			}
			else if (delay.equalsIgnoreCase("level")) {
				level = 3;
			}
			else if (delay.equalsIgnoreCase("potion")) {
				pl.setHPotions(99);
				pl.setMPotions(99);
			}
			else if (delay.equalsIgnoreCase("shop")) {
				Shop();
			}
			else if (delay.equalsIgnoreCase("spells")) {
				String input = s.nextLine();
				if (input.equalsIgnoreCase("all")) {
					pl.giveSpell("Fireball");
					pl.giveSpell("Ice Beam");
					pl.giveSpell("Lightning Bolt");
					pl.giveSpell("Defensive Aura");
					pl.giveSpell("Wall of Fire");
					pl.giveSpell("Swiftness");
					pl.giveSpell("Drain Speed");
					pl.giveSpell("Channel Magic");
				} else {
					pl.giveSpell(input);
				}
			}
			else if (delay.equalsIgnoreCase("gen")) {
				wGen = true;
				try {
					int input = s.nextInt();
					WeaponStats(input);
					shopW.newWeapon();
				} catch (Exception e) {}
				finally {
					System.out.println("");
					wGen = false;
				}
			}
			else if (delay.equalsIgnoreCase("c melee")) {
				String tName = s.nextLine();
				int d = s.nextInt();
				int sp = s.nextInt();
				Weapon CM = new Melee(tName, d, sp);
				changeW = true;
				GetStats(CM);
			}
			else if (delay.equalsIgnoreCase("c ranged")) {
				String tName = s.nextLine();
				int d = s.nextInt();
				int sp = s.nextInt();
				Weapon CR = new Ranged(tName, d, sp);
				changeW = true;
				GetStats(CR);
			}
			else if (delay.equalsIgnoreCase("end")) {
				End();
			}
			else if (delay.equalsIgnoreCase("debug")) {
				System.out.println("");
				System.out.println("---- DEBUG STATS ----");
				System.out.println("");
				System.out.println("  level: "+level);
				System.out.println("  Enemy Health Multiplier: "+healthMult);
				System.out.println("  Global weapon Damage Addition: "+melee.multiplier);
				System.out.println("  Enemy Special effect: "+enSpecEffect);
				System.out.println("  Enemy Damage effect: "+enDamEffect);
				System.out.println("  Player Special effect: "+plSpecEffect);
				System.out.println("  Player Damage effect: "+plDamEffect);
				System.out.println("  Last enemy Id: "+enId);
				System.out.println("");
				System.out.println("  Current Boolean states");
				System.out.println("  FireWall spell active: "+firewall);
				System.out.println("  Weapon found: "+findWeapon);
				System.out.println("  getting loot from chest: "+isChest);
				System.out.println("  force weapon change: "+changeW);
				System.out.println("  Generate new weapon when possible: "+wGen);
				System.out.println("  Currently in Shop: "+shop);
				System.out.println("  Fast mode on: "+fast);
				System.out.println("  Used debug cheats : "+usedCheats);
				System.out.println("");
				System.out.println("  Player Values");
				System.out.println("  Coins: "+pl.getCash());
				System.out.println("  Health: "+pl.getHealth());
				System.out.println("  Score: "+pl.getScore());
				System.out.println("  Mana: "+pl.getMana());
				System.out.println("  Health Potions: "+pl.getHPotions());
				System.out.println("  Mana Potions: "+pl.getMPotions());
				System.out.println("  Melee Weapon Id: "+pl.getWeaponM());
				System.out.println("  Melee Weapon name: "+pl.getNameM());
				System.out.println("  Melee Weapon quality: "+pl.getQNameM());
				System.out.println("  Melee Weapon damage: "+pl.getDamageM());
				System.out.println("  Melee Weapon speed: "+pl.getSpecialM());
				System.out.println("  Ranged Weapon Id: "+pl.getWeaponR());
				System.out.println("  Melee Weapon name: "+pl.getNameR());
				System.out.println("  Ranged Weapon quality: "+pl.getQNameR());
				System.out.println("  Ranged Weapon damage: "+pl.getDamageR());
				System.out.println("  Ranged Weapon ammo: "+pl.getAmmo());
				System.out.println("  Ranged weapon max ammo: "+pl.getMaxAmmo());
				System.out.println("");
				System.out.println("---- DEBUG STATS ----");
				System.out.println("");
			}
		}
    }

    private static int RoomId() { //room Id list
        Random r = new Random();
        int roomId = r.nextInt(25)+1; //choose random Id from room list
        return roomId; //pass RoomId back to Caller
    }
    
    private static void Battle(Weapon e, int h) {
		Enemy en = new Enemy();
        e.newWeapon();
        en.setHealth((int) Math.round(h*healthMult)); //set enemy health
		String input = battleLast;
		String subInput = battleSubLast; //set inputs to last used value
		Delay();
		if (enId == 32) {
			System.out.println("  It's a Mimic!");
		} else {
			System.out.println("  A " + e.getName() + " appears!");
		}
        Delay();
		if (tutorial == true) {
			System.out.println("  You've encountered an enemy! There are a couple of");
			System.out.println("  things you need to know about battles:");
			System.out.println("");
			System.out.println("  Every enemy, and weapon, has 2 base stats.");
			System.out.println("  these are damage, and special. Damage determines the");
			System.out.println("  amount of HP taken from the opponent per hit. When");
			System.out.println("  the enemies or your HP becomes 0, they die, and you get");
			System.out.println("  a reward of either coins, or sometimes a weapon. Special");
			System.out.println("  is different depending on the type of weapon. In melee");
			System.out.println("  weapons, special determines your dodge chance. Special");
			System.out.println("  in ranged weapons determines their max ammo capacity.");
			System.out.println("  special in magic spells is thier mana cost.");
			System.out.println("");
			System.out.println("  Your weapons all have a quality. this quality can effect");
			System.out.println("  the stats of your weapon, for better or worse. over time");
			System.out.println("  as you go deeper into the dungeon, better quality weapons");
			System.out.println("  will start appearing.");
			Delay();
			System.out.println("  On your turn, you have 3 options: weapon, potion and last.");
			System.out.println("");
			System.out.println("  weapon branches into 3 more options: melee, ranged or spell.");
			System.out.println("  Melee: free to use, chance to miss");
			System.out.println("  Ranged: limited ammunition, always hits");
			System.out.println("  Magic: 2 types, attack and effect");
			System.out.println("   - Attack: Costs mana, damage fluctuates");
			System.out.println("   - Effect: Costs mana, creates a lasting effect on player or enemy");
			System.out.println("");
			System.out.println("  Potion branches into 2 options: Health or Mana");
			System.out.println("  Health: consumes health potion and increase health by 60");
			System.out.println("  Mana: consumes mana potion and increase mana by 60");
			System.out.println("");
			System.out.println("  Last selects the last option you chose. If your last entry");
			System.out.println("  was a spell, you will be sent to the spell menu instead");
			System.out.println("  of automatically using your last spell. If your last entry");
			System.out.println("  did not fit any of the options, Last will default to a Melee");
			System.out.println("  attack");
			System.out.println("");
			tutorial = false;
		}
        while (en.getHealth() > 0) {
            Scanner s = new Scanner(System.in);
			boolean last = false;
            System.out.println("       What will you do?");
            System.out.println("  ===========================");
            System.out.println("  [Weapon]  [Potions]  [Last]");
			System.out.print("  ");
            input = s.nextLine();
			System.out.println("");
			if (input.equalsIgnoreCase("last") || input.equalsIgnoreCase("l")) {
				last = true; //skip user inputs
				input = battleLast;
				if (!input.equalsIgnoreCase("w") && !input.equalsIgnoreCase("weapon") && !input.equalsIgnoreCase("p") && !input.equalsIgnoreCase("potions")) {
					input = "w"; //if prev input was empty, set as melee attack
				}
				if (!subInput.equalsIgnoreCase("m") && !subInput.equalsIgnoreCase("r") && !subInput.equalsIgnoreCase("h") && !subInput.equalsIgnoreCase("s")) {
					subInput = "m"; //^ same
				}
				//select last choice to make battles less tedious
			} else {
				battleLast = input;
			}
            if (input.equalsIgnoreCase("weapon") || input.equalsIgnoreCase("w")) {
				if (last != true) {
					System.out.println("       What weapon do you use?");
					System.out.println("  ==================================");
					System.out.println("  [Melee] [Ranged("+pl.getAmmo()+")] [Spell] [Back]");
					System.out.print("  ");
					subInput = s.nextLine();
					System.out.println("");
					battleSubLast = subInput;
				}
				if (subInput.equalsIgnoreCase("melee") || subInput.equalsIgnoreCase("m")) {
					enDodgeChance(e, en, 1, melee);
					if (en.getDead()) {
						pl.addScore(100+h); //+100 for winning, + damage dealt
						GetLoot(); //get money
						System.out.println("  You enter the next room");
						Delay();
						break;
					}
					Delay();
					plDodgeChance(e, en);
				}
				else if (subInput.equalsIgnoreCase("ranged") || subInput.equalsIgnoreCase("r")) {
					if (pl.getAmmo() != 0) {
						ranged.EnHit(e, en, pl);
						if (en.getDead()) {
							pl.addScore(100+h); //+100 for winning, + damage dealt
							GetLoot(); //get money
							System.out.println("  You enter the next room");
							Delay();
							break;
						}
						Delay();
						plDodgeChance(e, en);
					} else {
						System.out.println("  You don't have any more ammunition!");
					}
				}
				else if (subInput.equalsIgnoreCase("spell") || subInput.equalsIgnoreCase("s")) {
					boolean noMana = false;
					if (pl.getSpell("haveSpells") == true) {
						System.out.println("");
						System.out.println("     What spell do you use?");
						System.out.println("  ============================");
						
						if (pl.getSpell("flame") == true) { //checks Player for known spells and prints them
							System.out.println("  [F]ireball: "+flame.getSpecial()+" mana");
						}
						if (pl.getSpell("spark") == true) {
							System.out.println("  [L]ightning Bolt: "+lightning.getSpecial()+" mana");
						}
						if (pl.getSpell("frost") == true) {
							System.out.println("  [I]ce Beam: "+frost.getSpecial()+" mana");
						}
						if (pl.getSpell("sap") == true) {
							System.out.println("  [Dr]ain Speed: "+sapping.getSpecial()+" mana");
						}
						if (pl.getSpell("aura") == true) {
							System.out.println("  [De]fensive Aura: "+aura.getSpecial()+" mana");
						}
						if (pl.getSpell("speed") == true) {
							System.out.println("  [S]wiftness: "+speed.getSpecial()+" mana");
						}
						if (pl.getSpell("channel") == true) {
							System.out.println("  [C]hannel Magic: "+channel.getSpecial()+" mana");
						}
						if (pl.getSpell("firewall") == true) {
							System.out.println("  [W]all of Fire: "+fireWall.getSpecial()+" mana");
						}
						System.out.println("");
						System.out.println("  Availiable mana: "+pl.getMana());
						
						System.out.print("  ");
						String subSubInput = s.nextLine();
						System.out.println("");
						
						if (subSubInput.equalsIgnoreCase("back") || subSubInput.equalsIgnoreCase("b")) {
							continue;
						}
						switch (subSubInput.toLowerCase()) { //each spells individual action when used
							case "f": if (pl.getMana() >= flame.getSpecial() && pl.getSpell("flame") == true) {
								enDodgeChance(e, en, 2, flame); break;
							} else {
								System.out.println("  You don't have enough mana!");
								noMana = true;
							}  break;
							case "l": if (pl.getMana() >= lightning.getSpecial() && pl.getSpell("firewall") == true) {
								enDodgeChance(e, en, 2, lightning); break;
							} else {
								System.out.println("  You don't have enough mana!");
								noMana = true;
							}  break;
							case "i": if (pl.getMana() >= frost.getSpecial() && pl.getSpell("frost") == true) {
								enDodgeChance(e, en, 2, frost); break;
							} else {
								System.out.println("  You don't have enough mana!");
								noMana = true;
							}  break;
							case "dr": if (pl.getMana() >= sapping.getSpecial() && pl.getSpell("sap") == true) {
								enDodgeChance(e, en, 2, sapping); break;
							} else {
								System.out.println("  You don't have enough mana!");
								noMana = true;
							}  break;
							case "de": if (pl.getMana() >= aura.getSpecial() && pl.getSpell("aura") == true) {
								enDodgeChance(e, en, 2, aura); break;
							} else {
								System.out.println("  You don't have enough mana!");
								noMana = true;
							}  break;
							case "s": if (pl.getMana() >= speed.getSpecial() && pl.getSpell("speed") == true) {
								enDodgeChance(e, en, 2, speed); break;
							} else {
								System.out.println("  You don't have enough mana!");
								noMana = true;
							}  break;
							case "c": if (pl.getMana() >= channel.getSpecial() && pl.getSpell("channel") == true) {
								enDodgeChance(e, en, 2, channel); break;
							} else {
								System.out.println("  You don't have enough mana!");
								noMana = true;
							}  break;
							case "w": if (pl.getMana() >= fireWall.getSpecial() && pl.getSpell("firewall") == true) {
								enDodgeChance(e, en, 2, fireWall); break;
							} else {
								System.out.println("  You don't have enough mana!");
								noMana = true;
							}  break;
							default: System.out.println("  Not a valid option. Enter '?' for help");
								noMana = true;
							 break;
						}
						if (en.getDead()) {
							pl.addScore((100 * level)+h); //+100 * level for winning, + damage dealt
							GetLoot(); //get money
							System.out.println("  You enter the next room");
							Delay();
							break;
						} 
						if (noMana == false) {
							Delay();
							plDodgeChance(e, en);
						}
					} else {
						Delay();
						System.out.println("  You don't know any spells!");
					}
				}
				else if (subInput.equalsIgnoreCase("back") || subInput.equalsIgnoreCase("b")) {
					continue;
				} else {
					System.out.println("  Not a valid option. Enter '?' for help");
				}
            }
			else if (input.equalsIgnoreCase("potions") || input.equalsIgnoreCase("p") || last == true) {
				if (last != true) {
					System.out.println("");
					System.out.println("    What potion do you use?");
					System.out.println("  ============================");
					System.out.println("  [Health("+pl.getHPotions()+")] [Mana("+pl.getMPotions()+")] [Back]");
					System.out.println("  Current Health: "+pl.getHealth());
					System.out.print("  ");
					subInput = s.nextLine();
					System.out.println("");
					battleSubLast = subInput;
				}
				if (subInput.equalsIgnoreCase("health") || subInput.equalsIgnoreCase("h")) {
					if (pl.getHPotions() > 0) {
						pl.setHealth(potionHeal);// heal by potionHeal amount and remove 1 health potion
						pl.setHPotions(-1);
						System.out.println("  You feel your body being repaired");
						System.out.println("  You have "+pl.getHPotions()+" health potions");
						System.out.println("  You have "+pl.getHealth()+" health");
						Delay();
						plDodgeChance(e, en);
					} else {
						System.out.println("  You don't have any more health potions!");
					}
                
				}
				else if (subInput.equalsIgnoreCase("mana") || subInput.equalsIgnoreCase("m")) {
					if (pl.getMPotions() > 0) {
						System.out.println("  Your magik is restored");
						pl.setMana(potionMana);// ^ same but for mana
						pl.setMPotions(-1);
						System.out.println("  You have "+pl.getHPotions()+" mana potions");
						System.out.println("  You have "+pl.getMana()+" mana points");
						Delay();
						plDodgeChance(e, en);
					} else {
						System.out.println("  You don't have any more mana potions!");
					}
				} 
				else if (subInput.equalsIgnoreCase("back") || subInput.equalsIgnoreCase("b")) {
					continue;
				} else {
					System.out.println("  Not a valid option. Enter '?' for help");
				}
			} else {
				System.out.println("  Not a valid option. Enter '?' for help");
			}
			last = false;
			Delay();
        }
		enSpecEffect = 0;
		enDamEffect = 0;
		plSpecEffect = 0; //- reset spell effects for next battle
		plDamEffect = 0;
		firewall = false;
		isChest = false;
    }
    
    private static void enDodgeChance(Weapon e, Enemy en, int type, Weapon w) {
        //dodge chance is special * X% chance, eg 6x4 = 24% chance
        //to dodge attack with max 10 * X% (10x4) chance to dodge
        //to dodge score must be lower than target.
        Random r = new Random();
		if (e.getName().equalsIgnoreCase("GTMichaels")) {
			System.out.println("  You drop your feeble weapons. Dispair fills your mind as he");
			System.out.println("  approaches you, his very presence the harbinger of Death.");
			System.out.println("");
			melee.PlHit(e, en, pl);
		}
		if (pl.getNameM().equalsIgnoreCase("Infinity Gauntlet")) {
			int snap = r.nextInt(2)+1;
			System.out.println("  You snap your fingers and energy pulses out");
			Delay();
			if (snap == 1) {
			System.out.println("  The "+e.getName()+" dissolves into dust at your feet");	
			en.setHealth(0);
			en.setDead(true);
			return;
			} else {
				System.out.println("  The last thing you see is your body dissapearing before your eyes go dark");
				End();
			}
		}
        int target = (e.getSpecial()+enSpecEffect) * 4; 
        int score = r.nextInt(100)+1;
		if (type == 1 || w.getName().equalsIgnoreCase("Fireball") || w.getName().equalsIgnoreCase("Ice Beam") || w.getName().equalsIgnoreCase("Lightning Bolt")) {
			if (score > target) {
				if (type == 1) { //if attacking with a melee weapon
					melee.EnHit(e, en, pl);
				} else { //if attacking with attack spell
					pl.setMana(-w.getSpecial());
					w.EnHit(e, en, pl);
				}
			} 
			else if (type != 1) { //if score < target and used a spell
				pl.setMana(-w.getSpecial());
				System.out.println("  The "+e.getName()+" dodges your attack!");
			} else {
				System.out.println("  The "+e.getName()+" dodges your attack!");
			}
		} else {
			pl.setMana(-w.getSpecial());
			w.EnHit(e, en, pl);
		}
    }
    
    private static void plDodgeChance(Weapon e, Enemy en) {
        Random r = new Random();
        int target = (pl.getSpecialM()+plSpecEffect) * 4;
        int score = r.nextInt(100)+1;
        
        if (score > target) {
			melee.PlHit(e, en, pl);
        } else {
            System.out.println("  You dodge the "+e.getName()+"'s attack!");
        }
    }
    
    private static void Shop() {
		shop = true;
        Scanner s = new Scanner(System.in);
        String input = "";
        String subInput = "";
        wGen = true;
        WeaponTier();
        shopW.newWeapon();
        wGen = false;
        
		System.out.println("  At the end of each level, 2 things happen. first, you get to");
		System.out.println("  use the shop. While at the shop, you can buy: ammuntion for your");
		System.out.println("  ranged weapon, a new weapon, health potions, mana potions, or");
		System.out.println("  reforge your current weapons quality.");
		System.out.println("  All costs increase as you progress further into the game.");
		System.out.println("  Potion costs follow this trend, as well as slowly increasing in");
		System.out.println("  price every time you purchase a potion of the same type.");
        Delay();
        while (!input.equalsIgnoreCase("leave") && !input.equalsIgnoreCase("l")) {
            System.out.println("   What do you want to buy?");
            System.out.println("  ===========================");
            System.out.println("  [Potions] [Weapons] [Leave]");
            System.out.print("  ");
            input = s.nextLine();
            System.out.println("");
            
            if (input.equalsIgnoreCase("potions") || input.equalsIgnoreCase("p")) {
				hPotionCost = (int) Math.round(healBaseCost * level);
				mPotionCost = (int) Math.round(manaBaseCost * level);
                System.out.println("      What do you want to buy?");
                System.out.println("  ================================");
                System.out.println("  [Health:"+hPotionCost+"]  [Mana:"+mPotionCost+"]  [Back]");
                System.out.println("  Balance: "+pl.getCash());
                System.out.print("  ");
                subInput = s.nextLine();
                System.out.println("");
                
                if (subInput.equalsIgnoreCase("health") || subInput.equalsIgnoreCase("h")) {
                    if (pl.getCash() >= hPotionCost) {
                        pl.setHPotions(1);
                        pl.setCash(-hPotionCost);
						healBaseCost += 1;
                        System.out.println("  You purchased a health potion");
                        System.out.println("  You have "+pl.getHPotions()+" health potions");
                    } else {
                        System.out.println("  You don't have enough money!");
                    }
                }
                else if (subInput.equalsIgnoreCase("mana") || subInput.equalsIgnoreCase("m")) {
                    if (pl.getCash() >= mPotionCost) {
                        pl.setMPotions(1);
                        pl.setCash(-mPotionCost);
						manaBaseCost += 1;
                        System.out.println("  You purchased a mana potion");
                        System.out.println("  You have "+pl.getMPotions()+" mana potions");
                    } else {
                        System.out.println("  You don't have enough money!");
                    }
                }
                else if (subInput.equalsIgnoreCase("back") || subInput.equalsIgnoreCase("b")) {
                    continue;
                } else {
                        System.out.println("  Not a valid option. Enter '?' for help");
                } 
            }
            else if (input.equalsIgnoreCase("weapons") || input.equalsIgnoreCase("w")) {
				System.out.println("      What do You want to buy?");
				System.out.println("  ================================");
				System.out.println("  [Weapon] [Ammo] [Reforge] [Back]");
				System.out.print("  ");
				subInput = s.nextLine();
				System.out.println("");
				
                if (subInput.equalsIgnoreCase("weapon") || subInput.equalsIgnoreCase("w")) {
					GetStats(shopW);
				}
				else if (subInput.equalsIgnoreCase("ammo") || subInput.equalsIgnoreCase("a")) {
					if (pl.getAmmoDiff() != 0) {
						System.out.println("  Purchase "+pl.getAmmoDiff()+" ammo for "+reloadCost+" coins?");
						System.out.println("  ==============================");
						System.out.println("         [Yes]       [No]");
						System.out.print("  ");
						subInput = s.nextLine();
						System.out.println("");
					} else {
						System.out.println("  You can't hold any more ammo!");
					}
					if (subInput.equalsIgnoreCase("yes") || subInput.equalsIgnoreCase("y")) {
						if (pl.getCash() >= reloadCost) {
							System.out.println("  You purchase a reload");
							pl.setCash(-reloadCost);
							pl.setNewAmmo(pl.getMaxAmmo());
						} else {
							System.out.println("  You don't have enough money!");
						}
					}
				} 
				else if (subInput.equalsIgnoreCase("r") || subInput.equalsIgnoreCase("reforge")) {
					int reforgeCost = level * 10;
					System.out.println("     Reforge quality of which weapon?");
					System.out.println("  ======================================");
					System.out.println("  [Melee]: "+pl.getQNameM()+"   [Ranged]: "+pl.getQNameR());
					System.out.println("  Cost: "+(reforgeCost));
					System.out.println("  Balance: "+pl.getCash());
					System.out.print("  ");
					subInput = s.nextLine();
					System.out.println("");
					if(subInput.equalsIgnoreCase("m") || subInput.equalsIgnoreCase("melee")) {
						if (pl.getCash() >= reforgeCost) {
							pl.setCash(-reforgeCost);
							changeW = true;
							System.out.print("  You reforge your "+pl.getQNameM()+pl.getNameM()+" to ");
							WeaponStats(pl.getWeaponM());
							System.out.println(pl.getQNameM());
						} else {
							System.out.println("  You don't have enough money!");
						}
					}
					else if (subInput.equalsIgnoreCase("r") || subInput.equalsIgnoreCase("ranged")) {
						if (pl.getCash() >= reforgeCost) {
							pl.setCash(-reforgeCost);
							changeW = true;
							System.out.print("  You reforge your "+pl.getQNameR()+pl.getNameR()+" to ");
							WeaponStats(pl.getWeaponR());
							System.out.println(pl.getQNameR());
						}  else {
							System.out.println("  You don't have enough money!");
						}
					}
				} else {
					System.out.println("  Not a valid option. Enter '?' for help");
				}
            }
            else if (input.equalsIgnoreCase("leave") || input.equalsIgnoreCase("l")) {
                System.out.println("  The shopkeeper wishes you luck");
                
            } else {
                System.out.println("  Not a valid option. Enter '?' for help");
            }
            Delay();
        }
		shop = false;
    }  
    
    private static void GetLoot() {
        Random r = new Random();
		int wChance = r.nextInt(10)+1;
        if (wChance == 1) {
			findWeapon = true;
			System.out.println("");
            System.out.println("  You find a weapon!");
            Delay();
            WeaponTier();
			findWeapon= false;
        } else {
            int loot = (r.nextInt(11)+5) * level;
            if (isChest == true) {
                Delay();
                System.out.println("  you open the chest to see what's in it");
                pl.setCash(loot * 2);
                isChest = false;
                Delay();
            } else {
				System.out.println("");
			}
			
            System.out.println("  You find "+loot+" coins");
            Delay();
            pl.setCash(loot);
        }
    }
    
    private static void SetStats(Weapon w) {
        if(w.getType().equalsIgnoreCase("melee")) {
			pl.setDamageM(w.getDamage()); 
			pl.setSpecialM(w.getSpecial());
			pl.setNameM(w.getName());
			w.SendQualityNameM();
		} 
		else if(w.getType().equalsIgnoreCase("ranged")) {
			pl.setDamageR(w.getDamage()); 
			pl.setNewAmmo(w.getSpecial());
			pl.setMaxAmmo(w.getSpecial());
			pl.setNameR(w.getName());
			w.SendQualityNameR();
			reloadCost = weaponCost/2;
			if (reloadCost < 10) {
				reloadCost = 10;
			}
		}
		else if (w.getType().equalsIgnoreCase("magic")) {
			pl.giveSpell(w.getName());
		}
    }
    
    private static void GetStats(Weapon w) {
		if (findWeapon == true) {
			w.newWeapon();
		}
        Scanner s = new Scanner(System.in);
        String input = "";
		int localPlDamage = 0;
		int localPlSpecial = 0;
		String localPlName = "";
		String localPlQName = "";
		int localWDamage = w.getDamage();
		int localWSpecial = w.getSpecial();
		String localWName = w.getName();
		String localWQName = w.qualityN;
		String specialType = "  Speed: ";
		String damageType = "  Damage: ";
		String showAmmo = "";
		String quality = "Quality: ";
		boolean compare = true;
		int cost = weaponCost * weaponCostMult;
		
        if (changeW == true) { //automatic weapon change
            w.newWeapon();
            SetStats(w);
			changeW = false;
			return;
        } 
        if (wGen == true) {
            shopW = w;
			return;
        }
		if (w.getType().equalsIgnoreCase("ranged") && pl.getWeaponR() != -1) {
			//change ranged weapon
			localPlDamage = pl.getDamageR(); 
			localPlSpecial = pl.getMaxAmmo();
			localPlName = pl.getNameR();
			localPlQName = pl.getQNameR();
			specialType = "  Max Ammo: ";
			showAmmo = "  Current Ammo: ";
		}  
		if (w.getType().equalsIgnoreCase("melee")) {
			//change melee weapon
			localPlDamage = pl.getDamageM(); 
			localPlSpecial = pl.getSpecialM();
			localPlName = pl.getNameM();
			localPlQName = pl.getQNameM();
		}
		if (w.getType().equalsIgnoreCase("magic")) {
			//buy magic weapon
			localWDamage = w.getBaseDamage();
			specialType = "  Mana Cost: ";
			damageType = "  Base Damage: ";
			compare = false;
		}
        if (shop == true) {
			if (compare == true) {
				System.out.println("");
				System.out.println("  Current Weapon:");
				System.out.println("  Name: "+localPlName);
				System.out.println("  Quality: "+localPlQName);
				System.out.println("  Damage: "+localPlDamage); 
				System.out.println(   specialType+localPlSpecial);
				if (w.getType().equalsIgnoreCase("ranged") && pl.getWeaponR() != -1) {
					System.out.println(   showAmmo+pl.getAmmo());
				}
			}
            System.out.println("");
            System.out.println("  New Weapon:");
            System.out.println("  Name: "+localWName);
			if (!w.getType().equalsIgnoreCase("magic")) {
				System.out.println("  Quality: "+localWQName);
			}
            System.out.println(   damageType+localWDamage); 
            System.out.println(   specialType+localWSpecial);
            System.out.println("");
            System.out.println("  Cost: "+cost);
            System.out.println("  Balance: "+pl.getCash());
            System.out.println("");
            System.out.println("  Do you want to buy this weapon?");
            System.out.println("  ===============================");
            System.out.println("        [Yes]        [No]");
            System.out.print("  ");
            input = s.nextLine();
            System.out.println("");
            
            if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")) {
                if (pl.getCash() >= cost) {
                    if (compare == false) {
						System.out.println("  You learn "+localWName);
					} else {
						System.out.println("  You swap out your weapon for a "+localWQName+localWName);
                    }
                    pl.setCash(-cost);
                    SetStats(w);
                } else {
                    System.out.println("  You don't have enough money!");
                }
            }
            else if (input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n")) {
                System.out.println("  You keep your current weapon");
            } else {
                System.out.println("  Not a valid option. Enter '?' for help");
            }
        } 
        if (findWeapon == true) { //if you find the weapon
            while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("no") && !input.equalsIgnoreCase("n")) {
                if (compare == true) {
					System.out.println("  Current Weapon:");
					System.out.println("  Name: "+localPlName);
					System.out.println("  Quality: "+localPlQName);
					System.out.println("  Damage: "+localPlDamage); 
					System.out.println(   specialType+localPlSpecial);
					if (w.getType().equalsIgnoreCase("ranged")) {
						System.out.println(   showAmmo+pl.getAmmo());
					}
				}
                System.out.println("");
                System.out.println("  New Weapon:");
                System.out.println("  Name: "+localWName);
                if (!w.getType().equalsIgnoreCase("magic")) {
					System.out.println("  Quality: "+localWQName);
				}
                System.out.println(   damageType+localWDamage); 
                System.out.println(   specialType+localWSpecial);
                System.out.println("");
                System.out.println("  Do you want to change your weapon?");
                System.out.println("  ==================================");
                System.out.println("           [Yes]        [No]");    
                System.out.print("  ");
                input = s.nextLine();
                System.out.println("");
                
                if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")) {
                    if (compare == false) {
						System.out.println("  You learn "+localWName);
					} else {
						System.out.println("  You swap out your weapon for a "+localWQName+localWName);
                    }
                    SetStats(w);
                }
                else if (input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n")) {
                    System.out.println("  You keep your current weapon");
                } else {
                    System.out.println("  Not a valid option. Enter '?' for help");
                }
                System.out.println("");
            }
        }
    }
    
    private static void WeaponTier() {
        //only selects weapon up to + including current level
        Random r = new Random();
        int tier = 5;
        while (tier > 3) {
            tier = r.nextInt(level)+1;
        }
        int w;
        switch (tier) {
            default: w = r.nextInt(12)+1; break;
            case 2: w = r.nextInt(12)+13; break;
            case 3: w = r.nextInt(12)+25; break;
        }
		weaponCost = tier * 10;
		WeaponStats(w);
    }
    
    private static void WeaponStats(int Id) {
        //weapon list
        switch (Id) {
            //Melee weapons T1
            default:GetStats(dagger); break;
            case 2:GetStats(sword); break;
            case 3:GetStats(axe); break;
            case 4:GetStats(shank); break;
            case 5:GetStats(spear); break;
            case 6:GetStats(wristBlades); break;
            case 7:GetStats(cutlass); break;
            case 8:GetStats(club); break;
            //Ranged weapons T1
            case 9:GetStats(shortbow); break;
            case 10:GetStats(shurikan); break;
            case 11:GetStats(sling); break;
            case 12:GetStats(dartGun); break;
			//Melee weapons T2
            case 13:GetStats(mace); break;
            case 14:GetStats(quarterstaff); break;
            case 15:GetStats(greatsword); break;
            case 16:GetStats(pike); break;
            case 17:GetStats(flail); break;
            //Ranged weapons T2
            case 18:GetStats(longbow); break;
            case 19:GetStats(crossbow); break;
            case 20:GetStats(javelin); break;
            case 21:GetStats(tomahawk); break;
            //Magic weapons T2
            case 22:GetStats(flame); break;
            case 23:GetStats(lightning); break;
            case 24:GetStats(frost); break;
			//Melee weapons T3
            case 25: GetStats(warHammer); break;
            case 26:GetStats(battleAxe); break;
            case 27:GetStats(morningstar); break;
            case 28:GetStats(warScythe); break;
            //Ranged weapons T3
            case 29:GetStats(magicStaff); break;
            case 30:GetStats(compoundBow); break;
            case 31:GetStats(rCrossbow); break;
            //Magic weapons T3
            case 32:GetStats(sapping); break;
            case 33:GetStats(aura); break;
            case 34:GetStats(speed); break;
            case 35:GetStats(channel); break;
            case 36:GetStats(fireWall); break;
        }
    }
    
    private static void EnemyGen(int Id) {//enemy Id list
	enId = Id;
        switch (Id) {
                 //Battle(Enemy base stats, skeleton health)
            case 0:Battle(skeleton, 15); break;
            case 1:Battle(spider, 12); break;
            case 2:Battle(troll, 20); break;      
            case 3:Battle(snake, 6); break;             
            case 4:Battle(necromancer, 16); break;              
            case 5:Battle(wizard, 19); break;  
            case 6:Battle(skeletonArcher, 15); break;  
            case 7:Battle(goblin, 10); break;  
            case 8:Battle(outlaw, 15); break;  
            case 9:Battle(caveRat, 7); break;  
            case 10:Battle(wraith, 15); break;  
            case 11:Battle(zealot, 13); break;  
            case 12:Battle(demon, 16); break;  
            case 13:Battle(dragon, 29); break;  
            case 14:Battle(orc, 17); break;  
            case 15:Battle(vampire, 14); break;  
            case 16:Battle(leviathan, 28); break; 
            case 17:Battle(pixie, 9); break; 
            case 18:Battle(harpy, 11); break; 
            case 19:Battle(fallenHero, 16); break; 
            case 20:Battle(guardian, 18); break; 
            case 21:Battle(carnPlant, 12); break; 
            case 22:Battle(giant, 21); break; 
            case 23:Battle(looter, 14); break; 
            case 24:Battle(wyvern, 20); break; 
            case 25:Battle(cursedSoul, 17); break; 
            case 26:Battle(fElemental, 16); break; 
            case 27:Battle(wElemental, 16); break; 
            case 28:Battle(eElemental, 16); break; 
            case 29:Battle(aElemental, 16); break; 
            case 30:Battle(basilisk, 25); break; 
            case 31:Battle(golem, 18); break; 
            case 32:Battle(mimic, 13); break;
            case 33:Battle(manticore, 15); break;
            case 34:Battle(draugr, 16); break;
            case 35:Battle(legion, 12); break;
            case 36:Battle(griffin, 14); break;
            case 37:Battle(arvin, 1); break;
        }
    }
    
    private static int EnemyId(int[] enArr) {
        Random r = new Random();
        int Id = r.nextInt(enArr.length);
        return enArr[Id];
    }
    
    private static void Examine(int Id) {
		System.out.println("");
        switch (Id) {
			case -1:System.out.println("  You are currently alone"); break;
            case 0: System.out.println("  The skelton grins fearsomely at you, rage somehow evident in it's rigid bones.");
					System.out.println("  Tier: 1    Damage: medium   Speed: fast"); 
					System.out.println(""); break;
			case 1: System.out.println("  Deep in the dungeons, spiders are said to grow to gargantuan sizes. This one does not dissapoint.");
					System.out.println("  Tier: 1    Damage: medium   Speed: fast"); 
					System.out.println(""); break;
			case 2: System.out.println("  Cave trolls are mindless and savage, easily bent by the will of a powerful master to exact terrible destruction.");
					System.out.println("  Tier: 2    Damage: high   Speed: very slow"); 
					System.out.println(""); break;
			case 3: System.out.println("  This ancient and powerful snake has lived through the ages in darkness, devouring any who happen upon it.");
					System.out.println("  Tier: 1    Damage: low   Speed: very fast"); 
					System.out.println(""); break;
			case 4: System.out.print  ("  Necromancers are the most despised of all magicians, performing the darkest magics on the deceased to ");
					System.out.println("  bend into their undying slaves.");
					System.out.println("  Tier: 2    Damage: high   Speed: average"); 
					System.out.println(""); break;
			case 5: System.out.println("  The wizards who dwell here have been overpowered and corrupted by the evil magic of the dungeon");
					System.out.println("  Tier: 3    Damage: very high   Speed: average"); 
					System.out.println(""); break;
			case 6: System.out.println("  This reanimated skeleton is not very different from others, other than it's use of a bow");
					System.out.println("  Tier: 1    Damage: medium   Speed: average"); 
					System.out.println(""); break;
			case 7: System.out.println("  Perhaps the most infamous of foes, the goblin "); 
					System.out.println("  Tier: 2    Damage: high   Speed: average"); 
					System.out.println(""); break;
			case 8: System.out.println("  Out of options, this doomed outlaw has fled into the dungeon to escape justice"); 
					System.out.println("  Tier: 1    Damage: average   Speed: average"); 
					System.out.println(""); break;
		    case 9: System.out.println("  The cave rat is the size of a small dog, it's shark-like eyes fixated on you with hunger "); 
					System.out.println("  Tier: 1    Damage: low   Speed: very fast"); 
					System.out.println(""); break;
	        case 10: System.out.println("  This undead spectre seems to stare through your very soul "); 
					System.out.println("  Tier: 3    Damage: high   Speed: fast"); 
					System.out.println(""); break;
			case 11: System.out.println("  The Zealot looks you over, ready to battle to the death "); 
					System.out.println("  Tier: 2    Damage: high   Speed: average"); 
					System.out.println(""); break;
			case 12: System.out.println("  The hellish demon is the very embodiment of damnation, and possesses the devastating power of the underworld "); 
					System.out.println("  Tier: 3    Damage: very high   Speed: average"); 
					System.out.println(""); break;
			case 13: System.out.println("  This towering beast smells of smoke and burning flesh, The ultimate foe of any hero "); 
					System.out.println("  Tier: 3    Damage: devastating   Speed: slow"); 
					System.out.println(""); break;
			case 14: System.out.println("  With tusks petruding through its lips, this orc brandishes it's weapon at you roars"); 
					System.out.println("  Tier: 2    Damage: high   Speed: average"); 
					System.out.println(""); break;
			case 15: System.out.println("  A fanged foe that can smell the blood running through your veins "); 
					System.out.println("  Tier: 2    Damage: high   Speed: average"); 
					System.out.println(""); break;
			case 16: System.out.println("  The most feared enemy of any fleet, you can only guess at it's massive length concealed beneath the water"); 
					System.out.println("  Tier: 3    Damage: very high   Speed: slow"); 
					System.out.println(""); break;
			case 17: System.out.println("  A small but speedy flying being, it's size belies it's ferocity"); 
					System.out.println("  Tier: 1    Damage: low   Speed: very fast"); 
					System.out.println(""); break;
			case 18: System.out.println("  This hideous winged creature looks like a human, but for the massive wings in place of arms and hooked claws for feet"); 
					System.out.println("  Tier: 1    Damage: medium   Speed: fast"); 
					System.out.println(""); break;
			case 19: System.out.println("  Once a valiant warrier in your position, its unnatural ressurection has poisioned its mind"); 
					System.out.println("  Tier: 2    Damage: high   Speed: average"); 
					System.out.println(""); break;
			case 20: System.out.println("  The noble Guardian, a stone creation fueled by magic, created to protect and guard"); 
					System.out.println("  Tier: 3    Damage: very high   Speed: slow"); 
					System.out.println(""); break;
			case 21: System.out.println("  Deep in the dungeon, this plant has adapted to survive, growing to gargantuan sizes and turning it's appetite to meat"); 
					System.out.println("  Tier: 1    Damage: medium   Speed: average"); 
					System.out.println(""); break;
			case 22: System.out.println("  The lumbering giant makes up for its low intellegence with brute strength and endurance"); 
					System.out.println("  Tier: 2    Damage: high   Speed: slow"); 
					System.out.println(""); break;
			case 23: System.out.println("  Rummaging for the gold and treasures of the deceased, he sees you as just another body to loot"); 
					System.out.println("  Tier: 1    Damage: medium   Speed: average"); 
					System.out.println(""); break;
			case 24: System.out.println("  This dragon-like creature is blood-thirsty and enraged "); 
					System.out.println("  Tier: 3    Damage: very high   Speed: slow"); 
					System.out.println(""); break;
			case 25: System.out.println("  An aggrevated spirit condemned to spend eternity roaming this dungeon "); 
					System.out.println("  Tier: 1    Damage: medium   Speed: average"); 
					System.out.println(""); break;
			case 26: System.out.println("  This elemental bears the power of pure fire and destruction "); 
					System.out.println("  Tier: 3    Damage: very high   Speed: average"); 
					System.out.println(""); break;
			case 27: System.out.println("  This elemental bears the power of the seven seas"); 
					System.out.println("  Tier: 3    Damage: very high   Speed: average"); 
					System.out.println(""); break;
			case 28: System.out.println("  This elemental bears the power of earth and soil "); 
					System.out.println("  Tier: 2    Damage: high   Speed: average"); 
					System.out.println(""); break;
			case 29: System.out.println("  This elemental bears the power of air, and tempests "); 
					System.out.println("  Tier: 2    Damage: high   Speed: average"); 
					System.out.println(""); break;
			case 30: System.out.println("  The basilisk's fangs drip with deadly venom, an unnering intelligence in it's eyes"); 
					System.out.println("  Tier: 3    Damage: very high   Speed: slow"); 
					System.out.println(""); break;
			case 31: System.out.println("  The golem is an ancient machination powered by some unknown source"); 
					System.out.println("  Tier: 2    Damage: high   Speed: slow"); 
					System.out.println(""); break;
			case 32: System.out.println("  The mimic can morph into any shape. This one concealed itself as a chest"); 
					System.out.println("  Tier: 1    Damage: average   Speed: average"); 
					System.out.println(""); break;
			case 33: System.out.println("  Part bat, lion and scorpion, the manticore makes for a deadly foe "); 
					System.out.println("  Tier: 2    Damage: high   Speed: average"); 
					System.out.println(""); break;
			case 34: System.out.println("  This terrifying being is more powerful after death "); 
					System.out.println("  Tier: 2    Damage: high   Speed: average"); 
					System.out.println(""); break;
			case 35: System.out.println("  A grotesque mound of hideous flesh, covered in eyes, mouths, and flailing arms, grasping for you"); 
					System.out.println("  Tier: 1    Damage: medium   Speed: slow"); 
					System.out.println(""); break;
			case 36: System.out.println("  The griffin is a magestic beast, part eagle and part horse. Unfortunatly, this one has taken offence to your presence"); 
					System.out.println("  Tier: 2    Damage: high   Speed: slow"); 
					System.out.println(""); break;
			case 37: System.out.println("  You don't think this guy does anything... "); 
					System.out.println("  Tier: -5000    Damage: none   Speed: none (he just stands)"); 
					System.out.println(""); break;
			//... on and on it goes.
            default:System.out.println("  It's Gabriels fault this enemy doesn't have a description yet. Shame on you Garbriel you lazy butt."); break;
        }
    }
    private static void RoomGen(int Id) {   
        int enArr[];
        int enemyId;
        //only selects weapon up to + including current level
        Random t = new Random();
        int tier = 5;
        while (tier > 3) {
            tier = t.nextInt(level)+1;
        }
        switch(Id) {
            //decide tier of enemy here or up there ^
            case 1: System.out.println("  You enter a crypt, probably once connected to a catacomb");
                    switch(tier) {
						//each case reflects different tier enemy spawns
                        default: enArr = new int[]{0,1,3,7,9,17,18,23,25,32 }; break;
                        case 2:  enArr = new int[]{2,4,6,11,14,15,20,31}; break;
                        case 3:  enArr = new int[]{5,12,20,30}; break;
                    }
                    enemyId = EnemyId(enArr);
                    EnemyGen(enemyId); break;
            case 2: System.out.println("  You find yourself in a massive cavern");
                    switch(tier) {
                        default: enArr = new int[]{0,1,3,4,7,9,17,18,23,25}; break;
                        case 2:  enArr = new int[]{2,6,11,14,15,19,22,31}; break;
                        case 3:  enArr = new int[]{10,12,13,16,24,30}; break;
                    }
                    enemyId = EnemyId(enArr);
                    EnemyGen(enemyId); break;
            case 3: System.out.println("  A long corridor stretches before you"); 
                    switch(tier) {
                        default: enArr = new int[]{0,1,3,9,17,23}; break;
                        case 2:  enArr = new int[]{2,6,8,11,14,15,31,34}; break;
                        case 3:  enArr = new int[]{5,10,20}; break;
                    }
					enemyId = EnemyId(enArr);
                    EnemyGen(enemyId); break;
            case 4: System.out.println("  An alter to some unknown deity stands wreathed in shadow");     
                    switch(tier) {
                        default: enArr = new int[]{0,1,21,25,35}; break;
                        case 2:  enArr = new int[]{11,28,29,31,33,34,36}; break;
                        case 3:  enArr = new int[]{10,12,13,16,20,24,26,27,30}; break;
                    }
                    enemyId = EnemyId(enArr);
                    EnemyGen(enemyId); break;
            case 5: System.out.println("  It seems you have stumbled upon a mass grave"); 
                    switch(tier) {
                        default: enArr = new int[]{0,1,3,21,23,25,35}; break;
                        case 2:  enArr = new int[]{4,6,15,19}; break;
                        case 3:  enArr = new int[]{5,10,12,26,27}; break;
                    }
                    enemyId = EnemyId(enArr);
                    EnemyGen(enemyId); break;
            case 6: System.out.println("  Shelves full of exotic potions and illegible tomes surround you"); 
                    switch(tier) {
                        default: enArr = new int[]{0,1,3,7,9,17,18,23}; break;
                        case 2:  enArr = new int[]{2,6,19,28,29}; break;
                        case 3:  enArr = new int[]{5,10,26,27}; break;
                    }
                    enemyId = EnemyId(enArr);
                    EnemyGen(enemyId); break;
            case 7: System.out.println("  An evil darkness lurks in the corners of the room"); 
                    switch(tier) {
                        default: enArr = new int[]{0,1,7,25,35}; break;
                        case 2:  enArr = new int[]{2,4,6,11,14,15,19,22,31}; break;
                        case 3:  enArr = new int[]{10,12,20}; break;
                    }
                    enemyId = EnemyId(enArr);
                    EnemyGen(enemyId); break;
            case 8: System.out.println("  Thick threads of spider silk coat the ceiling and walls around you"); 
                    enArr = new int[]{1}; //spider
                    enemyId = EnemyId(enArr);
                    EnemyGen(enemyId); break;
            case 9: System.out.println("  The floor is littered with eggs. It seems to be a nest of some sort"); 
                    switch(tier) {
                        default: enArr = new int[]{1,3}; break;
                        case 2:  enArr = new int[]{34,36}; break;
                        case 3:  enArr = new int[]{12,16,24,30}; break;
                    }
                    enemyId = EnemyId(enArr);
                    EnemyGen(enemyId); break;
            case 10:System.out.println("  You enter an unremarkable little cave, recently inhabited..."); 
                    switch(tier) {
                        default: enArr = new int[]{0,1,3,7,9,23,37}; break;
                        case 2:  enArr = new int[]{2,6,8,11,14,15,22,31,33,34}; break;
                        case 3:  enArr = new int[]{5,13,20,24,30}; break;
                    }
                    enemyId = EnemyId(enArr);
                    EnemyGen(enemyId); break;
            case 11:System.out.println("  In the darkness you barely avoid falling into the underground lake in front of you");
                    switch(tier) {
                        default: enArr = new int[]{0,7,17,18,21,23}; break;
                        case 2:  enArr = new int[]{2,6,8,11,14,19,22,28,29,31}; break;
                        case 3:  enArr = new int[]{16,20,24,27,30}; break;
                    }
                    enemyId = EnemyId(enArr);
                    EnemyGen(enemyId); break;
            case 12:System.out.println("  Bones and other, fresher, remains, lay on the floor, surrounding a dark crevice in the wall"); 
                    switch(tier) {
                        default: enArr = new int[]{0,1,3,7,9,21,25}; break;
                        case 2:  enArr = new int[]{4,6,8,11,14,15,19,22,36}; break;
                        case 3:  enArr = new int[]{10,12,20,24}; break;
                    }
                    enemyId = EnemyId(enArr);
                    EnemyGen(enemyId); break;
            case 13:System.out.println("  Strange symbols cover all this room's surfaces"); 
                    switch(tier) {
                        default: enArr = new int[]{0,7,23,25,35}; break;
                        case 2:  enArr = new int[]{4,8,11,15,28,29}; break;
                        case 3:  enArr = new int[]{5,10,12,20,26,27}; break;
                    }
                    enemyId = EnemyId(enArr);
                    EnemyGen(enemyId); break;
            case 14:System.out.println("  It looks like there was once a forge here"); 
                    switch(tier) {
                        default: enArr = new int[]{0,1,3,7,23,31}; break;
                        case 2:  enArr = new int[]{2,6,8,11,19}; break;
                        case 3:  enArr = new int[]{5,10,26,27}; break;
                    }
                    enemyId = EnemyId(enArr);
                    EnemyGen(enemyId); break;
            case 15:System.out.println("  Rusted weapons and armour lay abandoned around you"); 
                    switch(tier) {
                        default: enArr = new int[]{0,7,23,25}; break;
                        case 2:  enArr = new int[]{2,6,8,14,19,22,31}; break;
                        case 3:  enArr = new int[]{5,10,13,20,24}; break;
                    }
                    enemyId = EnemyId(enArr);
                    EnemyGen(enemyId); break;
            case 16:System.out.println("  The ground before you falls away into a seemingly endless abyss"); 
                    switch(tier) {
                        default: enArr = new int[]{0,1,3,9,21,25}; break;
                        case 2:  enArr = new int[]{2,6,14,22,31,33,36}; break;
                        case 3:  enArr = new int[]{10,16,20,24,30}; break;
                    }
                    enemyId = EnemyId(enArr);
                    EnemyGen(enemyId); break;
            case 17:System.out.println("  The air around you suddenly cools"); 
                    switch(tier) {
                        default: enArr = new int[]{17,18,25,35}; break;
                        case 2:  enArr = new int[]{19,28,29,36}; break;
                        case 3:  enArr = new int[]{5,10,12,27}; break;
                    }
                    enemyId = EnemyId(enArr);
                    EnemyGen(enemyId); break;
            case 18:System.out.println("  In front of you is a once-great statue of some forgotten king"); 
                    switch(tier) {
                        default: enArr = new int[]{0,1,3,7,23}; break;
                        case 2:  enArr = new int[]{2,4,8,11,14,19,34}; break;
                        case 3:  enArr = new int[]{5,10,20}; break;
                    }
                    enemyId = EnemyId(enArr);
                    EnemyGen(enemyId); break;
            case 19:System.out.println("  A thick mist gathers around your feet"); 
                    switch(tier) {
                        default: enArr = new int[]{0,1,17,18,25,35}; break;
                        case 2:  enArr = new int[]{6,11,15,19,28,29,33,34}; break;
                        case 3:  enArr = new int[]{10,12,24,26,27}; break;
                    }
                    enemyId = EnemyId(enArr);
                    EnemyGen(enemyId); break;
            case 20:System.out.println("  You enter a mineshaft, long abandoned to rot and degradation"); 
                    switch(tier) {
                        default: enArr = new int[]{0,1,3,7,9,21,23}; break;
                        case 2:  enArr = new int[]{2,4,6,8,11,14,22,31,34}; break;
                        case 3:  enArr = new int[]{5,10,24,30}; break;
                    }
                    enemyId = EnemyId(enArr);
                    EnemyGen(enemyId); break;
            case 21:System.out.println("  You spot a chest placed discreetly in the corner"); //loot chest
                    isChest = true; 
					GetLoot(); break; 
            case 22:System.out.println("  You spot a chest placed discreetly in the corner"); //trap chest
                    enArr = new int[]{32}; //mimic
                    enemyId = EnemyId(enArr);
                    EnemyGen(enemyId); break; 
            case 23:System.out.println("  A portal to some dark world opens in front of you"); 
                    switch(tier) {
                        default: enArr = new int[]{25,35}; break;
                        case 2:  enArr = new int[]{28,29}; break;
                        case 3:  enArr = new int[]{10,12,26,27}; break;
                    }
                    enemyId = EnemyId(enArr);
                    EnemyGen(enemyId); break;
            case 24:System.out.println("  The floor is littered with the old bodies of would-be heroes"); 
                    switch(tier) {
                        default: enArr = new int[]{0,1,21,23}; break;
                        case 2:  enArr = new int[]{2,6,8,11,14,15,19,22,31,33,34,36}; break;
                        case 3:  enArr = new int[]{10,13,20,24,30}; break;
                    }
                    enemyId = EnemyId(enArr);
                    EnemyGen(enemyId); break;
            case 25:System.out.println("  The doorway to this room has strange runes scrawled across it - probably a warning"); 
                    switch(tier) {
                        default: enArr = new int[]{0,1,7,17,18,25}; break;
                        case 2:  enArr = new int[]{2,4,6,11,14,28,29,34}; break;
                        case 3:  enArr = new int[]{10,12,13,20,24,26,27,30}; break;
                    }
                    enemyId = EnemyId(enArr);
                    EnemyGen(enemyId); break;
            case 26:System.out.println("  A shopkeeper sits looking somewhat bored at his stall");
                    Delay();
                    Shop(); break;
        }
    }
}