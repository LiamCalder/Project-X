import java.util.*;
//import javax.swing.*;

public class dungeon
{
	//initialise Classes
	
	//Player and enemy classes
	Player p1 = new Player(null);
	
	//Melee weapons
    Weapon dagger          = new Melee("Dagger", 10);            
    Weapon sword           = new Melee("Sword", 10);             
	Weapon mace            = new Melee("Mace", 10);		        
    Weapon axe             = new Melee("Axe", 10);		        
    Weapon warHammer       = new Melee("War Hammer", 10);        
	Weapon quarterstaff    = new Melee("Quarterstaff", 10);      
	Weapon greatsword      = new Melee("Greatsword", 10);	    
    Weapon shank           = new Melee("Shank", 10);		        
    Weapon spear           = new Melee("Spear", 10);		        
    Weapon wristBlades    = new Melee("Wrist Blades", 10);      
    Weapon magicStaff     = new Melee("Magic Staff", 10);       
	Weapon claymore       = new Melee("Claymore", 10);          
    Weapon morningstar    = new Melee("Morningstar", 10);       
    Weapon pike           = new Melee("Pike", 10);              
    Weapon cutlass        = new Melee("Cutlass", 10);           
    Weapon chain          = new Melee("Chain", 10);		        
    Weapon nailedPlank    = new Melee("Nailed Plank", 10);      
	Weapon warScythe      = new Melee("War Scythe", 10);        
			
	//Ranged weapons
    Weapon shortbow       = new Ranged("Shortbow", 10);         
    Weapon longbow        = new Ranged("Longbow", 10);          
    Weapon shurikan       = new Ranged("Shurikan", 10);         
	Weapon crossbow       = new Ranged("Crossbow", 10);	        
           
	//Magic weapons
    Weapon flame          = new Magic("Fireball", 10);	        
    Weapon lightning      = new Magic("Lightning Bolt", 10);    
    Weapon frost          = new Magic("Ice Beam", 10);          
    Weapon sapping        = new Magic("Drain Speed", 10);       
    Weapon aura           = new Magic("Defensive Aura", 10);    
    Weapon speed          = new Magic("Swiftness", 10);         
    Weapon shift          = new Magic("Dimensional Shift", 10); 
    Weapon fireWall       = new Magic("Wall Of Fire", 10);      
	
	//Enemies
	Weapon skeleton          = new Melee("Skeleton", 10);           
    Weapon spider            = new Melee("Dagger", 10);             
    Weapon troll             = new Melee("Troll", 10);              
    Weapon snake             = new Melee("Snake", 10);              
    Weapon necromancer       = new Magic("Necromancer", 10);        
    Weapon wizard            = new Magic("Wizard", 10);             
    Weapon skeletonArcher    = new Ranged("Skeleton Archer", 10);   
    Weapon goblin            = new Melee("Goblin", 10);             
    Weapon Outlaw            = new Melee("outlaw", 10);             
    Weapon caveRat           = new Melee("Cave Rat", 10);           
    Weapon wraith           = new Melee("Wraith", 10);             
    Weapon fanatic          = new Melee("Fantic", 10);             
    Weapon demon            = new Magic("Demon", 10);              
    Weapon Dragon           = new Melee("Dragon", 10);             
    Weapon orc              = new Melee("Orc", 10);                
    Weapon vampire          = new Magic("Vampire", 10);            
    Weapon leviathan        = new Melee("Leviathan", 10);          
    Weapon pixie            = new Magic("Pixie", 10);              
    Weapon harpy            = new Melee("Harpy", 10);              
    Weapon fallenHero       = new Melee("Fallen Hero", 10);        
    Weapon Guardian         = new Melee("Guardian", 10);           
    Weapon carnPlant        = new Melee("Carnivorous Plant", 10);  
    Weapon giant            = new Melee("Giant", 10);              
    Weapon looter           = new Melee("Looter", 10);             
    Weapon wyrm             = new Melee("Wyrm", 10);               
    Weapon cursedSoul       = new Melee("Cursed Soul", 10);        
    Weapon fElemental       = new Ranged("Fire Elemental", 10);    
    Weapon wElemental       = new Ranged("Water Elemental", 10);   
    Weapon eElemental       = new Ranged("Earth Elemental", 10);   
    Weapon aElemental       = new Ranged("Air Elemental", 10);     
    Weapon basilisk         = new Melee("Basilisk", 10);           
    Weapon golem            = new Melee("Rock Golem", 10);         
    Weapon mimic            = new Melee("Mimic", 10);
	
    public static void main(String[] args)
    {
        //set up beginning of game
        Scanner s = new Scanner(System.in);
        System.out.println("");
        System.out.println("  Do you want to enter The Dungeon?");
        System.out.println("  =================================");
        System.out.println("  [Start] [Quit] [Help] [Controls]");
        String input = "";
        while (!input.equalsIgnoreCase("start"))
        {
            //option select
            System.out.print("  ");
            input = s.nextLine();
            if (input.equalsIgnoreCase("start"))
            {
                LevelChain(null);//level method
            }
            else if (input.equalsIgnoreCase("quit"))
            {
                System.exit(1);
            }
            else if (input.equalsIgnoreCase("controls"))
            {
                Controls(null);
                System.out.println("");
                System.out.println("  Do you want to enter The Dungeon?");
                System.out.println("  =================================");
                System.out.println("  [Start] [Quit] [Help] [Controls]");
            }
            else
            {
                Help(null);
                System.out.println("");
                System.out.println("  Do you want to enter The Dungeon?");
                System.out.println("  =================================");
                System.out.println("  [Start] [Quit] [Help] [Controls]");
            }
        }
        
    }
    
    private static void LevelChain(String[] args)
    {
        System.out.println("");
        System.out.println("  You descend the stairs...");
                
        Delay(null); //make game wait for user
        Random r = new Random();
        int vary = r.nextInt(3)+4; //variation on number of levels
        int roomArr[] = new int[vary]; //create array of vary length
        for (int i=0; i<vary; i++)
        {
            //call RoomId and grab Id
            int checkRoomId = -1;
            int roomId = RoomId(checkRoomId);
            boolean isDup = isDuplicate(roomArr, roomId); //check for duplicates
            if (isDup == true)
            {
                i--;
            }
            else
            {
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
    
    private static boolean isDuplicate(int roomArr[], int Id) //duplicate room check function
    {
        for (int i=0; i<roomArr.length; i++)
        {
            if (Id == roomArr[i])
            {
                return true;
            } 
        }
        return false;
    }
    
    private static void Help(String[] args)
    {
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
    
    private static void Controls(String[] args)
    {
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
    
    private static void NextLevel(String[] args)
    {
        //This method will bump up enemy stats, loot spawns etc
		System.out.println("  You find a staircase leading deeper into the dungeon");
		LevelChain(null); //then restart LevelChain
    }
    
    private static void Delay(String[] args) //wait for user function
    {
        Scanner s = new Scanner(System.in);
        String delay = s.nextLine();
        if (delay.equalsIgnoreCase("?"))
        {
            Help(null);
        }
		if (delay.equalsIgnoreCase("quit"))
		{
			System.exit(1);
		}
    }

    private static int RoomId(int roomId) //room Id list
    {
        Random r = new Random();
        roomId = r.nextInt(31)+1; //update with new room cases
        //change max random number to change shop spawn chance (E.g. 15 cases (rooms), max ran 20 = 1:4 spawn ratio)
        if (roomId > 25)
        {
            roomId = 26; //give shops one Id
        }
        return roomId; //pass RoomId back to Caller
    }
    
    private static int EnemyId(int[] enArr)
    {
        Random r = new Random();
        int Id = r.nextInt(enArr.length);
        return enArr[Id];
    }
    
	private static void Battle(Weapon w)
    {
		String input = "";
		while (!input.equalsIgnoreCase("weapon") && !input.equalsIgnoreCase("spell") && !input.equalsIgnoreCase("health") && !input.equalsIgnoreCase("mana"))
		{
			Scanner s = new Scanner(System.in);
			
			//debug stats
			System.out.println("  Enemy Stats: ");
			System.out.println("  Damage = ");
			System.out.println("  Speed = ");
			System.out.println("  Health = ");
			System.out.println("");
			System.out.println("  Your Stats: ");
			System.out.println("  Damage = ");
			System.out.println("  Speed = ");
			System.out.println("  Health = ");
			System.out.println("");
			System.out.println("  What will you do?");
			System.out.println("  =================");
			System.out.println("  [Weapon] | [Spell]");
			System.out.println("  - - - - - - - - -");
			System.out.println("  [Health] | [Mana]");
			System.out.print("  ");
			input = s.nextLine();
			if (input.equalsIgnoreCase("weapon")) 
			{
				//attack with weapon stats
				System.out.println("");
				System.out.println("  You attack with your weapon");
				//enemy turn method
			}
			else if (input.equalsIgnoreCase("spell"))
			{
				//attack with spell stats
				System.out.println("");
				System.out.println("  You cast your spell");
				//enemy turn method
			}
			else if (input.equalsIgnoreCase("health"))
			{
				//use health potion if availiable
				System.out.println("");
				System.out.println("  You feel your wounds mending");
				//enemy turn method
			}
			else if (input.equalsIgnoreCase("mana"))
			{
				//use mana potion if availiable
				System.out.println("");
				System.out.println("  Your mana is revitalized");
				//enemy turn method
			}
			else
			{
				System.out.println("  Not a valid option. Enter '?' for help");
			}
			
			Delay(null);
		}
    }
	
	private static void Shop(String[] args)
	{
		System.out.println("  Shop Stuff");
		Delay(null);
	}
	
	private void Weapons(int Id)
    {
        //weapon list
        //spells will be learned from books, but will be balanced with limited mana/cooldowns etc
		switch (Id)
        {
			//Melee weapons
            case 1:Weapon dagger          = new Melee("Dagger", 10);           break;
            case 2:Weapon sword           = new Melee("Sword", 10);            break;
			case 3:Weapon mace            = new Melee("Mace", 10);		       break;
            case 4:Weapon axe             = new Melee("Axe", 10);		       break;
            case 5:Weapon warHammer       = new Melee("War Hammer", 10);       break;
			case 6:Weapon quarterstaff    = new Melee("Quarterstaff", 10);     break;
			case 7:Weapon greatsword      = new Melee("Greatsword", 10);	   break;
            case 8:Weapon shank           = new Melee("Shank", 10);		       break;
            case 9:Weapon spear           = new Melee("Spear", 10);		       break;
            case 10:Weapon wristBlades    = new Melee("Wrist Blades", 10);     break;
            case 11:Weapon magicStaff     = new Melee("Magic Staff", 10);      break;
			case 12:Weapon claymore       = new Melee("Claymore", 10);         break;
            case 13:Weapon morningstar    = new Melee("Morningstar", 10);      break;
            case 14:Weapon pike           = new Melee("Pike", 10);             break;
            case 15:Weapon cutlass        = new Melee("Cutlass", 10);          break;
            case 16:Weapon chain          = new Melee("Chain", 10);		       break;
            case 17:Weapon nailedPlank    = new Melee("Nailed Plank", 10);     break;
			case 18:Weapon warScythe      = new Melee("War Scythe", 10);       break;
			
			//Ranged weapons
            case 19:Weapon shortbow       = new Ranged("Shortbow", 10);        break;
            case 20:Weapon longbow        = new Ranged("Longbow", 10);         break;
            case 21:Weapon shurikan       = new Ranged("Shurikan", 10);        break;
			case 22:Weapon crossbow       = new Ranged("Crossbow", 10);	       break;
           
		    //Magic weapons
            case 23:Weapon flame          = new Magic("Fireball", 10);	       break;
            case 24:Weapon lightning      = new Magic("Lightning Bolt", 10);   break;
            case 25:Weapon frost          = new Magic("Ice Beam", 10);         break;
            case 26:Weapon sapping        = new Magic("Drain Speed", 10);      break;
            case 27:Weapon aura           = new Magic("Defensive Aura", 10);   break;
            case 28:Weapon speed          = new Magic("Swiftness", 10);        break;
            case 29:Weapon shift          = new Magic("Dimensional Shift", 10);break;
            case 30:Weapon fireWall       = new Magic("Wall Of Fire", 10);     break;
        }
    }
	
    private static void RoomGen(int Id)
    {   
        int enArr[];
        int enemyId;
        
        switch(Id)
        {
            //idea - make rooms interactive?
            //Also, code for room goes between case and it's respective break
            case -1:System.out.println("  This should not appear. if it does, roomId wasn't called"); 
            Delay(null);
            enArr = new int[]{-1}; //any number in curly brackets reperesents possible enemy spawns in room via Id#
            enemyId = EnemyId(enArr);
            EnemyGen(enemyId);
            break;
            case 1: System.out.println("  You enter a crypt, probably once connected to a catacomb");
            Delay(null);
            enArr = new int[]{0,4,6,19,23,25};
            enemyId = EnemyId(enArr);
            EnemyGen(enemyId);
            break;
            case 2: System.out.println("  You find yourself in a massive cavern"); 
            Delay(null);
            enArr = new int[]{1,2,7,13,17,18,22,29};
            enemyId = EnemyId(enArr);
            EnemyGen(enemyId);
            break;
            case 3: System.out.println("  A long corridor stretches before you"); 
            Delay(null);
            enArr = new int[]{1,3,9,15,17,20,31};
            enemyId = EnemyId(enArr);
            EnemyGen(enemyId);
            break;
            case 4: System.out.println("  An alter to some unknown deity stands wreathed in shadow"); 
            Delay(null);
            enArr = new int[]{4,5,10,11,12,25};
            enemyId = EnemyId(enArr);
            EnemyGen(enemyId);
            break;
            case 5: System.out.println("  It seems you have stumbled upon a mass grave"); 
            Delay(null);
            enArr = new int[]{0,6,9,15,19,23};
            enemyId = EnemyId(enArr);
            EnemyGen(enemyId);
            break;
            case 6: System.out.println("  shelves full of exotic potions and illegible tomes surround you"); 
            Delay(null);
            enArr = new int[]{4,5,11,12,30};
            enemyId = EnemyId(enArr);
            EnemyGen(enemyId);
            break;
            case 7: System.out.println("  An evil darkness lurks in the corners of the room"); 
            Delay(null);
            enArr = new int[]{10,11,12,25};
            enemyId = EnemyId(enArr);
            EnemyGen(enemyId);
            break;
            case 8: System.out.println("  thick threads of spider silk coat the ceiling and walls around you"); 
            Delay(null);
            enArr = new int[]{1};
            enemyId = EnemyId(enArr);
            EnemyGen(enemyId);
            break;
            case 9: System.out.println("  The floor is littered with eggs. It seems to be a nest of some sort"); 
            Delay(null);
            enArr = new int[]{1,3,13,30};
            enemyId = EnemyId(enArr);
            EnemyGen(enemyId);
            break;
            case 10:System.out.println("  You enter an unremarable little cave, recently inhabited..."); 
            Delay(null);
            enArr = new int[]{2,5,7,8,11,14,15,23};
            enemyId = EnemyId(enArr);
            EnemyGen(enemyId);
            break;
            case 11:System.out.println("  In the darkness you barely avoid falling into the underground lake in front of you");
            Delay(null);
            enArr = new int[]{16,17,18,24,27,30};
            enemyId = EnemyId(enArr);
            EnemyGen(enemyId);
            break;
            case 12:System.out.println("  Bones and other, fresher, remains, lay on the floor, surrounding a dark crevice in the wall"); 
            Delay(null);
            enArr = new int[]{2,3,13,16,21,22,24,30};
            enemyId = EnemyId(enArr);
            EnemyGen(enemyId);
            break;
            case 13:System.out.println("  Strange symbols cover all this room's surfaces"); 
            Delay(null);
            enArr = new int[]{4,5,11,12,15,20,25};
            enemyId = EnemyId(enArr);
            EnemyGen(enemyId);
            break;
            case 14:System.out.println("  It looks like there was once a forge here"); 
            Delay(null);
            enArr = new int[]{0,6,7,8,14,15,23,26};
            enemyId = EnemyId(enArr);
            EnemyGen(enemyId);
            break;
            case 15:System.out.println("  rusted weapons and armour lay abandoned around you"); 
            Delay(null);
            enArr = new int[]{0,6,7,8,14,15,23};
            enemyId = EnemyId(enArr);
            EnemyGen(enemyId);
            break;
            case 16:System.out.println("  The ground before you falls away into a seemingly endless abyss"); 
            Delay(null);
            enArr = new int[]{10,12,13,17,18,26,27,28,29};
            enemyId = EnemyId(enArr);
            EnemyGen(enemyId);
            break;
            case 17:System.out.println("  The air around you suddenly cools"); 
            Delay(null);
            enArr = new int[]{4,10,12,29};
            enemyId = EnemyId(enArr);
            EnemyGen(enemyId);
            break;
            case 18:System.out.println("  in front of you is a once-great statue of some forgotten hero"); 
            Delay(null);
            enArr = new int[]{0,6,9,11,19,20,28};
            enemyId = EnemyId(enArr);
            EnemyGen(enemyId);
            break;
            case 19:System.out.println("  A thick mist gathers around your feet"); 
            Delay(null);
            enArr = new int[]{4,5,10,12,17,29,31};
            enemyId = EnemyId(enArr);
            EnemyGen(enemyId);
            break;
            case 20:System.out.println("  You enter a mineshaft, long abandoned to rot and degradation"); 
            Delay(null);
            enArr = new int[]{0,1,2,3,7,9,23,31};
            enemyId = EnemyId(enArr);
            EnemyGen(enemyId);
            break;
            case 21:System.out.println("  You spot a chest placed discreetly in the corner"); //loot chest
			Delay(null);
            System.out.println("  you open the chest to see what's in it");
            //gets loot (method or plain rng)
            Delay(null);
            break; 
            case 22:System.out.println("  You spot a chest placed discreetly in the corner"); //trap chest
            Delay(null);
            enArr = new int[]{32};
            enemyId = EnemyId(enArr);
            EnemyGen(enemyId);
            break; 
            case 23:System.out.println("  A portal to some dark world floats omniously in front of you"); 
            Delay(null);
            enArr = new int[]{10,11,12};
            enemyId = EnemyId(enArr);
            EnemyGen(enemyId);
            break;
            case 24:System.out.println("  The floor is littered with the old bodies of would-be heroes"); 
            Delay(null);
            enArr = new int[]{0,6,10,19,23};
            enemyId = EnemyId(enArr);
            EnemyGen(enemyId);
            break;
            case 25:System.out.println("  the doorway to this room has strange runes scrawled across it - probably a warning"); 
            Delay(null);
            enArr = new int[]{2,13,20,21,24,30,31};
            enemyId = EnemyId(enArr);
            EnemyGen(enemyId);
            break;
            default:System.out.println("  A shopkeeper sits looking somewhat bored at his stall");
            Delay(null);
            Shop(null);
            break;
        }
    }
	
    private static void EnemyGen(int Id) //enemy Id list
    {
        switch (Id)
        {
            case 0:Enemy en = new Enemy(100);          break;
            case 1:Weapon spider            = new Melee("Dagger", 10);            break;
            case 2:Weapon troll             = new Melee("Troll", 10);             break;
            case 3:Weapon snake             = new Melee("Snake", 10);             break;
            case 4:Weapon necromancer       = new Magic("Necromancer", 10);       break;
            case 5:Weapon wizard            = new Magic("Wizard", 10);            break;
            case 6:Weapon skeletonArcher    = new Ranged("Skeleton Archer", 10);  break;
            case 7:Weapon goblin            = new Melee("Goblin", 10);            break;
            case 8:Weapon Outlaw            = new Melee("outlaw", 10);            break;
            case 9:Weapon caveRat           = new Melee("Cave Rat", 10);          break;
            case 10:Weapon wraith           = new Melee("Wraith", 10);            break;
            case 11:Weapon fanatic          = new Melee("Fantic", 10);            break;
            case 12:Weapon demon            = new Magic("Demon", 10);             break;
            case 13:Weapon Dragon           = new Melee("Dragon", 10);            break;
            case 14:Weapon orc              = new Melee("Orc", 10);               break;
            case 15:Weapon vampire          = new Magic("Vampire", 10);           break;
            case 16:Weapon leviathan        = new Melee("Leviathan", 10);         break;
            case 17:Weapon pixie            = new Magic("Pixie", 10);             break;
            case 18:Weapon harpy            = new Melee("Harpy", 10);             break;
            case 19:Weapon fallenHero       = new Melee("Fallen Hero", 10);       break;
            case 20:Weapon Guardian         = new Melee("Guardian", 10);          break;
            case 21:Weapon carnPlant        = new Melee("Carnivorous Plant", 10); break;
            case 22:Weapon giant            = new Melee("Giant", 10);             break;
            case 23:Weapon looter           = new Melee("Looter", 10);            break;
            case 24:Weapon wyrm             = new Melee("Wyrm", 10);              break;
            case 25:Weapon cursedSoul       = new Melee("Cursed Soul", 10);       break;
            case 26:Weapon fElemental       = new Ranged("Fire Elemental", 10);   break;
            case 27:Weapon wElemental       = new Ranged("Water Elemental", 10);  break;
            case 28:Weapon eElemental       = new Ranged("Earth Elemental", 10);  break;
            case 29:Weapon aElemental       = new Ranged("Air Elemental", 10);    break;
            case 30:Weapon basilisk         = new Melee("Basilisk", 10);          break;
            case 31:Weapon golem            = new Melee("Rock Golem", 10);        break;
            case 32:Weapon mimic            = new Melee("Mimic", 10);             
					System.out.print("  it's a mimic!");
					return;
        }
    }
	
    private void QualityT1(int Id) 
    {
        //Only negative effects on stats
        switch (Id)
        {
            case 1:; //Basic - no effects
            break;
            case 2:; //Flimsy
            break;
            case 3:; //Rusty
            break;
            case 4:; //Vintage
            break;
            case 5:; //Moldy
            break;
            case 6:; //Old
            break;
            case 7:; //Stinky
            break;
            case 8:; //Poorly made
            break;
            case 9:; //Dirty
            break;
            case 10:; //Small
            break;
            case 11:; //Unreliable 
            break;
            case 12:; //Faulty
            break;
            case 13:; //Blunt
            break;
            case 14:; //Shoddy
            break;
            case 15:; //Child's
            break;
            case 16:; //Cheap
            break;
            case 17:; //Ordinary
            break;
            case 18:; //Slow
            break;
            case 19:; //Broken
            break;
        }
    }
    
    private void QualityT2(int Id) 
    {
        //Mixed effects on stats or small buff
        switch (Id)
        {
            case 1:; //Light
            break;
            case 2:; //Heavy
            break;
            case 3:; //Dense
            break;
            case 4:; //Nimble
            break;
            case 5:; //Quick
            break;
            case 6:; //Battle-tested
            break;
            case 7:; //Bloodied
            break;
            case 8:; //Raging
            break;
            case 9:; //Sharp
            break;
            case 10:; //Balanced
            break;
            case 11:; //Large
            break;
            case 12:; //Small
            break;
            case 13:; //Modified
            break;
            case 14:; //Excited
            break;
        }
    }
    
     private void QualityT3(int Id) 
    {
        //good effects of stats
        switch (Id)
        {
            case 1:; //Enhanced
            break;
            case 2:; //Unnaturally fast
            break;
            case 3:; //Shielding
            break;
            case 4:; //Reinforced
            break;
            case 5:; //Long-reaching
            break;
            case 6:; //Magically-infused
            break;
            case 7:; //Dwarven
            break;
            case 8:; //Elven
            break;
            case 9:; //Improved
            break;
            case 10:; //New
            break;
            case 11:; //Imbued
            break;
            case 12:; //Worthy
            break;
            case 13:; //Strong
            break;
            case 14:; //Mighty
            break;
            case 15:; //Powerful
            break;
        }
    }
    
    private void QualityT4(int Id) 
    {
        //Special stat boosts
        switch (Id)
        {
            case 1:; //Flaming (cont. burn damage)
            break;
            case 2:; //Toxic (lower dodge of opp + small cont. damage)
            break;
            case 3:; //Grounding (flighing enemies lose dodge buff)
            break;
            case 4:; //Vampirical (chance to regain health on hit)
            break;
            case 5:; //Heroic (more damage to legendary beasts e.g. Dragons)
            break;
            case 6:; //Enchanted (more damage) - think of something
            break;
            case 7:; //Deadly (more damage) - think of something
            break;
            case 8:; //Holy (more damage to unholy monsters)
            break;
            case 9:; //Demonic (more damage to holy monsters)
            break;
            case 10:; //Perfect (more damage) - think of something
        }
    }
	
	private void LWeapons(int Id) 
    {
        //legendary weapons
        switch (Id)
        {
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
