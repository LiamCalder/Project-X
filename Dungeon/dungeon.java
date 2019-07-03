import java.util.*;
import java.io.*;
import java.lang.*;

public class dungeon
{
	public static void main(String[] args)
	{
		//set up beginning of game
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to Alpha testing");
		System.out.println("Do you want to enter The Dungeon?");
		System.out.println("	[Start]	    [Quit]");
		String input = "";
		while (!input.equalsIgnoreCase("start"))
		{
			input = s.nextLine();
			if (input.equalsIgnoreCase("start"))
			{
				System.out.println("You descend the stairs...");
				delay(null);
			
			}
			else if (input.equalsIgnoreCase("quit"))
			{
				return;
			}
		}
		System.out.println("just testing");
		
	}
	
	public static void delay(String[] args)
	{
		Scanner s = new Scanner(System.in);
		String delay = s.nextLine();
	}
}
