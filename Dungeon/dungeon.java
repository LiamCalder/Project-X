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
        System.out.println("  [Start]     [Quit]     [Controls]");
        String input = "";
        while (!input.equalsIgnoreCase("start"))
        {
			//option select
            System.out.print("  ");
            input = s.nextLine();
            if (input.equalsIgnoreCase("start"))
            {
                System.out.println("");
                System.out.println("  You descend the stairs...");
                //make game wait for user
                Delay(null);
				//run Room method and return room String and Id
				int catchRoomId = -1;
                int roomId = RoomId(catchRoomId);
				RoomGen(roomId);
				Delay(null);
				
				//outputs to JFrame instead of console
                /*JFrame f = new JFrame("ASCII");
                JLabel l = new  JLabel(room);
                l.setBounds(1,1,100,100);
                f.add(l);
                f.setSize(101,101);
                f.setLayout(null);
                f.setVisible(true);*/
            }
            else if (input.equalsIgnoreCase("quit"))
            {
                return;
            }
            else
            {
				Help(null);
                System.out.println("");
                System.out.println("  Do you want to enter The Dungeon?");
                System.out.println("  =================================");
                System.out.println("  [Start]     [Quit]     [Controls]");
            }
        }
        
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
    
    private static void Delay(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String delay = s.nextLine();
    }

    private static int RoomId(int roomId)
    {
        Random r = new Random();
		String room = "";
        int ran = r.nextInt(31)+1;
		//change max random number to change shop spawn chance (E.g. 15 cases, max 20 = 1:4 spawn ratio)
		roomId = ran;
        return roomId;
    }
	
	private static void RoomGen(int Id)
	{
		switch(Id)
        {
			//idea - make rooms interactive?
			case -1:System.out.println("  This should not appear. if it does, it's a bug"); break;
            case 1: System.out.println("  You enter a crypt, probably once connected to a catacomb"); break;
            case 2: System.out.println("  You find yourself in a massive cavern"); break;
            case 3: System.out.println("  A long corridor stretches before you"); break;
            case 4: System.out.println("  An alter to some unknown deity cakes the room in shadow"); break;
            case 5: System.out.println("  It seems you have stumbled upon a mass grave"); break;
            case 6: System.out.println("  shelves full of exotic potions and illegible tomes surround you"); break;
			case 7: System.out.println("  An evil darkness lurks in the corners of the room"); break;
			case 8: System.out.println("  thick threads of spider silk coat the ceiling and walls around you"); break;
			case 9: System.out.println("  The floor is littered with eggs. It seems to be a nest of some sort"); break;
			case 10:System.out.println("  You enter an unremarable little cave, recently inhabited..."); break;
			case 11:System.out.println("  In the darkness you barely avoid falling into the underground lake in front of you"); break;
			case 12:System.out.println("  Bones and other, fresher, remains, lay on the floor, surrounding a dark crevice in the wall"); break;
			case 13:System.out.println("  Strange symbols cover all this room's surfaces"); break;
			case 14:System.out.println("  It looks like there was once a forge here"); break;
			case 15:System.out.println("  rusted weapons and armour lay abandoned around you"); break;
			case 16:System.out.println("  The ground before you falls away into a seemingly endless abyss"); break;
			case 17:System.out.println("  The air around you suddenly cools"); break;
			case 18:System.out.println("  in front of you is a once-great statue of some forgotten hero"); break;
			case 19:System.out.println("  A thick mist gathers around your feet"); break;
			case 20:System.out.println("  You enter a mineshaft, long abandoned to rot and degradation"); break;
			case 21:System.out.println("  You spot a chest placed discreetly in the corner"); break; //loot chest
			case 22:System.out.println("  You spot a chest placed discreetly in the corner"); break; //trap chest
			case 23:System.out.println("  A portal to some dark world floats omniously in front of you"); break;
			case 24:System.out.println("  Various adventurers like you lay slumped on the floor, long since succumbed to the perils of the dungeon"); break;
			case 25:System.out.println("  the doorway to this room has strange runes scrawled across it - probably a warning"); break;
			default:System.out.println("  A shopkeeper sits looking somewhat bored at his stall"); break;
		}
	}
}
