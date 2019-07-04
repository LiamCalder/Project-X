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
            System.out.print("  ");
            input = s.nextLine();
            if (input.equalsIgnoreCase("start"))
            {
                System.out.println("");
                System.out.println("  You descend the stairs...");
                //make game wait for user
                Delay(null);
                String catchRoom = "";
                String room = Room(catchRoom);
                System.out.println(room);
				Delay(null);
                /*JFrame f = new JFrame("Ass key");
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
            else if (input.equalsIgnoreCase("controls"))
            {
                System.out.println("");
                System.out.println("  To correctly select an option,");
                System.out.println("  type exactly what is in the square");
                System.out.println("  brackets []. E.g. [Start] type ");
                System.out.println("  'start', or [i] type 'i'");
                Delay(null);
                System.out.println("");
                System.out.println("  Do you want to enter The Dungeon?");
                System.out.println("  =================================");
                System.out.println("  [Start]     [Quit]     [Controls]");
            }
        }
        //after start sequence
        
    }
    
    public static void Delay(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String delay = s.nextLine();
    }

    public static String Room(String room)
    {
        Random r = new Random();
        int ran = r.nextInt(13)+1;
        
        switch(ran)
        {
            case 1: room = "  You enter a Crypt"; break;
            case 2: room = "  You find yourself in a massive cavern"; break;
            case 3: room = "  A long corridor stretches before you"; break;
            case 4: room = "  An alter to some unknown deity stands omniously before you"; break;
            case 5: room = "  It seems you have stumbled upon a mass grave"; break;
            case 6: room = "  shelves full of exotic potions and illegible tomes surround you"; break;
			case 7: room = "  An evil darkness lurks in the corners of the room"; break;
			case 8: room = "  thick threads of spider silk coat the ceiling and walls around you"; break;
			case 9: room = "  The floor is littered with eggs. It seems to be a nest of some sort"; break;
			case 10: room = "  You enter an unremarable little cave, recently inhabited..."; break;
			case 11:room = "  In the darkness you barely avoid falling into the underground lake in front of you"; break;
			case 12:room = "  Bones and other, fresher, remains, lay on the floor, surrounding a dark crevice in the wall"; break;
			case 13:room = "  Strange symbols cover all this room's surfaces"; break;
			case 14:room = "  "; break;
		}
        
        return room; 
    }
}
