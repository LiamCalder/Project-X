import java.util.*;
//import javax.swing.*;

public class dungeon {
	//initialize Variables
	int maxQuality = 1; //highest weapon tier that can be generated. Note enemies are also affected by tiers
	
	//initialise Classes
	//Player and enemy class
	static Player pl = new Player();
	
	//Melee weapons
    static Weapon dagger         = new Melee("Dagger", 7, 8);            
    static Weapon sword          = new Melee("Sword", 10, 6);             
	static Weapon mace           = new Melee("Mace", 12, 3);		        
    static Weapon axe            = new Melee("Axe", 11, 4);		        
    static Weapon warHammer      = new Melee("War Hammer", 14, 3);        
	static Weapon quarterstaff   = new Melee("Quarterstaff", 8, 7);      
	static Weapon greatsword     = new Melee("Greatsword", 13, 3);	    
    static Weapon shank          = new Melee("Shank", 7, 7);		        
    static Weapon spear          = new Melee("Spear", 10, 6);		        
    static Weapon wristBlades    = new Melee("Wrist Blades", 8, 7);       
	static Weapon claymore       = new Melee("Claymore", 15, 2);          
    static Weapon morningstar    = new Melee("Morningstar", 14, 3);       
    static Weapon pike           = new Melee("Pike", 13, 5);              
    static Weapon cutlass        = new Melee("Cutlass", 11, 5);           
    static Weapon chain          = new Melee("Chain", 12, 3);		        
    static Weapon ballChain      = new Melee("Ball and Chain", 16, 1);      
	static Weapon warScythe      = new Melee("War Scythe", 12, 5);        
			
	//Ranged weapons
    static Weapon shortbow       = new Ranged("Shortbow", 10, 7);         
    static Weapon longbow        = new Ranged("Longbow", 10, 5);          
    static Weapon shurikan       = new Ranged("Shurikan", 10, 8);         
	static Weapon crossbow       = new Ranged("Crossbow", 10, 3);
    static Weapon magicStaff     = new Melee("Magic Staff", 14, 4); 	
           
	//Magic weapons
    static Weapon flame          = new Magic("Fireball", 10, 7);	        
    static Weapon lightning      = new Magic("Lightning Bolt", 10, 7);    
    static Weapon frost          = new Magic("Ice Beam", 10, 7);          
    static Weapon sapping        = new Magic("Drain Speed", 10, 7);       
    static Weapon aura           = new Magic("Defensive Aura", 10, 10);    
    static Weapon speed          = new Magic("Swiftness", 10, 10);         
    static Weapon shift          = new Magic("Dimensional Shift", 10, 10); 
    static Weapon fireWall       = new Magic("Wall Of Fire", 10, 10);      
	
	//Enemies
	static Weapon skeleton         = new Melee("Skeleton", 10, 7);           
    static Weapon spider           = new Melee("Spider", 6, 8);             
    static Weapon troll            = new Melee("Troll", 14, 2);              
    static Weapon snake            = new Melee("Snake", 5, 8);              
    static Weapon necromancer      = new Magic("Necromancer", 12, 5);        
    static Weapon wizard           = new Magic("Wizard", 13, 5);             
    static Weapon skeletonArcher   = new Ranged("Skeleton Archer", 9, 6);   
    static Weapon goblin           = new Melee("Goblin", 8, 7);             
    static Weapon outlaw           = new Melee("outlaw", 10, 6);             
    static Weapon caveRat          = new Melee("Cave Rat", 5, 8);           
    static Weapon wraith           = new Melee("Wraith", 13, 5);             
    static Weapon fanatic          = new Melee("Fantic", 12, 4);             
    static Weapon demon            = new Magic("Demon", 13, 5);              
    static Weapon dragon           = new Melee("Dragon", 16, 2);             
    static Weapon orc              = new Melee("Orc", 11, 4);                
    static Weapon vampire          = new Magic("Vampire", 12, 5);            
    static Weapon leviathan        = new Melee("Leviathan", 14, 3);          
    static Weapon pixie            = new Magic("Pixie", 6, 8);              
    static Weapon harpy            = new Melee("Harpy", 7, 7);              
    static Weapon fallenHero       = new Melee("Fallen Hero", 12, 5);        
    static Weapon guardian         = new Melee("Guardian", 14, 2);           
    static Weapon carnPlant        = new Melee("Carnivorous Plant", 9, 4);  
    static Weapon giant            = new Melee("Giant", 11, 2);              
    static Weapon looter           = new Melee("Looter", 8, 6);             
    static Weapon wyrm             = new Melee("Wyrm", 13, 3);               
    static Weapon cursedSoul       = new Melee("Cursed Soul", 10, 4);        
    static Weapon fElemental       = new Ranged("Fire Elemental", 12, 5);    
    static Weapon wElemental       = new Ranged("Water Elemental", 12, 5);   
    static Weapon eElemental       = new Ranged("Earth Elemental", 12, 5);   
    static Weapon aElemental       = new Ranged("Air Elemental", 12, 5);     
    static Weapon basilisk         = new Melee("Basilisk", 14, 3);           
    static Weapon golem            = new Melee("Rock Golem", 13, 2);         
    static Weapon mimic            = new Melee("Mimic", 11, 4);
	
    public static void main(String[] args) {
        //set up beginning of game
		Scanner s = new Scanner(System.in);
		int weapon = pl.getWeapon(); //gives Player class weapon info from the get go
		WeaponStats(weapon);
		
        System.out.println("");
        System.out.println("  Do you want to enter The Dungeon?");
        System.out.println("  =================================");
        System.out.println("  [Start] [Quit] [Help] [Controls]");
        String input = "";
        while (!input.equalsIgnoreCase("start")) {
            //option select
            System.out.print("  ");
            input = s.nextLine();
            if (input.equalsIgnoreCase("start")) {
                LevelChain(null);//level method
            }
            else if (input.equalsIgnoreCase("quit")) {
                System.exit(1);
            }
            else if (input.equalsIgnoreCase("controls")) {
                Controls(null);
                System.out.println("");
                System.out.println("  Do you want to enter The Dungeon?");
                System.out.println("  =================================");
                System.out.println("  [Start] [Quit] [Help] [Controls]");
            }
            else {
                Help(null);
                System.out.println("");
                System.out.println("  Do you want to enter The Dungeon?");
                System.out.println("  =================================");
                System.out.println("  [Start] [Quit] [Help] [Controls]");
            }
        }
        
    }
    
    private static void LevelChain(String[] args) {
        System.out.println("");
        System.out.println("  You descend the stairs...");
                
        Delay(null); //make game wait for user
        Random r = new Random();
        int vary = r.nextInt(3)+4; //variation on number of levels
        int roomArr[] = new int[vary]; //create array of vary length
        for (int i=0; i<vary; i++) {
            //call RoomId and grab Id
            int checkRoomId = -1;
            int roomId = RoomId(checkRoomId);
            boolean isDup = isDuplicate(roomArr, roomId); //check for duplicates
            if (isDup == true) {
                i--;
            }
            else {
                roomArr[i] = roomId; //if no dupes, add Id to array and execute room
                RoomGen(roomId);
            }
        }
		
		NextLevel(null);
        
        //outputs to JFrame instead of console
        /*JFrame f = new JFrame("ASCII");
        JLabel l = new  JLabel("room");
        l.setBounds(300,100,100,100);
        f.add(l);
        f.setSize(101,101);
        f.setLayout(null);
        f.setVisible(true);*/
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
    
    private static void Help(String[] args) {
        System.out.println("");
        System.out.println("  To correctly select an option, type");
        System.out.println("  exactly what is in the square brackets");
        System.out.println("  E.g. [Start] type 'start', or [i] type");
        System.out.println("  'i'. A pause can be identified as a non-");
        System.out.println("  indented input promt, which is continued ");
        System.out.println("  by pressing 'Enter'. Indented requires an ");
        System.out.println("  option to be selected. enter '?' for this menu");
        Delay(null);
    }
    
    private static void Controls(String[] args) {
        System.out.println("");
        System.out.println("  To select option: type whatevers in [here]");
        System.out.println("  i = inventory");
        System.out.println("  m = map");
        System.out.println("  s = stats");
        System.out.println("");
        System.out.println("  note: only stats  works at this stage of the program");
        System.out.println("  They may or may not be implemented later on");
        Delay(null);
    }
    
    private static void NextLevel(String[] args) {
        //This method will bump up enemy stats, loot spawns etc
		System.out.println("  You find a staircase leading deeper into the dungeon");
		LevelChain(null); //then restart LevelChain
    }
    
    public static void Delay(String[] args) {//wait for user function
        Scanner s = new Scanner(System.in);
        String delay = s.nextLine();
        if (delay.equalsIgnoreCase("?")) {
            Help(null);
        }
		if (delay.equalsIgnoreCase("quit")) {
			System.exit(1);
		}
    }

    private static int RoomId(int roomId) { //room Id list
        Random r = new Random();
        roomId = r.nextInt(31)+1; //update with new room cases
        //change max random number to change shop spawn chance (E.g. 15 cases (rooms), max ran 20 = 1:4 spawn ratio)
        if (roomId > 25) {
            roomId = 26; //give shops one Id
        }
        return roomId; //pass RoomId back to Caller
    }
    
    private static int EnemyId(int[] enArr) {
        Random r = new Random();
        int Id = r.nextInt(enArr.length);
        return enArr[Id];
    }
    
	private static void Battle(Weapon e, int h) {
		Enemy en = new Enemy();
		en.setHealth(h); //set enemy health
		int w = pl.getWeapon(); //get weapon Id
		WeaponStats(w); //get weapon stats
		Delay(null);
		System.out.println("  A " + e.getName() + " appears!");
		Delay(null);
		
		while (en.getHealth() > 0) {
			Scanner s = new Scanner(System.in);
			
		    //debug stats
			/*System.out.println("  Enemy Stats: ");
			System.out.println("  Damage = "+e.getDamage());
			System.out.println("  Speed = "+e.getSpeed());
			System.out.println("  Health = "+en.getHealth());
			System.out.println("");
			System.out.println("  Your Stats: ");
			System.out.println("  Damage = "+pl.getDamage());
			System.out.println("  Speed = "+pl.getSpeed());
			System.out.println("  Health = "+pl.getHealth());
			*/
			System.out.println("  What will you do?");
			System.out.println("  =================");
			System.out.println("  [Weapon] | [Spell]");
			System.out.println("  - - - - - - - - -");
			System.out.println("  [Health] | [Mana]");
			
			System.out.print("  ");
			String input = s.nextLine();
			if (input.equalsIgnoreCase("weapon") || input.equalsIgnoreCase("w")) {
				enDodgeChance(e, en);
				if (en.isDead == true) {
					pl.addScore(100+h); //+100 for winning, + damage dealt
					return;
				}
				Delay(null);
				plDodgeChance(e);
			}
			else if (input.equalsIgnoreCase("spell") || input.equalsIgnoreCase("s")) {
				//attack with spell stats
				Delay(null);
				pl.hit(e);
			}
			else if (input.equalsIgnoreCase("health") || input.equalsIgnoreCase("h")) {
				//use health potion if availiable
				Delay(null);
				pl.hit(e);
			}
			else if (input.equalsIgnoreCase("mana") || input.equalsIgnoreCase("m")) {
				//use mana potion if availiable
				Delay(null);
				pl.hit(e);
			}
			else {
				System.out.println("  Not a valid option. Enter '?' for help");
			}
			
			Delay(null);
		}
    }
	
	private static void enDodgeChance(Weapon e, Enemy en) {
		//dodge chance is speedx4% chace, eg 6x4 = 24% chance
		//to dodge attack with max 40% (10x4) chance to dodge
		//to dodge score must be lower than target.
		Random r = new Random();
		int target = e.getSpeed() * 4;
		int score = r.nextInt(100)+1;
		
		if (score > target) {
			en.hit(e);
		} else {
			System.out.println("");
			System.out.println("  The "+e.getName()+" dodges your attack!");
		}
	}
	
	private static void plDodgeChance(Weapon e) {
		Random r = new Random();
		int target = e.getSpeed() * 4;
		int score = r.nextInt(100)+1;
		
		if (score < target) {
			pl.hit(e);
		} else {
			System.out.println("  You dodge the "+e.getName()+"'s attack!");
		}
	}
	
	private static void Shop(String[] args) {
		System.out.println("  Shop Stuff");
		Delay(null);
	}
	
	private static void GetStats(Weapon w) {
		pl.setDamage(w.getDamage()); 
		pl.setSpeed(w.speed);
		pl.setName(w.name);
		w.SendQualityName();
	}
	
	private static void WeaponStats(int Id) {
        //weapon list
        //spells will be learned from books, but will be balanced with limited mana/cooldowns etc
		switch (Id) {
			//Melee weapons
            case 1: GetStats(dagger); break;
            case 2: GetStats(sword); break;
			case 3: GetStats(mace); break;
            case 4: GetStats(axe); break;
            case 5: GetStats(warHammer); break;
			case 6: GetStats(quarterstaff); break;
			case 7: GetStats(greatsword); break;
            case 8: GetStats(shank); break;
            case 9: GetStats(spear); break;
            case 10:GetStats(wristBlades); break;
            case 11:GetStats(claymore); break;
			case 12:GetStats(morningstar); break;
            case 13:GetStats(pike); break;
            case 14:GetStats(cutlass); break;
            case 15:GetStats(chain); break;
            case 16:GetStats(ballChain); break;
			case 17:GetStats(warScythe); break;
            
			//Ranged weapons
            case 19:GetStats(shortbow); break;
            case 20:GetStats(longbow); break;
            case 21:GetStats(shurikan); break;
			case 22:GetStats(crossbow); break;
			case 23:GetStats(magicStaff); break;
           
		    //Magic weapons
            case 24:GetStats(flame); break;
            case 25:GetStats(lightning); break;
            case 26:GetStats(frost); break;
            case 27:GetStats(sapping); break;
            case 28:GetStats(aura); break;
            case 29:GetStats(speed); break;
            case 30:GetStats(shift); break;
            case 31:GetStats(fireWall); break;
        }
    }
	
    private static void EnemyGen(int Id) {//enemy Id list
        switch (Id) {
			     //Battle(Enemy base stats, skeleton health)
            case 0:Battle(skeleton, 20); break;
            case 1:Battle(spider, 15); break;
            case 2:Battle(troll, 40); break;      
            case 3:Battle(snake, 12); break; 			
            case 4:Battle(necromancer, 25); break;  			
            case 5:Battle(wizard, 23); break;  
            case 6:Battle(skeletonArcher, 18); break;  
            case 7:Battle(goblin, 22); break;  
            case 8:Battle(outlaw, 27); break;  
            case 9:Battle(caveRat, 14); break;  
            case 10:Battle(wraith, 26); break;  
            case 11:Battle(fanatic, 16); break;  
            case 12:Battle(demon, 30); break;  
            case 13:Battle(dragon, 50); break;  
            case 14:Battle(orc, 25); break;  
            case 15:Battle(vampire, 21); break;  
            case 16:Battle(leviathan, 45); break; 
            case 17:Battle(pixie, 10); break; 
            case 18:Battle(harpy, 17); break; 
            case 19:Battle(fallenHero, 29); break; 
            case 20:Battle(guardian, 25); break; 
            case 21:Battle(carnPlant, 19); break; 
            case 22:Battle(giant, 32); break; 
            case 23:Battle(looter, 20); break; 
            case 24:Battle(wyrm, 28); break; 
            case 25:Battle(cursedSoul, 23); break; 
            case 26:Battle(fElemental, 18); break; 
            case 27:Battle(wElemental, 18); break; 
            case 28:Battle(eElemental, 18); break; 
            case 29:Battle(aElemental, 18); break; 
            case 30:Battle(basilisk, 34); break; 
            case 31:Battle(golem, 37); break; 
            case 32:Battle(mimic, 22); break;
        }
    }
	
	private static void RoomGen(int Id) {   
        int enArr[];
        int enemyId;
        
        switch(Id) {
            case -1:System.out.println("  This should not appear. if it does, roomId wasn't called"); 
					enArr = new int[]{-1}; //numbers in curly brackets reperesents possible enemy spawns in room via Id#
					enemyId = EnemyId(enArr);
					EnemyGen(enemyId); break;
            case 1: System.out.println("  You enter a crypt, probably once connected to a catacomb");
					enArr = new int[]{0,4,6,19,23,25};
					enemyId = EnemyId(enArr);
					EnemyGen(enemyId); break;
            case 2: System.out.println("  You find yourself in a massive cavern"); 
					enArr = new int[]{1,2,7,13,17,18,22,29};
					enemyId = EnemyId(enArr);
					EnemyGen(enemyId); break;
            case 3: System.out.println("  A long corridor stretches before you"); 
					enArr = new int[]{1,3,9,15,17,20,31};
					enemyId = EnemyId(enArr);
					EnemyGen(enemyId); break;
            case 4: System.out.println("  An alter to some unknown deity stands wreathed in shadow");     
					enArr = new int[]{4,5,10,11,12,25};
					enemyId = EnemyId(enArr);
					EnemyGen(enemyId); break;
            case 5: System.out.println("  It seems you have stumbled upon a mass grave"); 
					enArr = new int[]{0,6,9,15,19,23};
					enemyId = EnemyId(enArr);
					EnemyGen(enemyId); break;
            case 6: System.out.println("  shelves full of exotic potions and illegible tomes surround you"); 
					enArr = new int[]{4,5,11,12,30};
					enemyId = EnemyId(enArr);
					EnemyGen(enemyId); break;
            case 7: System.out.println("  An evil darkness lurks in the corners of the room"); 
					enArr = new int[]{10,11,12,25};
					enemyId = EnemyId(enArr);
					EnemyGen(enemyId); break;
            case 8: System.out.println("  thick threads of spider silk coat the ceiling and walls around you"); 
					enArr = new int[]{1};
					enemyId = EnemyId(enArr);
					EnemyGen(enemyId); break;
            case 9: System.out.println("  The floor is littered with eggs. It seems to be a nest of some sort"); 
					enArr = new int[]{1,3,13,30};
					enemyId = EnemyId(enArr);
					EnemyGen(enemyId); break;
            case 10:System.out.println("  You enter an unremarable little cave, recently inhabited..."); 
					enArr = new int[]{2,5,7,8,11,14,15,23};
					enemyId = EnemyId(enArr);
					EnemyGen(enemyId); break;
            case 11:System.out.println("  In the darkness you barely avoid falling into the underground lake in front of you");
					enArr = new int[]{16,17,18,24,27,30};
					enemyId = EnemyId(enArr);
					EnemyGen(enemyId); break;
            case 12:System.out.println("  Bones and other, fresher, remains, lay on the floor, surrounding a dark crevice in the wall"); 
					enArr = new int[]{2,3,13,16,21,22,24,30};
					enemyId = EnemyId(enArr);
					EnemyGen(enemyId); break;
            case 13:System.out.println("  Strange symbols cover all this room's surfaces"); 
					enArr = new int[]{4,5,11,12,15,20,25};
					enemyId = EnemyId(enArr);
					EnemyGen(enemyId); break;
            case 14:System.out.println("  It looks like there was once a forge here"); 
					enArr = new int[]{0,6,7,8,14,15,23,26};
					enemyId = EnemyId(enArr);
					EnemyGen(enemyId); break;
            case 15:System.out.println("  rusted weapons and armour lay abandoned around you"); 
					enArr = new int[]{0,6,7,8,14,15,23};
					enemyId = EnemyId(enArr);
					EnemyGen(enemyId); break;
            case 16:System.out.println("  The ground before you falls away into a seemingly endless abyss"); 
					enArr = new int[]{10,12,13,17,18,26,27,28,29};
					enemyId = EnemyId(enArr);
					EnemyGen(enemyId); break;
            case 17:System.out.println("  The air around you suddenly cools"); 
					enArr = new int[]{4,10,12,29};
					enemyId = EnemyId(enArr);
					EnemyGen(enemyId); break;
            case 18:System.out.println("  in front of you is a once-great statue of some forgotten hero"); 
					enArr = new int[]{0,6,9,11,19,20,28};
					enemyId = EnemyId(enArr);
					EnemyGen(enemyId); break;
            case 19:System.out.println("  A thick mist gathers around your feet"); 
					enArr = new int[]{4,5,10,12,17,29,31};
					enemyId = EnemyId(enArr);
					EnemyGen(enemyId); break;
            case 20:System.out.println("  You enter a mineshaft, long abandoned to rot and degradation"); 
					enArr = new int[]{0,1,2,3,7,9,23,31};
					enemyId = EnemyId(enArr);
					EnemyGen(enemyId); break;
            case 21:System.out.println("  You spot a chest placed discreetly in the corner"); //loot chest
					System.out.println("  you open the chest to see what's in it");
					/*gets loot (method or plain rng)*/ break; 
            case 22:System.out.println("  You spot a chest placed discreetly in the corner"); //trap chest
					enArr = new int[]{32};
					enemyId = EnemyId(enArr);
					EnemyGen(enemyId); break; 
            case 23:System.out.println("  A portal to some dark world floats omniously in front of you"); 
					enArr = new int[]{10,11,12};
					enemyId = EnemyId(enArr);
					EnemyGen(enemyId); break;
            case 24:System.out.println("  The floor is littered with the old bodies of would-be heroes"); 
					enArr = new int[]{0,6,10,19,23};
					enemyId = EnemyId(enArr);
					EnemyGen(enemyId); break;
            case 25:System.out.println("  the doorway to this room has strange runes scrawled across it - probably a warning"); 
					enArr = new int[]{2,13,20,21,24,30,31};
					enemyId = EnemyId(enArr);
					EnemyGen(enemyId); break;
            default:System.out.println("  A shopkeeper sits looking somewhat bored at his stall");
					Delay(null);
					Shop(null); break;
        }
    }
	
	private void LWeapons(int Id) {
        //legendary weapons
        switch (Id) {
            case 1:; //Excalibur
            break;
            case 2:; //Carved Basilisk Tooth
            break;
            case 3:; //Meat-Cleaver of the Damned
            break;
            case 4:; //spell: Dragonfire
            break;
            case 5:; //Gatling Crossbow
            break;
            case 6:; //spell: Freeze time
            break;
            case 7:; //The Lobotimizer
            break;
            case 8:; //Chain-and-Sickle 
            break;
            case 9:; //Mithril Hamaxe
            break;
            case 10:; //Fists of Fury
        }
    }
}
