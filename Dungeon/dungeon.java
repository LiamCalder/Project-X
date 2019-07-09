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
        System.out.println("  Welcome to Alpha testing");
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
        JLabel l = new  JLabel(room);
        l.setBounds(1,1,100,100);
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
            //gets loot (method?)
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
        
    }
    
    private static void Tier1(int Id) 
    {
        switch (Id)
        {
            case 1:; //Basic knife
            break;
            case 2:; //Flimsy sword
            break;
            case 3:; //Rusty shovel
            break;
            case 4:; //Vintage ceremonial blade
            break;
            case 5:; //Moldy brick
            break;
            case 6:; //Sack of sharp pebbles
            break;
            case 7:; //Stinky bucket
            break;
            case 8:; //Poorly made Bow
            break;
            case 9:; //Dirty clay shard
            break;
            case 10:; //Old skinning knife
            break;
            case 11:; //Unreliable crossbow
            break;
            case 12:; //Faulty forge hammer
            break;
            case 13:; //Blunt spear
            break;
            case 14:; //Shoddy club
            break;
            case 15:; //Child's slingshot
            break;
            case 16:; //Large stick
            break;
            case 17:; //Ordinary stone
        }
    }
    
    private static void Tier2(int Id) 
    {
        switch (Id)
        {
            case 1:; //Battle Scarred Broadsword
            break;
            case 2:; //Merchant's Shadow Daggers
            break;
            case 3:; //Commoner's concealed blade
            break;
            case 4:; //Traditional Wooden Bow
            break;
            case 5:; //Ordinary Mace
            break;
            case 6:; //Well Worn Axe
            break;
            case 7:; //Bloodied Machete
            break;
            case 8:; //Trusty arm-blades
            break;
            case 9:; //Quarterstaff
            break;
            case 10:; //Brass Knuckles
        }
    }
}
