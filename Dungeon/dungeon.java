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
				roomArr[i] = roomId; //if no dupes, add Id to array and generate room
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
    
    private static boolean isDuplicate(int roomArr[], int Id) //duplicate check function
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
        System.out.println("  note: non of these work at this stage of the program");
        System.out.println("  They may or may not be implemented later on");
        Delay(null);
    }
    
    private static void nextLevel(String[] args)
    {
        
    }
    
    private static void Delay(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String delay = s.nextLine();
    }

    private static int RoomId(int roomId)
    {
        Random r = new Random();
        roomId = r.nextInt(31)+1; //update with new room cases
        //change max random number to change shop spawn chance (E.g. 15 cases (rooms), max ran 20 = 1:4 spawn ratio)
        if (roomId > 25)
		{
			roomId = 26; //give shops one Id
		}
        return roomId; //pass RoomId back to Run
    }
    
	private static int EnemyId(int[] enArr)
    {
        Random r = new Random();
		int Id = r.nextInt(enArr.length);
		return enArr[Id];
    }
	
    private static void RoomGen(int Id)
    {	
        switch(Id)
        {
            //idea - make rooms interactive?
            //Also, code for room goes between case and it's respective break
            case -1:System.out.println("  This should not appear. if it does, room selection isn't working"); 
            Delay(null);
			int enArr[] = new int[]{}; //generates and sends enemy Id's to rng
			int enemyId = EnemyId(enArr);
			EnemyGen(enemyId);
            break;
            case 1: System.out.println("  You enter a crypt, probably once connected to a catacomb");
            Delay(null);
			int enArr[] = new int[]{};
			int enemyId = EnemyId(enArr);
			EnemyGen(enemyId);
            break;
            case 2: System.out.println("  You find yourself in a massive cavern"); 
            Delay(null);
			int enArr[] = new int[]{};
			int enemyId = EnemyId(enArr);
			EnemyGen(enemyId);
            break;
            case 3: System.out.println("  A long corridor stretches before you"); 
            Delay(null);
			int enArr[] = new int[]{};
			int enemyId = EnemyId(enArr);
			EnemyGen(enemyId);
            break;
            case 4: System.out.println("  An alter to some unknown deity stands wreathed in shadow"); 
            Delay(null);
			int enArr[] = new int[]{};
			int enemyId = EnemyId(enArr);
			EnemyGen(enemyId);
            break;
            case 5: System.out.println("  It seems you have stumbled upon a mass grave"); 
            Delay(null);
			int enArr[] = new int[]{};
			int enemyId = EnemyId(enArr);
			EnemyGen(enemyId);
            break;
            case 6: System.out.println("  shelves full of exotic potions and illegible tomes surround you"); 
            Delay(null);
			int enArr[] = new int[]{};
			int enemyId = EnemyId(enArr);
			EnemyGen(enemyId);
            break;
            case 7: System.out.println("  An evil darkness lurks in the corners of the room"); 
            Delay(null);
			int enArr[] = new int[]{};
			int enemyId = EnemyId(enArr);
			EnemyGen(enemyId);
            break;
            case 8: System.out.println("  thick threads of spider silk coat the ceiling and walls around you"); 
            Delay(null);
			int enArr[] = new int[]{};
			int enemyId = EnemyId(enArr);
			EnemyGen(enemyId);
            break;
            case 9: System.out.println("  The floor is littered with eggs. It seems to be a nest of some sort"); 
            Delay(null);
			int enArr[] = new int[]{};
			int enemyId = EnemyId(enArr);
			EnemyGen(enemyId);
            break;
            case 10:System.out.println("  You enter an unremarable little cave, recently inhabited..."); 
            Delay(null);
			int enArr[] = new int[]{};
			int enemyId = EnemyId(enArr);
			EnemyGen(enemyId);
            break;
            case 11:System.out.println("  In the darkness you barely avoid falling into the underground lake in front of you");
            Delay(null);
			int enArr[] = new int[]{};
			int enemyId = EnemyId(enArr);
			EnemyGen(enemyId);
            break;
            case 12:System.out.println("  Bones and other, fresher, remains, lay on the floor, surrounding a dark crevice in the wall"); 
            Delay(null);
			int enArr[] = new int[]{};
			int enemyId = EnemyId(enArr);
			EnemyGen(enemyId);
            break;
            case 13:System.out.println("  Strange symbols cover all this room's surfaces"); 
            Delay(null);
			int enArr[] = new int[]{};
			int enemyId = EnemyId(enArr);
			EnemyGen(enemyId);
            break;
            case 14:System.out.println("  It looks like there was once a forge here"); 
            Delay(null);
			int enArr[] = new int[]{};
			int enemyId = EnemyId(enArr);
			EnemyGen(enemyId);
            break;
            case 15:System.out.println("  rusted weapons and armour lay abandoned around you"); 
            Delay(null);
			int enArr[] = new int[]{};
			int enemyId = EnemyId(enArr);
			EnemyGen(enemyId);
            break;
            case 16:System.out.println("  The ground before you falls away into a seemingly endless abyss"); 
            Delay(null);
			int enArr[] = new int[]{};
			int enemyId = EnemyId(enArr);
			EnemyGen(enemyId);
            break;
            case 17:System.out.println("  The air around you suddenly cools"); 
            Delay(null);
			int enArr[] = new int[]{};
			int enemyId = EnemyId(enArr);
			EnemyGen(enemyId);
            break;
            case 18:System.out.println("  in front of you is a once-great statue of some forgotten hero"); 
            Delay(null);
			int enArr[] = new int[]{};
			int enemyId = EnemyId(enArr);
			EnemyGen(enemyId);
            break;
            case 19:System.out.println("  A thick mist gathers around your feet"); 
            Delay(null);
			int enArr[] = new int[]{};
			int enemyId = EnemyId(enArr);
			EnemyGen(enemyId);
            break;
            case 20:System.out.println("  You enter a mineshaft, long abandoned to rot and degradation"); 
            Delay(null);
			int enArr[] = new int[]{};
			int enemyId = EnemyId(enArr);
			EnemyGen(enemyId);
            break;
            case 21:System.out.println("  You spot a chest placed discreetly in the corner (loot)"); //loot chest
            Delay(null);
			int enArr[] = new int[]{};
			int enemyId = EnemyId(enArr);
			EnemyGen(enemyId);
            break; 
            case 22:System.out.println("  You spot a chest placed discreetly in the corner (trap)"); //trap chest
            Delay(null);
			int enArr[] = new int[]{};
			int enemyId = EnemyId(enArr);
			EnemyGen(enemyId);
            break; 
            case 23:System.out.println("  A portal to some dark world floats omniously in front of you"); 
            Delay(null);
			int enArr[] = new int[]{};
			int enemyId = EnemyId(enArr);
			EnemyGen(enemyId);
            break;
            case 24:System.out.println("  Various adventurers like you lay slumped on the floor, long since succumbed to the perils of the dungeon"); 
            Delay(null);
			int enArr[] = new int[]{};
			int enemyId = EnemyId(enArr);
			EnemyGen(enemyId);
            break;
            case 25:System.out.println("  the doorway to this room has strange runes scrawled across it - probably a warning"); 
            Delay(null);
			int enArr[] = new int[]{};
			int enemyId = EnemyId(enArr);
			EnemyGen(enemyId);
            break;
            default:System.out.println("  A shopkeeper sits looking somewhat bored at his stall"); 
            Delay(null);
			//call shopkeeper method
            break;
        }
    }
	
	private static void EnemyGen(int Id) //enemy Id list
	{
		
		System.out.println(Id);
		switch (Id)
		{
			case -1:; //debug
			Delay(null);
			break;
			case 0:; //Skeleton
			Delay(null);
			break;
			case 1:; //Spider
			Delay(null);
			break;
			case 2:; //Troll
			Delay(null);
			break;
			case 3:; //Snake
			Delay(null);
			break;
			case 4:; //Necromancer
			Delay(null);
			break;
			case 5:; //Wizard
			Delay(null);
			break;
			case 6:; //Skelton archer
			Delay(null);
			break;
			case 7:; //Goblin
			Delay(null);
			break;
			case 8:; //Outlaw
			Delay(null);
			break;
			case 9:; //Rat
			Delay(null);
			break;
			case 10:; //Wraith
			Delay(null);
			break;
			case 11:; //Fanatic
			Delay(null);
			break;
			case 12:; //Demon
			Delay(null);
			break;
			case 13:; //Dragon
			Delay(null);
			break;
			case 14:; //Orc
			Delay(null);
			break;
			case 15:; //Cave Dweller
			Delay(null);
			break;
			case 16:; //Leviathan
			Delay(null);
			break;
			case 17:; //Pixie
			Delay(null);
			break;
			case 18:; //Harpy
			Delay(null);
			break;
			case 19:; //Fallen Hero
			Delay(null);
			break;
			case 20:; //Guardian
			Delay(null);
			break;
			case 21:; //Carnivorous Plant
			Delay(null);
			break;
			case 22:; //Giant
			Delay(null);
			break;
			case 23:; //Looter
			Delay(null);
			break;
			case 24:; //Wyrm
			Delay(null);
			break;
			case 25:; //Possesed
			Delay(null);
			break;
			
		}
	}
}
