import java.util.*;
import java.io.*;
import java.lang.*;
import javax.swing.*;

public class dungeon
{
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
                Run(null);//main game method
            }
            else if (input.equalsIgnoreCase("quit"))
            {
                return;
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
    
    private static void Run(String[] args)
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
        System.out.println("  note: none of these work at this stage of the program");
        System.out.println("  They may or may not be implemented later on");
        Delay(null);
    }
    
    private static void nextLevel(String[] args)
    {
        //This method will bump up enemy stats, loot spawn etc and restart run
    }
    
    private static void Delay(String[] args) //wait for user function
    {
        Scanner s = new Scanner(System.in);
        String delay = s.nextLine();
        if (delay.equalsIgnoreCase("?"))
        {
            Help(null);
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
            System.out.println("  you get #loot!");
            //gets loot (method)
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
            case 24:System.out.println("  Various adventurers like you lay slumped on the floor, long since succumbed to the perils of the dungeon"); 
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
            //call (non-existent) shopkeeper method
            break;
        }
    }
    
    private static void EnemyGen(int Id) //enemy Id list
    {
        String name = "";
        switch (Id)
        {
            case -1:name = " -debug-"; //debug
            break;
            case 0:name = " skeleton"; //Skeleton
            break;
            case 1:name = " spider"; //Spider
            break;
            case 2:name = " troll"; //Troll
            break;
            case 3:name = " snake"; //Snake
            break;
            case 4:name = " necromancer"; //Necromancer
            break;
            case 5:name = " wizard"; //Wizard
            break;
            case 6:name = " skelton archer"; //Skelton archer
            break;
            case 7:name = " goblin"; //Goblin
            break;
            case 8:name = "n outlaw"; //Outlaw
            break;
            case 9:name = " cave rat"; //Rat
            break;
            case 10:name = " wraith"; //Wraith
            break;
            case 11:name = " fanatic"; //Fanatic
            break;
            case 12:name = " demon"; //Demon
            break;
            case 13:name = " dragon"; //Dragon
            break;
            case 14:name = "n orc"; //Orc
            break;
            case 15:name = " cave dweller"; //Cave Dweller
            break;
            case 16:name = " leviathan"; //Leviathan
            break;
            case 17:name = " pixie"; //Pixie
            break;
            case 18:name = " harpie"; //Harpy
            break;
            case 19:name = " fallen hero"; //Fallen Hero
            break;
            case 20:name = " guardian"; //Guardian
            break;
            case 21:name = " carnivorous plant"; //Carnivorous Plant
            break;
            case 22:name = " giant"; //Giant
            break;
            case 23:name = " looter"; //Looter
            break;
            case 24:name = " wyrm"; //Wyrm
            break;
            case 25:name = " cursed soul"; //Cursed soul
            break;
            case 26:name = " fire elemental"; //Fire Elemental
            break;
            case 27:name = " water elemental"; //Water Elemental
            break;
            case 28:name = " earth elemental"; //Earth Elemental
            break;
            case 29:name = " air elemental"; //Air Elemental
            break;
            case 30:name = " basilisk"; //Basilisk
            break;
            case 31:name = " rock golem"; //Rock Golem
            break;
            case 32: System.out.print("  it's a mimic!"); //Mimic
            System.out.println("  blah blah conflict"); //call battle method
            Delay(null);
            return;
        }
        
        System.out.print("  A"+name+" appears!");
        System.out.println("  blah blah conflict"); //call to battle method goes here
        Delay(null);
    }
    
    private static void battle(String[] args)
    {
        //self evident
    }
    
    private static void QualityT1(int Id) 
    {
        //Only negative effects on stats
        switch (Id)
        {
            case 1:; //Basic
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
    
    private static void QualityT2(int Id) 
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
    
     private static void QualityT3(int Id) 
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
    
    private static void QualityT4(int Id) 
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
    
    private static void Weapons(int Id)
    {
        //weapon list
        //spells will be learned from books, but will be balanced with limited mana/cooldowns etc
        switch (Id)
        {
            case 1:; //dagger
            break;
            case 2:; //sword
            break;
            case 3:; //shortbow
            break;
            case 4:; //longbow
            break;
            case 5:; //quartertaff
            break;
            case 6:; //mace
            break;
            case 7:; //axe
            break;
            case 8:; //war hammer
            break;
            case 9:; //crossbow
            break;
            case 10:; //greatsword
            break;
            case 11:; //shank
            break;
            case 12:; //spear
            break;
            case 13:; //wrist-mounted blades
            break;
            case 14:; //magic staff
            break;
            case 15:; //spell: flame
            break;
            case 16:; //spell: lightning
            break;
            case 17:; //spell: frost
            break;
            case 18:; //spell: sapping
            break;
            case 19:; //spell: aura
            break;
            case 20:; //spell: speed
            break;
            case 21:; //claymore
            break;
            case 22:; //morningstar
            break;
            case 23:; //pike
            break;
            case 24:; //cutlass
            break;
            case 25:; //chain
            break;
            case 26:; //nailed plank
            break;
            case 27:; //modified saw
            break;
            case 28:; //war scythe
            break;
            case 29:; //spell: dimensional shift
            break;
            case 30:; //spell: wall of fire
        }
    }
	
	private static void LWeapons(int Id) 
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
