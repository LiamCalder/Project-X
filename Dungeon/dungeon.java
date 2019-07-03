import java.util.*;
import java.io.*;

public class dungeon
{
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Welcome to Alpha testing");
		System.out.println("Do you want to enter... The Dungeon?");
		System.out.println("	[yes]	    [no]");
		String input = s.nextLine();
		if (input.equals("yes"))
		{
			System.out.println("good on you");
		}
		else
		{
			System.out.println("Yeah, that's probably smart");
		}
	}
}