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
        System.out.println("  just testing");
        
    }
    
    public static void Delay(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String delay = s.nextLine();
    }

    public static String Room(String room)
    {
        Random r = new Random();
        int ran = r.nextInt(4)+1;
        
        System.out.println(ran);
        switch(ran)
        {
            case 1:room = "You enter a Crypt"; break;
            case 2:room = "The stairs open up to a massive cavern"; break;
            case 3:room = "A long corridor stretches before you"; break;
            case 4:room = "4"; break;
            case 5:room = "4"; break;
            case 6:room = "6"; break;
        }
        
        return room; 
    }
}
